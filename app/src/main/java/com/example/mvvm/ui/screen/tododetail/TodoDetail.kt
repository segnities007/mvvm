package com.example.mvvm.ui.screen.tododetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm.data.model.Task
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun TodoDetail(todo: Task) {
    val formatedDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    val date = LocalDateTime.ofInstant(Instant.ofEpochMilli(todo.createAt), ZoneId.of("Asia/Tokyo")).format(formatedDate)
    ElevatedCard(
        modifier = Modifier.padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = todo.title)
            Text(text = todo.description)
            Text(text = todo.isCompleted.toString())
            Text(text = todo.priority.toString())
            Text(text = date)
        }
    }
}

@Composable
@Preview
private fun TodoDetailPreview() {
    TodoDetail(todo = Task(id = 1, title = "Todo"))
}
