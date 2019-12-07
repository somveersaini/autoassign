package com.kilvish.autoassign.di
import android.app.Application
import com.kilvish.autoassign.AutoAssign
import com.kilvish.autoassign.di.module.AppModule
import com.kilvish.autoassign.data.RepositoryModule
import com.kilvish.autoassign.di.module.UiModule
import com.kilvish.autoassign.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    UiModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AutoAssign)
}