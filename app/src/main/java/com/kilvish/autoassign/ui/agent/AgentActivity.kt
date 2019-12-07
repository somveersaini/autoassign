package com.kilvish.autoassign.ui.agent

import android.content.Context
import android.content.Intent
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
import kotlinx.android.synthetic.main.agent_content_layout.*
import kotlinx.android.synthetic.main.agent_init_layout.*
import kotlinx.android.synthetic.main.error_layout.*
import java.lang.StringBuilder
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


        val type = intent.getStringExtra(APP_TYPE) as String
        setOnClickListener(type)
        observeAgentViewModel()
    }

    private fun setOnClickListener(type: String) {
        approve.setOnClickListener { viewModel.postInitialState() }
        reject.setOnClickListener { viewModel.postInitialState() }
        auto_assign.setOnClickListener { viewModel.fetchAgentData(type) }
        retry_button.setOnClickListener { viewModel.postInitialState() }
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
        with(successState.agentData){
            id.text = "APP ID $aid"
            type.text = "TYPE $atype"

            val details = StringBuilder("Data \n")
            for ((key,value) in  aparams){
                details.append(key)
                details.append(" : ")
                details.append(value)
                details.append("\n")
            }
            params.text = details
        }
    }

    companion object {

        private const val APP_TYPE = "type"

        fun newInstance(context: Context, type: String): Intent =
            Intent(context, AgentActivity::class.java)
                .apply {
                    putExtra(APP_TYPE, type)
                }
    }


}
