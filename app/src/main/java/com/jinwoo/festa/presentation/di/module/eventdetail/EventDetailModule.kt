package com.jinwoo.festa.presentation.di.module.eventdetail

import android.content.Context
import androidx.room.Room
import com.jinwoo.festa.data.Api
import com.jinwoo.festa.data.database.EventDatabase
import com.jinwoo.festa.data.database.LikeDatabase
import com.jinwoo.festa.data.database.TicketDatabase
import com.jinwoo.festa.data.database.dao.EventDao
import com.jinwoo.festa.data.database.dao.LikeDao
import com.jinwoo.festa.data.database.dao.TicketDao
import com.jinwoo.festa.data.datasource.*
import com.jinwoo.festa.data.mapper.EventDataMapper
import com.jinwoo.festa.data.mapper.LikeDataMapper
import com.jinwoo.festa.data.mapper.TicketDataMapper
import com.jinwoo.festa.data.repository.EventRepositoryImpl
import com.jinwoo.festa.data.repository.LikeRepositoryImpl
import com.jinwoo.festa.data.repository.TicketRepositoryImpl
import com.jinwoo.festa.domain.entity.*
import com.jinwoo.festa.domain.usecase.GetEventDetailUseCase
import com.jinwoo.festa.domain.usecase.SaveLikeUseCase
import com.jinwoo.festa.presentation.di.scope.ActivityScope
import com.jinwoo.festa.presentation.eventdetail.EventDetailContract
import com.jinwoo.festa.presentation.eventdetail.EventDetailPresenter
import com.jinwoo.festa.presentation.mapper.EventModelMapper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class EventDetailModule {
    @ActivityScope
    @Provides
    fun provideEventDatabase(context: Context): EventDatabase
            = Room.databaseBuilder(context, EventDatabase::class.java, "event.db").build()

    @ActivityScope
    @Provides
    fun provideLikeDatabase(context: Context): LikeDatabase
            = Room.databaseBuilder(context, LikeDatabase::class.java, "like.db").build()

    @ActivityScope
    @Provides
    fun provideTicketDatabase(context: Context): TicketDatabase
            = Room.databaseBuilder(context, TicketDatabase::class.java, "ticket.db").build()

    @ActivityScope
    @Provides
    fun provideEventDao(database: EventDatabase): EventDao = database.eventDao

    @ActivityScope
    @Provides
    fun provideLikeDao(database: LikeDatabase): LikeDao = database.likeDao

    @ActivityScope
    @Provides
    fun provideTicketDao(database: TicketDatabase): TicketDao = database.ticketDao

    @ActivityScope
    @Provides
    fun provideEventDataSource(api: Api, eventDao: EventDao): EventDataSource
            = EventDataSourceImpl(api, eventDao)

    @ActivityScope
    @Provides
    fun provideLikeDataSource(likeDao: LikeDao): LikeDataSource
            = LikeDataSourceImpl(likeDao)

    @ActivityScope
    @Provides
    fun provideTicketDataSource(ticketDao: TicketDao): TicketDataSource
            = TicketDataSourceImpl(ticketDao)

    @ActivityScope
    @Provides
    fun provideEventRepository(eventDataSource: EventDataSource, eventDataMapper: EventDataMapper): EventRepository
            = EventRepositoryImpl(eventDataSource, eventDataMapper)

    @ActivityScope
    @Provides
    fun provideLikeRepository(likeDataSource: LikeDataSource, likeDataMapper: LikeDataMapper): LikeRepository
            = LikeRepositoryImpl(likeDataSource, likeDataMapper)

    @ActivityScope
    @Provides
    fun provideTicketRepository(ticketDataSource: TicketDataSource, ticketDataMapper: TicketDataMapper): TicketRepository
            = TicketRepositoryImpl(ticketDataSource, ticketDataMapper)

    @ActivityScope
    @Provides
    fun provideEventService(eventRepository: EventRepository,
                            likeRepository: LikeRepository, ticketRepository: TicketRepository): EventService
            = EventServiceImpl(eventRepository, likeRepository, ticketRepository)

    @ActivityScope
    @Provides
    fun provideGetEventDetailUseCase(eventService: EventService, composite: CompositeDisposable)
            = GetEventDetailUseCase(eventService, composite)

    @ActivityScope
    @Provides
    fun provideSaveLikeUseCase(eventService: EventService, composite: CompositeDisposable)
            = SaveLikeUseCase(eventService, composite)

    @ActivityScope
    @Provides
    fun provideEventDataMapper(): EventDataMapper = EventDataMapper()

    @ActivityScope
    @Provides
    fun provideLikeDataMapper(): LikeDataMapper = LikeDataMapper()

    @ActivityScope
    @Provides
    fun provideEventModelMapper(): EventModelMapper = EventModelMapper()

    @ActivityScope
    @Provides
    fun provideTicketDataMapper() = TicketDataMapper()

    @ActivityScope
    @Provides
    fun providePresenter(getEventListUseCase: GetEventDetailUseCase,
                         saveLikeUseCase: SaveLikeUseCase,
                         eventModelMapper: EventModelMapper
    ): EventDetailContract.Presenter
            = EventDetailPresenter(getEventListUseCase, saveLikeUseCase, eventModelMapper)
}