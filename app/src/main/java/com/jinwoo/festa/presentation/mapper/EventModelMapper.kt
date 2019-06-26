package com.jinwoo.festa.presentation.mapper

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.mapper.Mapper
import com.jinwoo.festa.presentation.model.EventModel

class EventModelMapper: Mapper<EventEntity, EventModel> {
    override fun mapFrom(from: EventEntity): EventModel = EventModel(
        eventId = from.eventId,
        eventName = from.eventName,
        eventDate = from.eventDate,
        ticketPriceRange = from.ticketPriceRange,
        locationName = from.locationName,
        eventImageUrl = from.eventImageUrl,
        hostName = from.hostName
    )
}