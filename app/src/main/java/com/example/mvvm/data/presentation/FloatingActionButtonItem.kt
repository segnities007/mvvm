package com.example.mvvm.data.presentation

import androidx.compose.ui.graphics.painter.Painter
import com.example.mvvm.domain.presentation.HomeStatus

data class FloatingActionButtonItem(
    val icon: Painter,
    val label: String,
    val homeStatus: HomeStatus,
    val onClick: (HomeStatus) -> Unit,
)
