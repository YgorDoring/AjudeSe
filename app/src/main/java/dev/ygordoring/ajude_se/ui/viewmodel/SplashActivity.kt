package dev.ygordoring.ajude_se.ui.viewmodel

import android.content.Intent
import android.os.Bundle                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import android.os.Handler
import dev.ygordoring.ajude_se.R
import dev.ygordoring.ajude_se.ui.view.MainActivity


class SplashActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val maxSplashTime: Long = 1500
        var progressSplash: Long = 0
        val percentResult = maxSplashTime / 101

        for(x in 0..100){
           progressSplash = progressSplash + percentResult
        }

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },maxSplashTime)

    }
}