package com.kilvish.autoassign.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kilvish.autoassign.R
import com.kilvish.autoassign.databinding.ActivityUserBinding
import dagger.android.AndroidInjection
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
        observeAgentViewModel()
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
