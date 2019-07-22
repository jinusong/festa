package com.jinwoo.festa.presentation.model

data class EventListModel(
    val isRemote: Boolean,
    val eventModelList: List<EventModel>
)