package dev.ygordoring.ajude_se.ui.viewmodel

import androidx.appcompat.app.AppCompatActivity                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import dev.ygordoring.ajude_se.R


class SugestionsActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private var URL = "https://ygordoring.dev/18-dicas-de-saude/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugestions)
        webView = findViewById(R.id.web_sugestions)
        webView.apply {
            loadUrl(URL)
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true

        }
    }
}