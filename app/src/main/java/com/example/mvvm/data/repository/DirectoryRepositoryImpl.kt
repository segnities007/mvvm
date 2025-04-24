package com.example.mvvm.data.repository

import com.example.mvvm.data.model.Directory
import com.example.mvvm.data.model.DirectoryWithTasks
import com.example.mvvm.data.model.Task
import com.example.mvvm.domain.dao.DirectoryDao
import com.example.mvvm.domain.repository.DirectoryRepository
import javax.inject.Inject

class DirectoryRepositoryImpl
    @Inject
    constructor(
        private val directoryDao: DirectoryDao,
    ) : DirectoryRepository {
        override suspend fun insertTask(task: Task) {
            directoryDao.insertTask(task)
        }

        override suspend fun insertDirectory(directory: Directory) {
            directoryDao.insertDirectory(directory)
        }

        override suspend fun updateTask(task: Task) {
            directoryDao.updateTask(task)
        }

        override suspend fun updateDirectory(directory: Directory) {
            directoryDao.updateDirectory(directory)
        }

        override suspend fun deleteTask(task: Task) {
            directoryDao.deleteTask(task)
        }

        override suspend fun deleteDirectory(directory: Directory) {
            directoryDao.deleteDirectory(directory)
        }

        override suspend fun getDirectoryWithTasksById(id: Int): DirectoryWithTasks = directoryDao.getDirectoryWithTasksById(id)

        override suspend fun getAllDirectoryWithTasks(): List<DirectoryWithTasks> = directoryDao.getAllDirectoryWithTasks()
    }
