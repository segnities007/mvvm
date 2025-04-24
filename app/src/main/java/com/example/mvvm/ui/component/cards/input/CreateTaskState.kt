package com.example.mvvm.ui.component.cards.input

import com.example.mvvm.domain.model.Priority

data class CreateTaskState(
    val title: String = "",
    val description: String = "",
    val priority: Priority = Priority.Medium,
)
