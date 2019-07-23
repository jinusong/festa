package com.jinwoo.festa.presentation.di.module

import com.jinwoo.festa.presentation.di.module.eventdetail.EventDetailModule
import com.jinwoo.festa.presentation.di.module.main.MainModule
import com.jinwoo.festa.presentation.di.scope.ActivityScope
import com.jinwoo.festa.presentation.ui.EventDetailActivity
import com.jinwoo.festa.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun activityMain(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [EventDetailModule::class])
    abstract fun activityEventDetail(): EventDetailActivity
}