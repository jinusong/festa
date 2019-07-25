package com.jinwoo.festa.presentation.eventdetail

import com.jinwoo.festa.presentation.base.BaseContract
import com.jinwoo.festa.presentation.model.EventModel

interface EventDetailContract {
    interface View: BaseContract.View {
        fun createToast(text: String)
        fun getEventId(): Int
        fun showEventDetailData(eventModel: EventModel)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun likeClick(isChecked: Boolean)
    }
}