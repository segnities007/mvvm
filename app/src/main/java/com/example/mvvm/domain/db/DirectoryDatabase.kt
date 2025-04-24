package com.example.mvvm.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.model.Directory
import com.example.mvvm.data.model.Task
import com.example.mvvm.domain.dao.DirectoryDao

@Database(
    entities = [Directory::class, Task::class],
    version = 1,
    exportSchema = false,
)
abstract class DirectoryDatabase : RoomDatabase() {
    abstract fun directoryDao(): DirectoryDao
}
