package com.jinwoo.festa.domain.base

import io.reactivex.Flowable

abstract class UseCase<T, E> {

    abstract fun createFlowable(data: T): Flowable<E>
}