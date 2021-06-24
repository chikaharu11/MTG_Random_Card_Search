package com.example.magicthegatheringrandomcardsearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var text = ""
    private var text2 = ""
    private var text3 = ""
    private var text4 = ""
    private var text5 = ""
    private var text6 = ""
    private var text7 = ""

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

        val edittext = findViewById<EditText>(R.id.editText)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkbox7 = findViewById<CheckBox>(R.id.checkBox7)

        checkbox.setOnCheckedChangeListener { _, _ ->
            if (checkbox.isChecked) {
                text = "type:creature or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }
        checkbox2.setOnCheckedChangeListener { _, _ ->
            if (checkbox2.isChecked) {
                text2 = "type:planeswalker or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text2 = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }
        checkbox3.setOnCheckedChangeListener { _, _ ->
            if (checkbox3.isChecked) {
                text3 = "type:Artifact or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text3 = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }
        checkbox4.setOnCheckedChangeListener { _, _ ->
            if (checkbox4.isChecked) {
                text4 = "type:Instant or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text4 = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }
        checkbox5.setOnCheckedChangeListener { _, _ ->
            if (checkbox5.isChecked) {
                text5 = "type:Sorcery or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text5 = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }
        checkbox6.setOnCheckedChangeListener { _, _ ->
            if (checkbox6.isChecked) {
                text6 = "type:Enchantment or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text6 = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }
        checkbox7.setOnCheckedChangeListener { _, _ ->
            if (checkbox7.isChecked) {
                text7 = "type:Land or "
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            } else {
                text7 = ""
                edittext.setText("https://scryfall.com/random?q=$text$text2$text3$text4$text5$text6$text7")
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener{
            webView.visibility = View.VISIBLE
            webView.loadUrl(edittext.text.toString())
        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            webView.visibility = View.INVISIBLE
        }
    }
}