package com.example.mvvm.data.model

import com.example.mvvm.domain.model.NavigationBarItem
import com.example.mvvm.domain.model.Route

data class NavItem(
    override val selectedIcon: Int,
    override val unSelectedIcon: Int,
    override val label: String,
    override val route: Route,
) : NavigationBarItem
