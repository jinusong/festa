package com.jinwoo.festa.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jinwoo.festa.data.database.entity.Event
import com.jinwoo.festa.data.database.entity.Like
import io.reactivex.Flowable

@Dao
interface LikeDao {
    @Query("SELECT * FROM `like` WHERE eventId = :eventId")
    fun getLike(eventId: Int): Like

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLike(vararg like: Like)
}