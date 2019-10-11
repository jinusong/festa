package com.jinwoo.festa.data.datasource

import com.jinwoo.festa.data.database.entity.Ticket

interface TicketDataSource {
    fun getTickets(eventId: Int): List<Ticket>

    fun saveTickets(tickets: List<Ticket>)
}