package com.example.refactortaskviewmodel.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.refactortaskviewmodel.viewModel.TaskViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext


@Composable
fun TaskScreen(viewModel: TaskViewModel = viewModel()) {
    val context = LocalContext.current
    val taskList by viewModel.tasks.observeAsState(emptyList())
    var newTask by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("My Tasks", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("Enter a task") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (newTask.isBlank()) {
                    Toast.makeText(context, "Please enter a task", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.addTask(newTask)
                    newTask = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tasks:", style = MaterialTheme.typography.titleMedium)
        LazyColumn {
            items(taskList) { task ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(task, modifier = Modifier.weight(1f))

                        IconButton(onClick = { viewModel.removeTask(task) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Task"
                            )
                        }
                    }
                }
            }
        }
    }
}
