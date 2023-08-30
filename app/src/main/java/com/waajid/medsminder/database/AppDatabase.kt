package com.waajid.medsminder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.waajid.medsminder.Constants
import com.waajid.medsminder.model.Med
import com.waajid.medsminder.model.MedDao

@Database(
    entities = [Med::class],
    version = 1,
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMedDao(): MedDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDB(context: Context): AppDatabase {/*
        if the INSTANCE is not null, then return it,
        if it is, then create the database and save in instance variable then return it.
        */
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }

        }
    }

}