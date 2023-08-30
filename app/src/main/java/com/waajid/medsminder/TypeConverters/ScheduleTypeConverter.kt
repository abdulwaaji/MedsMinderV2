package com.waajid.medsminder.TypeConverters

import androidx.room.TypeConverter

class ScheduleTypeConverter {

    @TypeConverter
    fun storedStringToSchedule(value: String): List<String> {
        return if (value.isEmpty()) {
            ArrayList()
        } else {
            value.split(",")
        }
    }

    @TypeConverter
    fun scheduleToStoredString(schedule: List<String>): String {
        return if (schedule.isEmpty()) {
            ""
        } else {
            schedule.joinToString(",")
        }
    }
}