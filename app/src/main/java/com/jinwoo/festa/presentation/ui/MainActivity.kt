package com.jinwoo.festa.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.jinwoo.festa.R
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.presentation.adapter.EventListAdapter
import com.jinwoo.festa.presentation.main.MainContract
import com.jinwoo.festa.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.createView(this)
    }

    override fun setEventListAdapter(models: ArrayList<EventEntity>) {
        main_event_list.adapter = EventListAdapter(models)
        main_event_list.layoutManager = GridLayoutManager(this, 2 )
    }
}
