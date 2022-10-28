package dev.ygordoring.ajude_se.model

import androidx.room.*

@Dao
interface CalcDAO {

    @Insert
    fun insert(calc: Calc)

    @Query("SELECT * FROM Calc WHERE type = :type")
    fun getRegisterByType(type: String) : List<Calc>

}