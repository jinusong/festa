package com.jinwoo.festa.presentation.mapper

import com.jinwoo.festa.domain.entity.TicketEntity
import com.jinwoo.festa.domain.mapper.Mapper
import com.jinwoo.festa.presentation.model.TicketModel

class TicketModelMapper: Mapper<TicketEntity, TicketModel> {
    override fun mapFrom(from: TicketEntity): TicketModel
            = TicketModel(
        eventId = from.eventId,
        ticketId = from.ticketId,
        count = from.count,
        quantity = from.quantity,
        description = from.description,
        limitPerUser = from.limitPerUser,
        name = from.name,
        price = from.price
    )
}