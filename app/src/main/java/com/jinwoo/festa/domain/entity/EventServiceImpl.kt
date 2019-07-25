package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable

class EventServiceImpl(val eventRepo: EventRepository,
                       val likeRepo: LikeRepository,
                       val ticketRepo: TicketRepository): EventService {

    override fun getEventList(pageSize: Int): Flowable<EventListEntity>
            = eventRepo.getEventList(pageSize)
            .doOnNext {
                eventRepo.saveLocalEventList(it)
                it.eventEntity.map { ticketRepo.saveTickets(it.tickets) }
            }
            .onErrorReturn { eventRepo.getLocalEventList() }

    override fun getEventDetail(eventId: Int): Flowable<EventEntity>
            = eventRepo.getEventDetail(eventId)
        .map {
            val like = likeRepo.getLike(eventId)

            if (like != null) it.like = like
            it.tickets = ticketRepo.getTickets(eventId)

            return@map it
        }

    override fun saveLike(like: LikeEntity): Flowable<Unit>
            = Flowable.just(Unit).doOnNext { likeRepo.saveLike(like) }
}