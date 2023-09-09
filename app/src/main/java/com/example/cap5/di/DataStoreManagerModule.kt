package com.example.cap5.di
import com.example.cap5.data.DataStoreManager
import com.example.cap5.data.DataStoreManagerImpl
import com.example.cap5.mediator.TaskService
import com.example.cap5.mediator.TaskServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class  DataStoreManagerModule {

    @Singleton
    @Binds
    abstract fun bindDataStoreRepository(dataStoreManagerImpl: DataStoreManagerImpl<String>): DataStoreManager

    @Singleton
    @Binds
    abstract fun bindTaskService(taskServiceImpl: TaskServiceImpl): TaskService
}