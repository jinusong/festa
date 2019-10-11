package com.jinwoo.festa.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jinwoo.festa.data.database.dao.LikeDao
import com.jinwoo.festa.data.database.entity.Like

@Database(entities = [Like::class], version = 1)
abstract class LikeDatabase : RoomDatabase() {

    abstract val likeDao: LikeDao

}