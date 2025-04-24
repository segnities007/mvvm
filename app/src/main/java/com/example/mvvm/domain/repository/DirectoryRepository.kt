package com.example.mvvm.domain.repository

import com.example.mvvm.data.model.Directory
import com.example.mvvm.data.model.DirectoryWithTasks
import com.example.mvvm.data.model.Task

interface DirectoryRepository {
    suspend fun insertTask(task: Task)

    suspend fun insertDirectory(directory: Directory)

    suspend fun updateTask(task: Task)

    suspend fun updateDirectory(directory: Directory)

    suspend fun deleteTask(task: Task)

    suspend fun deleteDirectory(directory: Directory)

    suspend fun getDirectoryWithTasksById(id: Int): DirectoryWithTasks

    suspend fun getAllDirectoryWithTasks(): List<DirectoryWithTasks>
}
