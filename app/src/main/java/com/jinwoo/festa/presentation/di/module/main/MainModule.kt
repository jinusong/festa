package com.jinwoo.festa.presentation.di.module.main

import com.jinwoo.festa.presentation.di.scope.ActivityScope
import com.jinwoo.festa.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainModule {
    @ActivityScope
    @Provides
    fun providePresenter(compositeDisposable: CompositeDisposable) = MainPresenter(compositeDisposable)
}