package com.kilvish.autoassign.data

import com.kilvish.autoassign.data.agent.AgentRepo
import com.kilvish.autoassign.data.agent.AgentService
import com.kilvish.autoassign.data.user.UserRepo
import com.kilvish.autoassign.data.user.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @Provides
    fun bindAgentRepo(retrofit: Retrofit): AgentRepo {
        return AgentRepo(retrofit.create(AgentService::class.java))
    }

    @Provides
    fun provideUserRepo(retrofit: Retrofit): UserRepo {
        return UserRepo(retrofit.create(UserService::class.java))
    }
}