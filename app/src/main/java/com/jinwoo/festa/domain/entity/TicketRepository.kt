package com.jinwoo.festa.domain.entity

interface TicketRepository {
    fun getTickets(eventId: Int): List<TicketEntity>

    fun saveTickets(tickets: List<TicketEntity>)
}