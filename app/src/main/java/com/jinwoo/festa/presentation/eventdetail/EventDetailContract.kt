package com.jinwoo.festa.presentation.eventdetail

import com.jinwoo.festa.presentation.base.BaseContract

interface EventDetailContract {
    interface View: BaseContract.View {
        fun createToast(text: String)
    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}