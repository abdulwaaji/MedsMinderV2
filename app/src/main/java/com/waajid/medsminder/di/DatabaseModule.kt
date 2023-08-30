package com.waajid.medsminder.di

import android.content.Context
import com.waajid.medsminder.database.AppDatabase
import com.waajid.medsminder.database.MedRepository
import com.waajid.medsminder.model.MedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)  =
        AppDatabase.getDB(context)

    @Provides
    fun provideMedDao(appDatabase: AppDatabase) =
        appDatabase.getMedDao()

    @Provides
    fun  provideMedRepository(medDao: MedDao) = MedRepository(medDao)



}
