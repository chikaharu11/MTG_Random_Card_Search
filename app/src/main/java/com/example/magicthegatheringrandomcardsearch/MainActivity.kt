package com.example.magicthegatheringrandomcardsearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var text = ""
    private var text2 = ""
    private var text3 = ""
    private var text4 = ""
    private var text5 = ""
    private var text6 = ""
    private var text7 = ""
    private var text8 = ""
    private var text9 = ""
    private var text10 = ""
    private var text11 = ""
    private var text12 = ""
    private var text13 = ""
    private var text14 = ""
    private var text15 = ""

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

        val edittext = findViewById<EditText>(R.id.searchText)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkbox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkbox8 = findViewById<CheckBox>(R.id.checkBox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkBox9)
        val checkbox10 = findViewById<CheckBox>(R.id.checkBox10)
        val checkbox11 = findViewById<CheckBox>(R.id.checkBox11)
        val checkbox12 = findViewById<CheckBox>(R.id.checkBox12)
        val checkbox13 = findViewById<CheckBox>(R.id.checkBox13)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val spinnerItems = arrayOf("指定しない", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17以上" )

        // Adapterの生成
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)

        // 選択肢の各項目のレイアウト
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // AdapterをSpinnerのAdapterとして設定
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            // 項目が選択された時に呼ばれる
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner.isFocusable) {
                    spinner.isFocusable = true
                    return
                }
                val cost = parent?.selectedItem as String
                text8 = when(position) {
                    0 -> {
                        ""
                    }
                    18 -> {
                        " cmc>=$cost"
                    }
                    else -> {
                        " cmc=$cost"
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }

            // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner.isFocusable = false

        val spinner2 = findViewById<Spinner>(R.id.spinner2)

        val spinnerItems2 = arrayOf("指定しない", "standard", "future", "historic", "gladiator", "pioneer", "modern", "legacy", "pauper", "vintage", "penny", "commander", "brawl", "duel", "oldschool", "premodern")

        // Adapterの生成
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems2)

        // 選択肢の各項目のレイアウト
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // AdapterをSpinnerのAdapterとして設定
        spinner2.adapter = adapter2

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            // 項目が選択された時に呼ばれる
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner2.isFocusable) {
                    spinner2.isFocusable = true
                    return
                }
                val format = parent?.selectedItem as String
                text9 = when(position) {
                    0 -> {
                        ""
                    }
                    else -> {
                        " format:$format"
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }

            // 基本的には呼ばれないが、何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner2.isFocusable = false

        checkbox.setOnCheckedChangeListener { _, _ ->
            if (checkbox.isChecked) {
                text = "type:creature or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }
        }
        checkbox2.setOnCheckedChangeListener { _, _ ->
            if (checkbox2.isChecked) {
                text2 = "type:planeswalker or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text2 = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }
        }
        checkbox3.setOnCheckedChangeListener { _, _ ->
            if (checkbox3.isChecked) {
                text3 = "type:Artifact or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text3 = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }
        }
        checkbox4.setOnCheckedChangeListener { _, _ ->
            if (checkbox4.isChecked) {
                text4 = "type:Instant or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text4 = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }
        }
        checkbox5.setOnCheckedChangeListener { _, _ ->
            if (checkbox5.isChecked) {
                text5 = "type:Sorcery or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text5 = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }
        }
        checkbox6.setOnCheckedChangeListener { _, _ ->
            if (checkbox6.isChecked) {
                text6 = "type:Enchantment or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text6 = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            }
        }
        checkbox7.setOnCheckedChangeListener { _, _ ->
            if (checkbox7.isChecked) {
                text7 = "type:Land or "
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
            } else {
                text7 = ""
                edittext.setText("https://scryfall.com/random?q=($text$text2$text3$text4$text5$text6$text7)$text8$text9")
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