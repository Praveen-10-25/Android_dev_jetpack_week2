package com.example.refactortaskviewmodel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    private val _tasks = MutableLiveData<List<String>>(emptyList())
    val tasks: LiveData<List<String>> = _tasks

    fun addTask(task: String) {
        if (task.isNotBlank()) {
            _tasks.value = _tasks.value!! + task
        }
    }

    fun removeTask(task: String) {
        _tasks.value = _tasks.value!!.filterNot { it == task }
    }
}
