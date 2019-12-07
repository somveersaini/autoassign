package com.kilvish.autoassign.di.module

import com.kilvish.autoassign.ui.agent.AgentActivity
import com.kilvish.autoassign.ui.user.UserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeAgentActivity(): AgentActivity

    @ContributesAndroidInjector
    abstract fun contributeUserActivity(): UserActivity
}