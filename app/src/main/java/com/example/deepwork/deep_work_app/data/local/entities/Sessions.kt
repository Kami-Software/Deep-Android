package com.example.deepwork.deep_work_app.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "sessions_table",
    foreignKeys = [
        ForeignKey(entity = Tags::class,
            parentColumns = ["tag_id"],
            childColumns = ["tag_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Sessions(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "session_id") val sessionId: Int,
    @ColumnInfo(name = "tag_id") val tagId: Int,
    @ColumnInfo(name = "start_time") val startTime: Date ,
    @ColumnInfo(name = "duration") val duration: Long,
    @ColumnInfo(name = "session_emoji") val sessionEmoji: String
)