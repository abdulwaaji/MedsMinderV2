package com.waajid.medsminder.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.waajid.medsminder.TypeConverters.ScheduleTypeConverter

@Entity(tableName = "table_meds")
@TypeConverters(ScheduleTypeConverter::class)
data class Med(
    @PrimaryKey(autoGenerate = true) var id: Int?= null,
    var drugName: String,
    var ailment: String,
    var conSummingQuantity: Double,
    val drugUOM: String,
    var drugColorId: String,
    var schedule: List<String>,
    var beforeAfterFood: String,
    var availableStock: Double
)