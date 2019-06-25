package com.jinwoo.festa.presentation.main

import com.jinwoo.festa.presentation.base.BaseContract

interface MainContract{
    interface View: BaseContract.View {

    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}