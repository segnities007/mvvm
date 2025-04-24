package com.example.mvvm.domain.model

interface NavigationBarItem {
    val selectedIcon: Int
    val unSelectedIcon: Int
    val label: String
    val route: Route
}
