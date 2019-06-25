package com.jinwoo.festa.presentation.ui.base

import com.jinwoo.festa.presentation.base.BaseContract
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity(), BaseContract.View {

    private lateinit var presenter: BaseContract.Presenter<*>

    override fun setPresenter(presenter: BaseContract.Presenter<*>) {
        this.presenter = presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }
}