package com.jinwoo.festa.data.mapper

import com.jinwoo.festa.data.entity.TicketData
import com.jinwoo.festa.domain.entity.TicketEntity
import com.jinwoo.festa.domain.mapper.Mapper

class TicketDataMapper: Mapper<ArrayList<TicketData>, ArrayList<TicketEntity>> {
    override fun mapFrom(from: ArrayList<TicketData>): ArrayList<TicketEntity>
            = ArrayList(from.map { TicketEntity(it.price) })
}