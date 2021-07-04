package com.example.magicthegatheringrandomcardsearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var type = ""
    private var type2 = ""
    private var type3 = ""
    private var type4 = ""
    private var type5 = ""
    private var type6 = ""
    private var type7 = ""
    private var type8 = ""
    private var cost = ""
    private var format = ""
    private var color = ""
    private var color2 = ""
    private var color3 = ""
    private var color4 = ""
    private var color5 = ""
    private var color6 = ""
    private var colorsign = ""
    private var funny = ""
    private var firstprint = ""


    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val layoutView =findViewById<ConstraintLayout>(R.id.layoutView)

        webView.settings.builtInZoomControls = true
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
        val checkbox14 = findViewById<CheckBox>(R.id.checkBox14)
        val checkbox15 = findViewById<CheckBox>(R.id.checkBox15)
        val checkbox16 = findViewById<CheckBox>(R.id.checkBox16)
        val checkbox17 = findViewById<CheckBox>(R.id.checkBox17)

        val radigroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radiobutton = findViewById<RadioButton>(R.id.radioButton)
        val radiobutton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radiobutton3 = findViewById<RadioButton>(R.id.radioButton3)

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)

        fun check(){
            if (!checkbox.isChecked &&
                !checkbox2.isChecked &&
                !checkbox3.isChecked &&
                !checkbox4.isChecked &&
                !checkbox5.isChecked &&
                !checkbox6.isChecked &&
                !checkbox7.isChecked &&
                !checkbox8.isChecked &&
                !checkbox9.isChecked &&
                !checkbox10.isChecked &&
                !checkbox11.isChecked &&
                !checkbox12.isChecked &&
                !checkbox13.isChecked &&
                !checkbox14.isChecked &&
                !checkbox15.isChecked &&
                !checkbox16.isChecked &&
                spinner.selectedItemPosition == 0 &&
                spinner2.selectedItemPosition == 0) {
                edittext.setText("https://scryfall.com/random?q=")
            }
        }

        fun checkColor(){
            if (
                !checkbox8.isChecked &&
                !checkbox9.isChecked &&
                !checkbox10.isChecked &&
                !checkbox11.isChecked &&
                !checkbox12.isChecked &&
                !checkbox13.isChecked) {
                    colorsign = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            }
        }

        val spinnerItems = arrayOf("指定しない", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17以上" )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner.isFocusable) {
                    spinner.isFocusable = true
                    return
                }
                val cost2 = parent?.selectedItem as String
                cost = when(position) {
                    0 -> {
                        ""
                    }
                    18 -> {
                        " cmc>=$cost2 "
                    }
                    else -> {
                        " cmc=$cost2 "
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner.isFocusable = false

        val spinnerItems2 = arrayOf("指定しない", "standard", "future", "historic", "gladiator", "pioneer", "modern", "legacy", "pauper", "vintage", "penny", "commander", "brawl", "duel", "oldschool", "premodern")

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems2)

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner2.adapter = adapter2

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner2.isFocusable) {
                    spinner2.isFocusable = true
                    return
                }
                val format2 = parent?.selectedItem as String
                format = when(position) {
                    0 -> {
                        ""
                    }
                    else -> {
                        "format:$format2 "
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
            
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner2.isFocusable = false

        checkbox.setOnCheckedChangeListener { _, _ ->
            if (checkbox.isChecked) {
                type = "type:creature or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }
        checkbox2.setOnCheckedChangeListener { _, _ ->
            if (checkbox2.isChecked) {
                type2 = "type:planeswalker or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type2 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }
        checkbox3.setOnCheckedChangeListener { _, _ ->
            if (checkbox3.isChecked) {
                type3 = "type:Artifact or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type3 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }
        checkbox4.setOnCheckedChangeListener { _, _ ->
            if (checkbox4.isChecked) {
                type4 = "type:Instant or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type4 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }
        checkbox5.setOnCheckedChangeListener { _, _ ->
            if (checkbox5.isChecked) {
                type5 = "type:Sorcery or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type5 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }
        checkbox6.setOnCheckedChangeListener { _, _ ->
            if (checkbox6.isChecked) {
                type6 = "type:Enchantment or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type6 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }
        checkbox7.setOnCheckedChangeListener { _, _ ->
            if (checkbox7.isChecked) {
                type7 = "type:Land or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type7 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }

        radigroup.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> {
                    checkbox8.isChecked = false
                    checkbox9.isChecked = false
                    checkbox10.isChecked = false
                    checkbox11.isChecked = false
                    checkbox12.isChecked = false
                    checkbox13.isChecked = false
                }
                radiobutton2.isChecked -> {
                    checkbox8.isChecked = false
                    checkbox9.isChecked = false
                    checkbox10.isChecked = false
                    checkbox11.isChecked = false
                    checkbox12.isChecked = false
                    checkbox13.isChecked = false
                }
                radiobutton3.isChecked -> {
                    checkbox8.isChecked = false
                    checkbox9.isChecked = false
                    checkbox10.isChecked = false
                    checkbox11.isChecked = false
                    checkbox12.isChecked = false
                    checkbox13.isChecked = false
                }
            }
        }

        checkbox8.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox8.isChecked) {
                    color = "color=W or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox8.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color = "W"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox8.isChecked) {
                    color = "W"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
            }
                radiobutton3.isChecked -> if (checkbox8.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color = "W"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox8.isChecked) {
                    color = "W"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox8.isChecked) {
                    color = "color=W or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox9.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox9.isChecked) {
                    color2 = "color=U or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color2 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox9.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color2 = "U"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox9.isChecked) {
                    color2 = "U"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color2 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox9.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color2 = "U"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox9.isChecked) {
                    color2 = "U"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color2 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox9.isChecked) {
                    color2 = "color=U or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color2 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox10.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox10.isChecked) {
                    color3 = "color=B or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color3 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox10.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color3 = "B"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox10.isChecked) {
                    color3 = "B"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color3 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox10.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color3 = "B"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox10.isChecked) {
                    color3 = "B"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color3 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox10.isChecked) {
                    color3 = "color=B or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color3 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox11.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox11.isChecked) {
                    color4 = "color=R or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color4 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox11.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color4 = "R"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox11.isChecked) {
                    color4 = "R"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color4 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox11.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color4 = "R"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox11.isChecked) {
                    color4 = "R"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color4 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox11.isChecked) {
                    color4 = "color=R or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color4 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox12.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox12.isChecked) {
                    color5 = "color=G or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color5 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox12.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color5 = "G"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox12.isChecked) {
                    color5 = "G"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color5 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox12.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color5 = "G"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox12.isChecked) {
                    color5 = "G"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color5 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox12.isChecked) {
                    color5 = "color=G or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color5 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox13.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox13.isChecked) {
                    color6 = "color=C or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox13.isChecked) {
                    checkbox8.isChecked = false
                    checkbox9.isChecked = false
                    checkbox10.isChecked = false
                    checkbox11.isChecked = false
                    checkbox12.isChecked = false
                    color = ""
                    color2 = ""
                    color3 = ""
                    color4 = ""
                    color5 = ""
                    color6 = "C"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox13.isChecked) {
                    checkbox8.isChecked = false
                    checkbox9.isChecked = false
                    checkbox10.isChecked = false
                    checkbox11.isChecked = false
                    checkbox12.isChecked = false
                    color = ""
                    color2 = ""
                    color3 = ""
                    color4 = ""
                    color5 = ""
                    color6 = "C"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox13.isChecked) {
                    color6 = "color=C or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox14.setOnCheckedChangeListener { _, _ ->
            if (checkbox14.isChecked) {
                funny = "-is:funny "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                funny= ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }

        checkbox15.setOnCheckedChangeListener { _, _ ->
            if (checkbox15.isChecked) {
                firstprint = "is:firstprint"
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                firstprint = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }

        checkbox16.setOnCheckedChangeListener { _, _ ->
            if (checkbox16.isChecked) {
                type8 = "is:Commander or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
            } else {
                type8 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)$cost$format$funny$firstprint")
                check()
            }
        }

        checkbox17.setOnCheckedChangeListener { _, _ ->
            if (checkbox17.isChecked) {
                checkbox.isChecked = false
                checkbox2.isChecked = false
                checkbox3.isChecked = false
                checkbox4.isChecked = false
                checkbox5.isChecked = false
                checkbox6.isChecked = false
                checkbox7.isChecked = false
                checkbox8.isChecked = false
                checkbox9.isChecked = false
                checkbox10.isChecked = false
                checkbox11.isChecked = false
                checkbox12.isChecked = false
                checkbox13.isChecked = false
                checkbox14.isChecked = false
                checkbox15.isChecked = false
                checkbox16.isChecked = false
                checkbox17.isChecked = false
                radigroup.clearCheck()
                spinner.setSelection(0)
                spinner2.setSelection(0)
                edittext.setText("https://scryfall.com/random?q=")
            }
        }

        button.setOnClickListener{
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(edittext.text.toString())
        }
        button2.setOnClickListener{
            webView.visibility = View.INVISIBLE
            layoutView.visibility = View.VISIBLE
        }
        button3.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle(R.string.exit2)
                .setPositiveButton("YES") { _, _ ->
                    finish()
                }
                .setNegativeButton("NO") { _, _ ->

                }
                .show()
        }
        button4.setOnClickListener{
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl("https://scryfall.com/random?q=type:vanguard")
        }
    }
}