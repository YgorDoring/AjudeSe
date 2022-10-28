package dev.ygordoring.ajude_se.application

import android.app.Application                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import dev.ygordoring.ajude_se.model.AppDatabase


class App : Application() {

    lateinit var db: AppDatabase
    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.getDatabase(this)
    }

}