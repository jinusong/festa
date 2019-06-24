package com.jinwoo.festa.presentation.di.component

import com.jinwoo.festa.presentation.di.app.BaseApp
import com.jinwoo.festa.presentation.di.module.ActivityModule
import com.jinwoo.festa.presentation.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(AppModule::class), (ActivityModule::class), (AndroidSupportInjectionModule::class)]
)
interface AppComponent: AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApp): AppComponent.Builder
        fun build(): AppComponent
    }
}