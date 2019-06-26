package com.jinwoo.festa.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jinwoo.festa.R
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.presentation.model.EventModel
import org.jetbrains.anko.find

class EventListAdapter(val models: ArrayList<EventModel>): RecyclerView.Adapter<EventListAdapter.EventListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event_list, parent, false)
        return EventListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) = holder.bind(models[position])

    inner class EventListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemEventImage = itemView.find<ImageView>(R.id.item_event_image)
        val itemEventDate = itemView.find<TextView>(R.id.item_event_date)
        val itemEventName = itemView.find<TextView>(R.id.item_event_name)
        val itemEventHost = itemView.find<TextView>(R.id.item_event_host)
        val itemEventPrice = itemView.find<TextView>(R.id.item_event_price)

        fun bind(model: EventModel) {
            Log.d("model", model.toString())
            with(model) {
                Glide.with(itemEventImage).load(eventImageUrl).into(itemEventImage)
                itemEventDate.text = eventDate
                itemEventName.text = eventName
                itemEventHost.text = hostName
                itemEventPrice.text = ticketPriceRange
            }
        }
    }
}