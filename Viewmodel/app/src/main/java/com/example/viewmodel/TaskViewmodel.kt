package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    var task by mutableStateOf("")
        private set

    var taskList by mutableStateOf(listOf<String>())
        private set

    fun onTaskChange(newTask: String) {
        task = newTask
    }

    fun addTask() {
        if (task.isNotBlank()) {
            taskList = taskList + task.trim()
            task = ""
        }
    }

    fun deleteTask(taskToDelete: String) {
        taskList = taskList.filter { it != taskToDelete }
    }
}
