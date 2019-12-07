package com.kilvish.autoassign.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kilvish.autoassign.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: UserViewModel by lazy {
        ViewModelProviders.of(this, factory)
            .get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }
}
