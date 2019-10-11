package com.jinwoo.festa.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jinwoo.festa.R
import com.jinwoo.festa.presentation.model.EventModel
import com.jinwoo.festa.presentation.model.TicketModel
import com.jinwoo.festa.presentation.ui.EventDetailActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class TicketListAdapter(val models: List<TicketModel>): RecyclerView.Adapter<TicketListAdapter.TicketListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event_tickets, parent, false)
        return TicketListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: TicketListViewHolder, position: Int) = holder.bind(models[position])

    inner class TicketListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ticketName = itemView.find<TextView>(R.id.item_event_tickets_name)
        val ticketPrice = itemView.find<TextView>(R.id.item_event_tickets_price)
        val ticketDescription = itemView.find<TextView>(R.id.item_event_tickets_description)
        val ticketRemainTicket = itemView.find<TextView>(R.id.item_event_tickets_remain_ticket)
        val ticketLimit = itemView.find<TextView>(R.id.item_event_tickets_limit)

        fun bind(model: TicketModel) {
            with(model) {
                ticketName.text = name
                ticketPrice.text = "₩$price"
                ticketDescription.text =  description
                ticketRemainTicket.text = "티켓이 ${quantity - count}장 남았습니다."
                ticketLimit.text = "1인당 ${limitPerUser}개까지 구매가능 합니다."
            }
        }
    }
}