package com.example.mvvm.data.module

import com.example.mvvm.data.repository.DirectoryRepositoryImpl
import com.example.mvvm.domain.repository.DirectoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDirectoryRepository(impl: DirectoryRepositoryImpl): DirectoryRepository
}
