package com.waajid.medsminder.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(med: Med)

    @Delete
    fun delete(med: Med)

    @Query("SELECT * FROM table_meds")
    fun getAllMeds() : LiveData<List<Med>>

}