package dev.ygordoring.ajude_se.model

import androidx.room.ColumnInfo
import androidx.room.Entity                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Calc(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "res") val res: Double,
    @ColumnInfo(name = "created_date") val createdDate: Date = Date(),
)
