package com.example.cap5.mediator

import com.example.cap5.data.DataStoreManager
import com.example.cap5.data.Tasks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskServiceImpl @Inject constructor(
    private val DataStoreManager: DataStoreManager
) : TaskService {
    override fun getTasksFromPrefDataStore() =
        DataStoreManager.getTasks()

    override suspend fun addTasks(tasks: Tasks) {
        DataStoreManager.saveTasks(tasks)
    }
}