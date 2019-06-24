package com.jinwoo.festa.data.entity

data class EventData(
    val name: String,
    val startDate: String,
    val tickets: ArrayList<TicketData>,
    val location: LocationData,
    val metadata: MetadataData,
    val hostOrganization: String
)