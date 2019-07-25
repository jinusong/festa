package com.jinwoo.festa.presentation.eventdetail

import android.util.Log
import com.jinwoo.festa.domain.entity.EventEntity
import com.jinwoo.festa.domain.entity.LikeEntity
import com.jinwoo.festa.domain.usecase.GetEventDetailUseCase
import com.jinwoo.festa.domain.usecase.SaveLikeUseCase
import com.jinwoo.festa.presentation.base.BasePresenter
import com.jinwoo.festa.presentation.mapper.EventModelMapper
import io.reactivex.subscribers.DisposableSubscriber
import org.jetbrains.anko.getStackTraceString

class EventDetailPresenter(
    val getEventDetailUseCase: GetEventDetailUseCase,
    val saveLikeUseCase: SaveLikeUseCase,
    val eventModelMapper: EventModelMapper)
    : BasePresenter<EventDetailContract.View>(), EventDetailContract.Presenter {

    val eventId: Int by lazy { view.getEventId() }

    override fun createView(view: EventDetailContract.View) {
        super.createView(view)
        getEventDetailData(eventId)
    }

    override fun likeClick(isChecked: Boolean)
            = saveLikeUseCase.execute(LikeEntity(eventId, isChecked),
        object: DisposableSubscriber<Unit>() {
            override fun onNext(t: Unit?) {

            }

            override fun onComplete() {
                view.createToast("좋아요가 저장되었습니다!")
            }

            override fun onError(t: Throwable?) {
                view.createToast("좋아요가 저장되지 않았습니다.")
            }
    })

    private fun getEventDetailData(eventId: Int) {
        getEventDetailUseCase.execute(eventId,
            object: DisposableSubscriber<EventEntity>() {
                override fun onNext(t: EventEntity) {
                    view.showEventDetailData(eventModelMapper.mapFrom(t))
                }

                override fun onComplete() {
                    view.createToast("조회 성공")
                }

                override fun onError(t: Throwable?) {
                    Log.e("asd", t!!.getStackTraceString())
                    view.createToast("오류가 발생했습니다.")
                }
            })
    }

    override fun destroyView() {
        super.destroyView()
    }
}