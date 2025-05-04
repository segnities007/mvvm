package com.example.core_module.di

import androidx.room.Room
import com.example.domain.db.DirectoryDatabase
import com.example.domain.dao.DirectoryDao
import com.example.domain.repository.DirectoryRepository
import com.example.data.repository.DirectoryRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single<DirectoryDatabase> {
        Room.databaseBuilder(
                androidApplication(),
                DirectoryDatabase::class.java,
                "directory_database"
            ).fallbackToDestructiveMigration(false)
            .build()
    }

    single<DirectoryDao> {
        get<DirectoryDatabase>().directoryDao()
    }

    single<DirectoryRepository> {
        DirectoryRepositoryImpl(directoryDao = get())
    }
}
