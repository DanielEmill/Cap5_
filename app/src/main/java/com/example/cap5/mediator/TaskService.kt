package com.example.cap5.mediator

import com.example.cap5.data.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskService {
    fun getTasksFromPrefDataStore(): Flow<Tasks>
    suspend fun addTasks(tasks: Tasks)
}