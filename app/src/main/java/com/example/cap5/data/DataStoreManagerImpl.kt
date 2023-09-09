package com.example.cap5.data
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManagerImpl<TaskPreference> @Inject constructor(
    private val tasksPreferenceStore: DataStore<Preferences>,
    private val taskProtoDataStore: DataStore<TaskPreference>
) : DataStoreManager {

    private val FIRST_TASK = stringPreferencesKey("first_task")
    private val SECOND_TASK = stringPreferencesKey("second_task")
    private val THIRD_TASK = stringPreferencesKey("third_task")

    override suspend fun saveTasks(tasks: Tasks) {
        tasksPreferenceStore.edit { taskPreferenceStore ->
            taskPreferenceStore[FIRST_TASK] = tasks.firstTask
            taskPreferenceStore[SECOND_TASK] = tasks.secondTask
            taskPreferenceStore[THIRD_TASK] = tasks.thirdTask
        }
    }

    override fun getTasks(): Flow<Tasks> = tasksPreferenceStore.data.map { taskPreference ->
        Tasks(
            firstTask = taskPreference[FIRST_TASK] ?: "",
            secondTask = taskPreference[SECOND_TASK] ?: "",
            thirdTask = taskPreference[THIRD_TASK] ?: ""
        )
    }

    override suspend fun saveTasksToProtoStore(tasks: Tasks) {
        TODO("Not yet implemented")
    }

    override fun getTasksFromProtoStore(): Flow<Tasks> {
        TODO("Not yet implemented")
    }


}