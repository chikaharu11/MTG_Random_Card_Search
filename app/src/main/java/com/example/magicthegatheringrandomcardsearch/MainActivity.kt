package com.example.magicthegatheringrandomcardsearch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var text = ""
    var text2 = ""
    var text3 = ""
    var text4 = ""
    var text5 = ""
    var text6 = ""
    var text7 = ""
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
        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        checkbox.setOnCheckedChangeListener { _, _ ->
            if (checkbox.isChecked) {
                text = "t:creature"
                findViewById<TextView>(R.id.textView).text = "https://scryfall.com/random?q=$text $text2"
            } else {
                text = ""
                findViewById<TextView>(R.id.textView).text = "https://scryfall.com/random?q=$text $text2"
            }
        }
        checkbox2.setOnCheckedChangeListener { _, _ ->
            if (checkbox2.isChecked) {
                text2 = "t:planeswalker"
                findViewById<TextView>(R.id.textView).text = "https://scryfall.com/random?q=$text $text2"
            } else {
                text2 = ""
                findViewById<TextView>(R.id.textView).text = "https://scryfall.com/random?q=$text $text2"
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener{
            webView.visibility = View.VISIBLE
            webView.loadUrl("https://scryfall.com/random?q=$text $text2")
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            webView.visibility = View.INVISIBLE
        }
    }
}