package com.jinwoo.festa.domain.entity

import io.reactivex.Flowable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EventServiceImpl(val repo: EventRepository): EventService {
    override fun getEventList(pageSize: Int): Flowable<ArrayList<EventEntity>>
            = repo.getEventList(pageSize).map { mapEventEntityList(it) }

    override fun getLocalEventList(): ArrayList<EventEntity>
            = repo.getLocalEventList()

    override fun saveLocalEventList(eventList: ArrayList<EventEntity>)
            = repo.saveLocalEventList(eventList)

    private fun mapEventEntityList(eventList: ArrayList<EventEntity>): ArrayList<EventEntity>
            = ArrayList(eventList.map { event ->
        event.ticketPriceRange = createTicketPriceRange(event)
        event.eventDate = createKoreaDate(event.eventDate)

        return@map event
    })

    private fun createTicketPriceRange(event: EventEntity): String {
        if (event.tickets.isEmpty()) return "외부 이벤트"
        else {
            val priceList = ArrayList<Int>()
            event.tickets.forEach { ticket -> priceList.add(ticket.price) }

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