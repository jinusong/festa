package com.jinwoo.festa.data.mapper

import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.entity.EventData
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.LikeEntity
import com.jinwoo.festa.domain.mapper.Mapper

class EventDataMapper: Mapper<EventData, EventEntity> {
    val ticketDataMapper = TicketDataMapper()
    val hostDataMapper = HostDataMapper()

    override fun mapFrom(from: EventData): EventEntity
            = EventEntity(
        eventId = from.eventId,
        eventName = from.name,
        startDate = from.startDate,
        endDate = from.endDate,
        tickets = ticketDataMapper.mapFrom(from.tickets),
        locationName = from.location.name,
        eventImageUrl = from.metadata.coverImage,
        eventContents = from.metadata.contents,
        hostName = hostDataMapper.mapFrom(from.hostOrganization).name,
        ticketPriceRange = "",
        like = LikeEntity(from.eventId, false)
    )

    fun mapEntityToDb(from: EventEntity): Event = Event(
        eventId = from.eventId,
        eventName = from.eventName,
        startDate = from.startDate,
        endDate = from.endDate,
        ticketPriceRange = from.ticketPriceRange,
        locationName = from.locationName,
        eventImageUrl = from.eventImageUrl,
        eventContents = from.eventContents,
        hostName = from.hostName
    )


    fun mapDbToEntity(from: Event): EventEntity =
        EventEntity(
            eventId = from.eventId,
            eventName = from.eventName,
            startDate = from.startDate,
            endDate = from.endDate,
            ticketPriceRange = from.ticketPriceRange,
            locationName = from.locationName,
            eventImageUrl = from.eventImageUrl,
            eventContents = from.eventContents,
            hostName = from.hostName,
            tickets = ArrayList(),
            like = LikeEntity(from.eventId, false)
        )
}