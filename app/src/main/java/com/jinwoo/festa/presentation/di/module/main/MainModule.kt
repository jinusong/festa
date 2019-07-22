package com.jinwoo.festa.presentation.di.module.main

import android.content.Context
import com.jinwoo.festa.data.Api
import com.jinwoo.festa.data.database.EventDatabase
import com.jinwoo.festa.data.datasource.EventDataSource
import com.jinwoo.festa.data.datasource.EventDataSourceImpl
import com.jinwoo.festa.data.mapper.EventDataMapper
import com.jinwoo.festa.data.repository.EventRepositoryImpl
import com.jinwoo.festa.domain.entity.EventRepository
import com.jinwoo.festa.domain.entity.EventService
import com.jinwoo.festa.domain.entity.EventServiceImpl
import com.jinwoo.festa.domain.usecase.GetEventListUseCase
import com.jinwoo.festa.presentation.di.scope.ActivityScope
import com.jinwoo.festa.presentation.main.MainContract
import com.jinwoo.festa.presentation.main.MainPresenter
import com.jinwoo.festa.presentation.mapper.EventModelMapper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import androidx.room.Room
import com.jinwoo.festa.data.database.dao.EventDao


@Module
class MainModule {
    @ActivityScope
    @Provides
    fun provideEventDatabase(context: Context): EventDatabase
            = Room.databaseBuilder(context, EventDatabase::class.java, "event.db").build()

    @ActivityScope
    @Provides
    fun provideEventDao(database: EventDatabase): EventDao = database.eventDao

    @ActivityScope
    @Provides
    fun provideEventDataSource(api: Api, eventDao: EventDao): EventDataSource
            = EventDataSourceImpl(api, eventDao)

    @ActivityScope
    @Provides
    fun provideEventRepository(eventDataSource: EventDataSource, eventDataMapper: EventDataMapper): EventRepository
            = EventRepositoryImpl(eventDataSource, eventDataMapper)

    @ActivityScope
    @Provides
    fun provideEventService(eventRepository: EventRepository): EventService
            = EventServiceImpl(eventRepository)

    @ActivityScope
    @Provides
    fun provideGetEventListUseCase(eventService: EventService, composite: CompositeDisposable)
            = GetEventListUseCase(eventService, composite)

    @ActivityScope
    @Provides
    fun provideEventDataMapper(): EventDataMapper = EventDataMapper()

    @ActivityScope
    @Provides
    fun provideEventModelMapper(): EventModelMapper = EventModelMapper()

    @ActivityScope
    @Provides
    fun providePresenter(getEventListUseCase: GetEventListUseCase,
                         eventModelMapper: EventModelMapper): MainContract.Presenter
            = MainPresenter(getEventListUseCase, eventModelMapper)
}