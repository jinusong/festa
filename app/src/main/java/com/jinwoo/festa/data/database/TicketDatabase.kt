package com.jinwoo.festa.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jinwoo.festa.data.database.dao.TicketDao
import com.jinwoo.festa.data.database.entity.Ticket

@Database(entities = [Ticket::class], version = 1)
abstract class TicketDatabase : RoomDatabase() {

    abstract val ticketDao: TicketDao

}