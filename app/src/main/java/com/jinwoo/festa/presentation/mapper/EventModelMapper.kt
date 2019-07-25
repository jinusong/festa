package com.jinwoo.festa.presentation.mapper

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.TicketEntity
import com.jinwoo.festa.domain.mapper.Mapper
import com.jinwoo.festa.presentation.model.EventModel
import com.jinwoo.festa.presentation.model.LikeModel
import org.jsoup.Jsoup
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EventModelMapper: Mapper<EventEntity, EventModel> {

    val ticketModelMapper = TicketModelMapper()

    override fun mapFrom(from: EventEntity): EventModel
            = EventModel(
        eventId = from.eventId,
        eventName = from.eventName,
        startDate = createKoreaDate(from.startDate),
        endDate = createKoreaDate(from.endDate),
        tickets = from.tickets.map { ticketModelMapper.mapFrom(it) },
        ticketPriceRange = createTicketPriceRange(from.tickets, from.ticketPriceRange),
        locationName = from.locationName,
        eventImageUrl = from.eventImageUrl,
        eventContents = parseEventContentsHtml(from.eventContents),
        hostName = from.hostName,
        like = LikeModel(from.like.eventId, from.like.isLike)
    )

    private fun createTicketPriceRange(tickets: List<TicketEntity>, ticketPriceRange: String): String {
        if (tickets.isEmpty() && ticketPriceRange.isBlank()) return "외부 이벤트"
        else if (ticketPriceRange.isNotBlank()) return ticketPriceRange
        else {
            val priceList = ArrayList<Int>()
            tickets.map { ticket -> priceList.add(ticket.price) }

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

    private fun parseEventContentsHtml(html: String): String
            = Jsoup.parse(html).text()
}