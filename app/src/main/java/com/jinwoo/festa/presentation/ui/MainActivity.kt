package com.jinwoo.festa.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinwoo.festa.R
import com.jinwoo.festa.presentation.adapter.EventListAdapter
import com.jinwoo.festa.presentation.main.MainContract
import com.jinwoo.festa.presentation.model.EventModel
import com.jinwoo.festa.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.createView(this)
    }

    override fun showEventListAdapter(models: ArrayList<EventModel>) {
        main_event_list.adapter = EventListAdapter(models)
        main_event_list.layoutManager = GridLayoutManager(this, 2)
        addScrollListener()
    }

    override fun createToast(text: String) { toast(text) }

    override fun updateEventListAdapter(models: ArrayList<EventModel>) {
        val adapter = main_event_list.adapter as EventListAdapter
        adapter.models.addAll(models)
        adapter.notifyDataSetChanged()
    }

    private fun addScrollListener() {
        main_event_list.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
                if (!view.canScrollVertically(1)) presenter.showStartEventList()
            }
        })
    }
}
