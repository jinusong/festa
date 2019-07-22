package com.jinwoo.festa.presentation.mapper

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.TicketEntity
import com.jinwoo.festa.domain.mapper.Mapper
import com.jinwoo.festa.presentation.model.EventModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EventModelMapper: Mapper<EventEntity, EventModel> {

    override fun mapFrom(from: EventEntity): EventModel = EventModel(
        eventId = from.eventId,
        eventName = from.eventName,
        eventDate = createKoreaDate(from.eventDate),
        ticketPriceRange = createTicketPriceRange(from.tickets),
        locationName = from.locationName,
        eventImageUrl = from.eventImageUrl,
        hostName = from.hostName)



    private fun createTicketPriceRange(tickets: List<TicketEntity>): String {
        if (tickets.isEmpty()) return "외부 이벤트"
        else {
            val priceList = ArrayList<Int>()
            tickets.forEach { ticket -> priceList.add(ticket.price) }

            val topPrice = Collections.max(priceList)
            val rowPrice = Collections.min(priceList)

            if (topPrice == 0 && rowPrice == 0) return "무료"
            else if (topPrice == rowPrice) return "₩$topPrice"
            return "₩$rowPrice ~ ₩$topPrice"
        }
    }

    private fun createKoreaDate(ukTime: String): String {
        val transUk = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.UK)
        val transK = SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm", Locale.KOREA)
        val cal = Calendar.getInstance()

        cal.time = transUk.parse(ukTime)
        cal.add(Calendar.HOUR, 9)
        return transK.format(cal.time)
    }
}