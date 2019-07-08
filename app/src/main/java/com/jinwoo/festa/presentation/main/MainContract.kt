package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.presentation.base.BaseContract
import com.jinwoo.festa.presentation.model.EventModel

interface MainContract{
    interface View: BaseContract.View {
        fun showEventListAdapter(models: ArrayList<EventModel>)
        fun createToast(text: String)
    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}