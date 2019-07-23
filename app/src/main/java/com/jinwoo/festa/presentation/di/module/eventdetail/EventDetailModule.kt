package com.jinwoo.festa.presentation.di.module.eventdetail

import com.jinwoo.festa.presentation.di.scope.ActivityScope
import com.jinwoo.festa.presentation.eventdetail.EventDetailContract
import com.jinwoo.festa.presentation.eventdetail.EventDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class EventDetailModule {
    @ActivityScope
    @Provides
    fun providePresenter(): EventDetailContract.Presenter
            = EventDetailPresenter()
}