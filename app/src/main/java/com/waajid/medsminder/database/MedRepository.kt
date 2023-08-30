package com.waajid.medsminder.database

import com.waajid.medsminder.model.Med
import com.waajid.medsminder.model.MedDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MedRepository @Inject constructor(
    private val medDao: MedDao
) {

    suspend fun insertMedtoDb(med: Med){
        withContext(Dispatchers.IO){
            medDao.insert(med)
        }
    }
}