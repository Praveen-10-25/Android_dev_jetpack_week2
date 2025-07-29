package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
   private val _task=MutableLiveData<String>("")
    val task:LiveData<String> = _task

    private val _tasklist=MutableLiveData<List<String>>(emptyList())
    val tasklist:LiveData<List<String>> = _tasklist

    fun onTaskChange(newTask: String) {
       _task.value = newTask
    }

    fun addTask() {
        val addedtask=_task.value?.trim()?:""
        if (addedtask.isNotBlank()) {
            val updateList=_tasklist.value.orEmpty()+addedtask
            _tasklist.value=updateList
            _task.value=""
        }
    }

    fun deleteTask(taskToDelete: String) {
       val newlist=_tasklist.value.orEmpty().filter { it!=taskToDelete}
        _tasklist.value=newlist
    }
}
