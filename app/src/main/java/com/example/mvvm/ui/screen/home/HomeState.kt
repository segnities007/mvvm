package com.example.mvvm.ui.screen.home

import com.example.mvvm.data.model.DirectoryWithTasks

data class HomeState(
    val directories: List<DirectoryWithTasks> = listOf(),
    val selectedDirectoryIndex: Int = 0,
)
