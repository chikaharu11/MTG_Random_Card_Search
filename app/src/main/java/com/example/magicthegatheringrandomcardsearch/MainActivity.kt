package com.example.magicthegatheringrandomcardsearch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var text = ""
    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://scryfall.com/")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }
        findViewById<RadioButton>(R.id.radioButton).setOnCheckedChangeListener { _, _ ->
            text = "t:creature"
            findViewById<TextView>(R.id.textView).text = "https://scryfall.com/random?q=$text"
        }
        findViewById<RadioButton>(R.id.radioButton2).setOnCheckedChangeListener { _, _ ->
            text = "t:instant"
            findViewById<TextView>(R.id.textView).text = "https://scryfall.com/random?q=$text"
        }

        findViewById<Button>(R.id.button).setOnClickListener{
            webView.visibility = View.VISIBLE
            webView.loadUrl("https://scryfall.com/random?q=$text")
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            webView.visibility = View.INVISIBLE
        }
    }
}