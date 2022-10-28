package dev.ygordoring.ajude_se.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import android.webkit.WebView
import android.webkit.WebViewClient
import dev.ygordoring.ajude_se.R

class PharmaciesActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private var URL = "https://www.google.com.br/maps/search/farmacia/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmacies)
        webView = findViewById(R.id.web_sugestions)
        webView.apply {
            loadUrl(URL)
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true

        }
    }
}