package com.kilvish.autoassign.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kilvish.autoassign.ui.agent.AgentViewModel
import com.kilvish.autoassign.di.CustomViewModelFactory
import com.kilvish.autoassign.di.ViewModelKey
import com.kilvish.autoassign.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AgentViewModel::class)
    abstract fun bindUserViewModel(agentViewModel: AgentViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}