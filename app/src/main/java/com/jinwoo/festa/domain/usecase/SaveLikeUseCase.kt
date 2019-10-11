package com.jinwoo.festa.domain.usecase

import com.jinwoo.festa.domain.base.UseCase
import com.jinwoo.festa.domain.entity.EventService
import com.jinwoo.festa.domain.entity.LikeEntity
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class SaveLikeUseCase(val service: EventService, composite: CompositeDisposable)
    : UseCase<Unit, LikeEntity>(composite) {
    override fun createFlowable(like: LikeEntity): Flowable<Unit>
            = service.saveLike(like)
}