package com.example.feature.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Directory
import com.example.domain.model.Task
import com.example.domain.repository.DirectoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
        private val directoryRepository: DirectoryRepository,
    ) : ViewModel() {
        var homeState by mutableStateOf(HomeState())
            private set

        fun onAction(action: HomeAction) {
            when (action) {
                is HomeAction.SelectDirectory -> {
                    homeState = homeState.copy(selectedDirectoryIndex = action.index)
                }
                is HomeAction.InsertTask -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        val newTask =
                            Task(
                                title = action.title,
                                description = action.description,
                                directoryId = homeState.directories[homeState.selectedDirectoryIndex].directory.id,
                            )
                        directoryRepository.insertTask(newTask)
                        homeState = homeState.copy(directories = directoryRepository.getAllDirectoryWithTasks())
                    }
                }
                is HomeAction.InsertDirectory -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        val newDirectory = Directory(label = action.label)
                        directoryRepository.insertDirectory(newDirectory)
                        homeState = homeState.copy(directories = directoryRepository.getAllDirectoryWithTasks())
                    }
                }
                HomeAction.GetAllDirectoryWithTasks -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        homeState = homeState.copy(directories = directoryRepository.getAllDirectoryWithTasks())
                    }
                }

                is HomeAction.UpdateTask -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        val updatedTask = action.task
                        directoryRepository.updateTask(updatedTask)
                        homeState = homeState.copy(directories = directoryRepository.getAllDirectoryWithTasks())
                    }
                }
                is HomeAction.DeleteTask -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        for (task in action.directoryWithTasks.tasks) {
                            if (task.isCompleted == true) {
                                directoryRepository.deleteTask(task)
                            }
                        }
                        directoryRepository.getAllDirectoryWithTasks()
                        homeState = homeState.copy(directories = directoryRepository.getAllDirectoryWithTasks())
                    }
                }
                is HomeAction.DeleteDirectory -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        directoryRepository.deleteDirectory(action.directoryWithTasks.directory)
                        if (homeState.directories.last() == action.directoryWithTasks && homeState.selectedDirectoryIndex - 1 >= 0) {
                            homeState = homeState.copy(selectedDirectoryIndex = homeState.selectedDirectoryIndex-1)
                        }
                        homeState =
                            homeState.copy(
                                directories =
                                    homeState.directories.filter {
                                        it.directory.id != action.directoryWithTasks.directory.id
                                    },
                            )
                    }
                }
            }
        }
    }
