package com.example.mvvm.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mvvm.data.model.Directory
import com.example.mvvm.data.model.DirectoryWithTasks
import com.example.mvvm.data.model.Task

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Insert
    suspend fun insertDirectory(directory: Directory)

    @Delete
    suspend fun deleteTask(task: Task)

    @Delete
    suspend fun deleteDirectory(directory: Directory)

    @Update
    suspend fun updateTask(task: Task)

    @Update
    suspend fun updateDirectory(directory: Directory)

    @Query("SELECT * FROM directories WHERE id = :id")
    suspend fun getDirectoryWithTasksById(id: Int): DirectoryWithTasks

    @Query("SELECT * FROM directories")
    suspend fun getAllDirectoryWithTasks(): List<DirectoryWithTasks>
}
