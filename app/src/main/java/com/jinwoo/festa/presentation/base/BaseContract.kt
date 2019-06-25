package com.jinwoo.festa.presentation.base

interface BaseContract {
    interface Presenter<T> {
        fun createView(view: T)
        fun destroyView()
    }
    interface View {
        fun setPresenter(presenter: Presenter<*>)
    }
}