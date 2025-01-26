package com.example.deepwork.deep_work_app.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
    @ColumnInfo(name = "start_time") val startTime: Int,
    @ColumnInfo(name = "duration") val duration: Int,
    @ColumnInfo(name = "session_emoji") val sessionEmoji: String
)