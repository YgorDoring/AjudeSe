package dev.ygordoring.ajude_se.data.model

import android.content.Context
import androidx.room.*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import androidx.room.TypeConverters

@Database(entities = [Calc::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun calcDao(): CalcDAO

    companion object {

        private var INSTANCE: AppDatabase ?= null

        fun getDatabase(context: Context) : AppDatabase {
            return if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "ajude_se").build()
                }
                INSTANCE as AppDatabase
            } else {
                INSTANCE as AppDatabase
            }
        }

    }

}

