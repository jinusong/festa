package com.jinwoo.festa.data.entity

import com.google.gson.annotations.SerializedName

data class EventData(
    @SerializedName("eventId")
    val eventId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("tickets")
    val tickets: ArrayList<TicketData>,
    @SerializedName("location")
    val location: LocationData,
    @SerializedName("metadata")
    val metadata: MetadataData,
    @SerializedName("hostOrganization")
    val hostOrganization: HostData
)