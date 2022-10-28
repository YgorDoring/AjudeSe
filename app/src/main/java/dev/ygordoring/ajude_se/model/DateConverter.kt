package dev.ygordoring.ajude_se.model

import androidx.room.TypeConverter                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import java.util.*

object DateConverter {
    @TypeConverter
    fun toDate(dateLong: Long?) : Date? {
        return if (dateLong != null) Date(dateLong) else null
    }

    @TypeConverter
    fun fromDate(date: Date?) : Long? {
        return date?.time
    }
}