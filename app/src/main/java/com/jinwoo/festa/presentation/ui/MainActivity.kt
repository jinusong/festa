package com.jinwoo.festa.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.jinwoo.festa.R
import com.jinwoo.festa.presentation.adapter.EventListAdapter
import com.jinwoo.festa.presentation.main.MainContract
import com.jinwoo.festa.presentation.model.EventModel
import com.jinwoo.festa.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject
import android.net.ConnectivityManager


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
    }

    override fun createToast(text: String) { toast(text) }
}
