package com.jinwoo.festa.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jinwoo.festa.data.database.dao.EventDao
import com.jinwoo.festa.data.database.entity.Event

@Database(entities = [Event::class], version = 1)
abstract class EventDatabase : RoomDatabase() {

    abstract val eventDao: EventDao

}