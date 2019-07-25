package com.jinwoo.festa.data.repository

import com.jinwoo.festa.data.datasource.TicketDataSource
import com.jinwoo.festa.data.mapper.TicketDataMapper
import com.jinwoo.festa.domain.entity.TicketEntity
import com.jinwoo.festa.domain.entity.TicketRepository

class TicketRepositoryImpl(val datasource:  TicketDataSource, val ticketDataMapper: TicketDataMapper): TicketRepository {
    override fun getTickets(eventId: Int): List<TicketEntity>
            = datasource.getTickets(eventId).map { ticketDataMapper.mapDbToEntity(it) }

    override fun saveTickets(tickets: List<TicketEntity>)
            = datasource.saveTickets(tickets.map { ticketDataMapper.mapEntityToDb(it) })
}