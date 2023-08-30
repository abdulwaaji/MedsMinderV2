package com.waajid.medsminder.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waajid.medsminder.database.MedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedViewModel @Inject constructor(
    private val medRepository: MedRepository
) : ViewModel() {


    fun insertData(med: Med){
        viewModelScope.launch {
            medRepository.insertMedtoDb(med)
        }
    }
}