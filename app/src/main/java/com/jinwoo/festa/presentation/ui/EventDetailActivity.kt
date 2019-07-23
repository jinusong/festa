package com.jinwoo.festa.presentation.ui

import android.os.Bundle
import com.jinwoo.festa.R
import com.jinwoo.festa.presentation.eventdetail.EventDetailContract
import com.jinwoo.festa.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_event_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class EventDetailActivity: BaseActivity(), EventDetailContract.View {

    @Inject
    lateinit var presenter: EventDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
        presenter.createView(this)

        detail_event_like_check.onClick {
            if (detail_event_like_check.isChecked) {
                detail_event_like_check.background = getDrawable(R.drawable.ic_favorite_pink_24dp)
            } else {
                detail_event_like_check.background = getDrawable(R.drawable.ic_favorite_border_black_24dp)
            }
        }
    }

    override fun createToast(text: String) {

    }
}