package com.example.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    var tasks = mutableStateListOf<String>()
        private set

    fun addTask(task: String) {
        tasks.add(task)
    }

    fun removeTask(task: String) {
        tasks.remove(task)
    }
}
