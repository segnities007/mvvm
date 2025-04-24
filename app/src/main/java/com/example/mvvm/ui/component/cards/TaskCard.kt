package com.example.mvvm.ui.component.cards

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm.data.model.Task
import com.example.mvvm.domain.model.Route
import com.example.mvvm.domain.model.Route.TodoDetail
import com.example.mvvm.ui.screen.home.HomeAction

@Composable
fun TaskCard(
    task: Task,
    onNavigate: (Route) -> Unit,
    onHomeAction: (HomeAction) -> Unit,
) {
    Card(
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
        shape = RoundedCornerShape(4.dp),
        onClick = {
            onNavigate(TodoDetail(task.id))
        },
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(64.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CheckBox(task = task, onHomeAction = onHomeAction)
            Text(
                text = task.title,
                modifier = Modifier.scale(1.25f),
            )
        }
    }
}

@Composable
private fun CheckBox(
    task: Task,
    onHomeAction: (HomeAction) -> Unit,
) {
    Checkbox(
        modifier =
            Modifier
                .scale(1.25f)
                .padding(8.dp),
        checked = task.isCompleted,
        onCheckedChange = {
            onHomeAction(
                HomeAction.UpdateTask(
                    task = task.copy(isCompleted = it),
                ),
            )
        },
    )
}

@Composable
@Preview
private fun TaskCardPreview() {
    TaskCard(
        task =
            Task(
                title = "aaa",
                directoryId = 0,
            ),
        onHomeAction = {},
        onNavigate = {},
    )
}
