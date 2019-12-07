package com.kilvish.autoassign.ui.agent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kilvish.autoassign.R
import com.kilvish.autoassign.databinding.ActivityAgentBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class AgentActivity : AppCompatActivity() {


    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: AgentViewModel by lazy {
        ViewModelProviders.of(this, factory)
            .get(AgentViewModel::class.java)
    }

    private lateinit var binding: ActivityAgentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agent)
        binding.lifecycleOwner = this
        observeAgentViewModel()
    }

    private fun observeAgentViewModel() {
        viewModel.getAgentState()
            .observe(this, Observer<AgentViewState> { state -> render(state) })
    }

    private fun render(state: AgentViewState) {
        binding.viewState = state
        Log.d("viewState", state.toString())
        if (state is SuccessState) renderList(state)    }

    private fun renderList(successState: SuccessState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
