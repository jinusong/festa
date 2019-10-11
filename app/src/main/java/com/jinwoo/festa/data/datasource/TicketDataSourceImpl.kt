package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.dao.TicketDao
import com.jinwoo.festa.data.database.entity.Ticket

class TicketDataSourceImpl(val dao: TicketDao): TicketDataSource {
    override fun getTickets(eventId: Int): List<Ticket>
            = dao.getTickets(eventId)

    override fun saveTickets(tickets: List<Ticket>)
            = dao.saveTickets(tickets)
}
