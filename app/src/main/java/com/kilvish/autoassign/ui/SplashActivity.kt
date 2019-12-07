package com.kilvish.autoassign.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kilvish.autoassign.R
import com.kilvish.autoassign.ui.agent.AgentActivity
import com.kilvish.autoassign.ui.user.UserActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initTests()
    }

    private fun initTests(){
        setUserLaunch(launchUserDemo, UserActivity::class.java)
        setUserLaunch(launchAgentDemoHL, "HomeLoan")
        setUserLaunch(launchAgentDemoPL, "PersonalLoan")
    }

    private fun setUserLaunch(button: Button, cls: Class<*>){
        button.setOnClickListener { startActivity(Intent(this, cls)) }
    }

    private fun setUserLaunch(button: Button, type: String){
        button.setOnClickListener { startActivity(AgentActivity.newInstance(this, type)) }
    }

}
