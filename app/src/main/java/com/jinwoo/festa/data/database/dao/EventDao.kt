package com.jinwoo.festa.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jinwoo.festa.data.database.entity.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM event")
    fun getEventList(): List<Event>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEventList(vararg event: Event)
}