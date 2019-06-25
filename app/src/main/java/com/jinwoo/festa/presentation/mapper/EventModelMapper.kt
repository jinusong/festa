package com.jinwoo.festa.presentation.mapper

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.mapper.Mapper
import com.jinwoo.festa.presentation.model.EventModel

class EventModelMapper: Mapper<EventEntity, EventModel> {
    override fun mapFrom(from: EventEntity): EventModel = EventModel(
        from.eventId,
        from.eventName,
        from.eventDate,
        from.ticketPriceRange,
        from.locationName,
        from.eventImageUrl,
        from.hostName
    )
}