package com.jinwoo.festa.data.mapper

import com.jinwoo.festa.data.database.entity.Ticket
import com.jinwoo.festa.data.entity.TicketData
import com.jinwoo.festa.domain.entity.TicketEntity
import com.jinwoo.festa.domain.mapper.Mapper

class TicketDataMapper: Mapper<ArrayList<TicketData>, ArrayList<TicketEntity>> {
    override fun mapFrom(from: ArrayList<TicketData>): ArrayList<TicketEntity>
            = ArrayList(from
        .map {
            TicketEntity(
                eventId = it.eventId,
                ticketId = it.ticketId,
                count = it.count,
                quantity = it.quantity,
                limitPerUser = it.limitPerUser,
                name = it.name,
                price = it.price
            )
        })

    fun mapDbToEntity(from: Ticket): TicketEntity
            = TicketEntity(
        eventId = from.eventId,
        ticketId = from.ticketId,
        count = from.count,
        quantity = from.quantity,
        limitPerUser = from.limitPerUser,
        name = from.name,
        price = from.price
    )

    fun mapEntityToDb(from: TicketEntity): Ticket
            = Ticket(
        eventId = from.eventId,
        ticketId = from.ticketId,
        count = from.count,
        quantity = from.quantity,
        limitPerUser = from.limitPerUser,
        name = from.name,
        price = from.price
    )
}