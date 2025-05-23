package com.example.deepwork.deep_work_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.deepwork.deep_work_app.data.local.entities.Sessions
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface SessionsDao{
    @Query("SELECT * FROM sessions_table")
    fun getAllSessions(): Flow<List<Sessions>>

    @Insert
    suspend fun insertSession(session: Sessions)

    @Update
    fun updateSessions(session:Sessions)

    @Delete
    fun deleteSessions(session:Sessions)

    @Query("SELECT * FROM sessions_table WHERE session_id = :sessionId")
    suspend fun getSessionsById(sessionId: Int): Sessions

    @Query("SELECT * FROM sessions_table WHERE tag_id = :tagId ORDER BY start_time DESC")
     fun getSessionsByTag(tagId: Int): Flow<List<Sessions>>

    @Query("SELECT * FROM sessions_table WHERE start_time BETWEEN :startDate AND :endDate")
     fun getSessionsByDate(startDate: Date, endDate: Date): Flow<List<Sessions>>

    @Query("SELECT SUM(duration) FROM sessions_table")
    suspend fun getTotalFocusTime(): Long

    @Query("SELECT COUNT(*) FROM sessions_table")
    suspend fun getSessionCount(): Int

    @Query("SELECT AVG(duration) FROM sessions_table")
    suspend fun getAverageSessionDuration(): Double
}