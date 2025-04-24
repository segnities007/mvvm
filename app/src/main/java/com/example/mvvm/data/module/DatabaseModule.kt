package com.example.mvvm.data.module

import android.content.Context
import androidx.room.Room
import com.example.mvvm.domain.dao.DirectoryDao
import com.example.mvvm.domain.db.DirectoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): DirectoryDatabase =
        Room
            .databaseBuilder(
                context,
                DirectoryDatabase::class.java,
                "directory_database",
            ).build()

    @Provides
    fun provideDirectoryDao(database: DirectoryDatabase): DirectoryDao = database.directoryDao()
}
