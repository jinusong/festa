package com.jinwoo.festa.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jinwoo.festa.R
import com.jinwoo.festa.presentation.adapter.TicketListAdapter
import com.jinwoo.festa.presentation.eventdetail.EventDetailContract
import com.jinwoo.festa.presentation.model.EventModel
import com.jinwoo.festa.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_event_detail.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import javax.inject.Inject

class EventDetailActivity: BaseActivity(), EventDetailContract.View {

    @Inject
    lateinit var presenter: EventDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
        presenter.createView(this)

        detail_event_like_check.onClick {
            val isChecked = detail_event_like_check.isChecked
            if (isChecked)
                detail_event_like_check.background = getDrawable(R.drawable.ic_favorite_pink_24dp)
            else
                detail_event_like_check.background = getDrawable(R.drawable.ic_favorite_border_black_24dp)

            presenter.likeClick(isChecked)
        }
    }

    override fun showEventDetailData(eventModel: EventModel) {
        with(eventModel) {
            detail_event_title_tv.text = eventName
            detail_event_host_tv.text = hostName
            detail_event_time_tv.text = "$startDate ~ \n$endDate"
            detail_event_location_tv.text = "장소: $locationName"
            detail_event_price_range_tv.text = "티켓: $ticketPriceRange"
            detail_event_description_tv.text = eventContents

            detail_event_ticket_rv.adapter = TicketListAdapter(tickets)
            detail_event_ticket_rv.layoutManager = LinearLayoutManager(this@EventDetailActivity)

            if (like.isLike) {
                detail_event_like_check.isChecked = true
                detail_event_like_check.background = getDrawable(R.drawable.ic_favorite_pink_24dp)
            }
            else {
                detail_event_like_check.isChecked = false
                detail_event_like_check.background = getDrawable(R.drawable.ic_favorite_border_black_24dp)
            }

            Glide.with(detail_event_img).load(eventImageUrl).into(detail_event_img)
        }
    }

    override fun getEventId(): Int = intent.getIntExtra("eventId", -1)

    override fun createToast(text: String) { toast(text) }
}