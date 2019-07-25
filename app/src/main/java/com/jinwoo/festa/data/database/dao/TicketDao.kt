package com.jinwoo.festa.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jinwoo.festa.data.database.entity.Ticket

@Dao
interface TicketDao {
    @Query("SELECT * FROM ticket WHERE eventId = :eventId")
    fun getTickets(eventId: Int): List<Ticket>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTickets(tickets: List<Ticket>)
}