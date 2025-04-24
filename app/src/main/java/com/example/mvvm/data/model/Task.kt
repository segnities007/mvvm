package com.example.mvvm.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.mvvm.domain.model.Priority

@Entity(
    tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            entity = Directory::class,
            parentColumns = ["id"],
            childColumns = ["directoryId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [Index(value = ["directoryId"])],
)
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "no title",
    val description: String = "no description",
    val isCompleted: Boolean = false,
    val createAt: Long = System.currentTimeMillis(),
    val updateAt: Long = System.currentTimeMillis(),
    val priority: Priority = Priority.Medium,
    val directoryId: Int = 0,
)
