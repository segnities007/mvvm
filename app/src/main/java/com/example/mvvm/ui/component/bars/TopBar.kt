package com.example.mvvm.ui.component.bars

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBackNavigate: () -> Unit) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = { onBackNavigate() }) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back"
                )
            }
        },
    )
}

@Composable
@Preview
fun TopBarPreview() {
    TopBar(
        onBackNavigate = {}
    )
}
