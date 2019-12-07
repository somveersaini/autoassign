package com.kilvish.autoassign.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kilvish.autoassign.R
import com.kilvish.autoassign.databinding.ActivityUserBinding
import com.kilvish.autoassign.utils.Utils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.error_layout.*
import kotlinx.android.synthetic.main.user_init_layout.*
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: UserViewModel by lazy {
        ViewModelProviders.of(this, factory)
            .get(UserViewModel::class.java)
    }

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        binding.lifecycleOwner = this
        supportActionBar?.title = "LOAN APPLICATION"
        observeAgentViewModel()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        carloan.setOnClickListener { submitApplicationRequest(Utils.CARLOAN) }
        homeloan.setOnClickListener { submitApplicationRequest(Utils.HOMELOAN) }
        eduloan.setOnClickListener { submitApplicationRequest(Utils.EDUCATIONLOAN) }
        retry_button.setOnClickListener { viewModel.postInitialState() }
    }

    private fun submitApplicationRequest(type: String){
        viewModel.submitApplicationData(
            type = type,
            custTitle = Utils.getRandomString(2, Utils.STRING_CHARACTERS),
            pannumber = Utils.getRandomString(10, Utils.INT_CHARACTERS),
            custName = Utils.getRandomString(16, Utils.STRING_CHARACTERS),
            dob = Utils.getRandomString(8, Utils.INT_CHARACTERS),
            aadharNumber = Utils.getRandomString(16, Utils.INT_CHARACTERS)

        )
    }

    private fun observeAgentViewModel() {
        viewModel.getUserViewState()
            .observe(this, Observer<UserViewState> { state -> render(state) })
    }

    private fun render(state: UserViewState) {
        binding.viewState = state
        Log.d("viewState", state.toString())
        if (state is SuccessState) renderList(state)    }

    private fun renderList(successState: SuccessState) {
        with(successState.userAppResponseData){
            val msg = if ("YES".equals(result)) {
                "Congrats. Loan Granted!!!"
            } else "Your Application is sent for approval"
            Toast.makeText(this@UserActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
