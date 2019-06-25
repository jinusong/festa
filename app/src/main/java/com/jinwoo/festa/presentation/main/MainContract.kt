package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.presentation.base.BaseContract

interface MainContract{
    interface View: BaseContract.View {
        fun setEventListAdapter(models: ArrayList<EventEntity>)
    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}