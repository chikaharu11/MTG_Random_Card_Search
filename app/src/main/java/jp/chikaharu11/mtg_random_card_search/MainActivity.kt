package jp.chikaharu11.mtg_random_card_search

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
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.gson.Gson
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

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
    private var core = ""
    private var color = ""
    private var color2 = ""
    private var color3 = ""
    private var color4 = ""
    private var color5 = ""
    private var color6 = ""
    private var colorsign = ""
    private var funny = ""
    private var firstprint = ""

    private var jaName2 = ""
    private var enName2 = ""

    private val locale: Locale = Locale.getDefault()


    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val webView2 = findViewById<WebView>(R.id.webView2)
        val layoutView =findViewById<ConstraintLayout>(R.id.layoutView)

        webView.settings.builtInZoomControls = true
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        webView.loadUrl("https://scryfall.com/")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?,
            ): Boolean {
                return false
            }
        }

        webView2.settings.builtInZoomControls = true
        webView2.settings.javaScriptEnabled = true
        webView2.settings.useWideViewPort = true
        webView2.loadUrl("http://m.mtgwiki.com/wiki/")

        webView2.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?,
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
        val checkbox18 = findViewById<CheckBox>(R.id.checkBox18)

        val radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radiobutton = findViewById<RadioButton>(R.id.radioButton)
        val radiobutton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radiobutton3 = findViewById<RadioButton>(R.id.radioButton3)

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)

        val textview = findViewById<TextView>(R.id.textView)
        val textview2 = findViewById<TextView>(R.id.textView2)
        val textview3 = findViewById<TextView>(R.id.textView3)


        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

        fun readFromAsset(): List<Model> {
            val filename = "android_version.json"

            val bufferReader = application.assets.open(filename).bufferedReader()

            val jsonstring = bufferReader.use {
                it.readText()
            }
            val gson = Gson()
            return gson.fromJson(jsonstring, Array<Model>::class.java).toList()
        }

        val modelList: List<Model> = readFromAsset()

        val customDropDownAdapter = CustomDropDownAdapter(this, modelList)

        fun readFromAsset2(): List<Model> {
            val filename2 = "android_version2.json"

            val bufferReader = application.assets.open(filename2).bufferedReader()

            val jsonstring2 = bufferReader.use {
                it.readText()
            }
            val gson = Gson()
            return gson.fromJson(jsonstring2, Array<Model>::class.java).toList()
        }

        val modelList2: List<Model> = readFromAsset2()

        val customDropDownAdapter2 = CustomDropDownAdapter(this, modelList2)

        fun readFromAsset3(): List<Model> {
            val filename3 = "android_version3.json"

            val bufferReader = application.assets.open(filename3).bufferedReader()

            val jsonstring3 = bufferReader.use {
                it.readText()
            }
            val gson = Gson()
            return gson.fromJson(jsonstring3, Array<Model>::class.java).toList()
        }

        val modelList3: List<Model> = readFromAsset3()

        val customDropDownAdapter3 = CustomDropDownAdapter(this, modelList3)

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
                !checkbox18.isChecked &&
                spinner.selectedItemPosition == 0 &&
                spinner2.selectedItemPosition == 0 &&
                spinner3.selectedItemPosition == 0) {
                edittext.setText("https://scryfall.com/random?q=")
            }
        }

        fun check18() {
            if (checkbox18.isChecked)
                checkbox18.isChecked = false
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
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
            }
        }

        val spinnerItems = if (locale == Locale.JAPAN) {
            arrayOf("指定しない", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17以上" )
        } else {
            arrayOf("No specified", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17 or more" )
        }

        val adapter = ArrayAdapter(this, R.layout.spinner_item, spinnerItems)

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner.adapter = customDropDownAdapter3

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner.isFocusable) {
                    spinner.isFocusable = true
                    return
                }
                cost = when(position) {
                    0 -> {
                        ""
                    }
                    1 -> {
                        "cmc=0 "
                    }
                    2 -> {
                        "cmc=1 "
                    }
                    3 -> {
                        "cmc=2 "
                    }
                    4 -> {
                        "cmc=3 "
                    }
                    5 -> {
                        "cmc=4 "
                    }
                    6 -> {
                        "cmc=5 "
                    }
                    7 -> {
                        "cmc=6 "
                    }
                    8 -> {
                        "cmc=7 "
                    }
                    9 -> {
                        "cmc=8 "
                    }
                    10 -> {
                        "cmc=9 "
                    }
                    11 -> {
                        "cmc=10 "
                    }
                    12 -> {
                        "cmc=11 "
                    }
                    13 -> {
                        "cmc=12 "
                    }
                    14 -> {
                        "cmc=13 "
                    }
                    15 -> {
                        "cmc=14 "
                    }
                    16 -> {
                        "cmc=15 "
                    }
                    17 -> {
                        "cmc=16 "
                    }
                    18 -> {
                        "cmc>=17 "
                    }
                    else -> {
                        ""
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
                check18()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner.isFocusable = false

        val spinnerItems2 = if (locale == Locale.JAPAN) {
            arrayOf("指定しない                        ", "Standard", "Future", "Historic", "Gladiator", "Pioneer", "Modern", "Legacy", "Pauper", "Vintage", "Penny", "Commander",
                "Brawl", "Duel", "Oldschool", "Premodern", "Guilds of Ravnica", "Ixalan", "Amonkhet", "Kaladesh", "Shadows over Innistrad", "Battle for Zendikar", "Khans of Tarkir", "Theros",
                "Return to Ravnica", "Innistrad", "Scars of Mirrodin", "Zendikar", "Alara", "Shadowmoor", "Lorwyn", "Time Spiral", "Ravnica", "Kamigawa", "Mirrodin", "Onslaught", "Odyssey",
                "Invasion", "Masques", "Urza", "Tempest", "Mirage", "Ice Age", "Old Expansion")
        } else {
            arrayOf("No specified                        ", "Standard", "Future", "Historic", "Gladiator", "Pioneer", "Modern", "Legacy", "Pauper", "Vintage", "Penny", "Commander",
                "Brawl", "Duel", "Oldschool", "Premodern", "Guilds of Ravnica", "Ixalan", "Amonkhet", "Kaladesh", "Shadows over Innistrad", "Battle for Zendikar", "Khans of Tarkir", "Theros",
                "Return to Ravnica", "Innistrad", "Scars of Mirrodin", "Zendikar", "Alara", "Shadowmoor", "Lorwyn", "Time Spiral", "Ravnica", "Kamigawa", "Mirrodin", "Onslaught", "Odyssey",
                "Invasion", "Masques", "Urza", "Tempest", "Mirage", "Ice Age", "Old Expansion")
        }

        val adapter2 = ArrayAdapter(this, R.layout.spinner_item, spinnerItems2)

        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner2.adapter = customDropDownAdapter

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner2.isFocusable) {
                    spinner2.isFocusable = true
                    return
                }

                format = when(position) {
                    0 -> {
                        ""
                    }
                    1 -> {
                        "format:Standard "
                    }
                    2 -> {
                        "format:Future "
                    }
                    3 -> {
                        "format:Historic "
                    }
                    4 -> {
                        "format:Gladiator "
                    }
                    5 -> {
                        "format:Pioneer "
                    }
                    6 -> {
                        "format:Modern "
                    }
                    7 -> {
                        "format:Legacy "
                    }
                    8 -> {
                        "format:Pauper "
                    }
                    9 -> {
                        "format:Vintage "
                    }
                    10 -> {
                        "format:Penny "
                    }
                    11 -> {
                        "format:Commander "
                    }
                    12 -> {
                        "format:Brawl "
                    }
                    13 -> {
                        "format:Duel "
                    }
                    14 -> {
                        "format:Oldschool "
                    }
                    15 -> {
                        "format:Premodern "
                    }
                    16 -> {
                        "block:grn or "
                    }
                    17 -> {
                        "block:xln or "
                    }
                    18 -> {
                        "block:akh or "
                    }
                    19 -> {
                        "block:kld or "
                    }
                    20 -> {
                        "block:soi or "
                    }
                    21 -> {
                        "block:bfz or "
                    }
                    22 -> {
                        "block:ktk or "
                    }
                    23 -> {
                        "block:ths or "
                    }
                    24 -> {
                        "block:rtr or "
                    }
                    25 -> {
                        "block:isd or "
                    }
                    26 -> {
                        "block:som or "
                    }
                    27 -> {
                        "block:zen or "
                    }
                    28 -> {
                        "block:ala or "
                    }
                    29 -> {
                        "block:shm or "
                    }
                    30 -> {
                        "block:lrw or "
                    }
                    31 -> {
                        "block:tsp or "
                    }
                    32 -> {
                        "block:rav or "
                    }
                    33 -> {
                        "block:chk or "
                    }
                    34 -> {
                        "block:mrd or "
                    }
                    35 -> {
                        "block:ons or "
                    }
                    36 -> {
                        "block:ody or "
                    }
                    37 -> {
                        "block:inv or "
                    }
                    38 -> {
                        "block:mmq or "
                    }
                    39 -> {
                        "block:usg or "
                    }
                    40 -> {
                        "block:tmp or "
                    }
                    41 -> {
                        "block:mir or "
                    }
                    42 -> {
                        "block:ice or "
                    }
                    43 -> {
                        "set:hml or set:fem or set:drk or set:leg or set:atq or set:arn or "
                    }
                    else -> {
                        ""
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
                check18()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner2.isFocusable = false

        val spinnerItems3 = if (locale == Locale.JAPAN) {
            arrayOf(
                "含めない",
                "Core Set 2021 (M21)",
                "Core Set 2020 (M20)",
                "Core Set 2019 (M19)",
                "Magic Origins (ORI)",
                "Magic 2015 (M15)",
                "Magic 2014 (M14)",
                "Magic 2013 (M13)",
                "Magic 2012 (M12)",
                "Magic 2011 (M11)",
                "Magic 2010 (M10)",
                "Tenth Edition (10E)",
                "Ninth Edition (9ED)",
                "Eighth Edition (8ED)",
                "Seventh Edition (7ED)",
                "Classic Sixth Edition (6ED)",
                "Fifth Edition (5ED)",
                "Fourth Edition (4ED)",
                "Revised Edition (3ED)",
                "Unlimited Edition (2ED)",
                "Limited Edition Beta (LEB)",
                "Limited Edition Alpha (LEA)"
            )
        } else {
            arrayOf(
                "No including",
                "Core Set 2021 (M21)",
                "Core Set 2020 (M20)",
                "Core Set 2019 (M19)",
                "Magic Origins (ORI)",
                "Magic 2015 (M15)",
                "Magic 2014 (M14)",
                "Magic 2013 (M13)",
                "Magic 2012 (M12)",
                "Magic 2011 (M11)",
                "Magic 2010 (M10)",
                "Tenth Edition (10E)",
                "Ninth Edition (9ED)",
                "Eighth Edition (8ED)",
                "Seventh Edition (7ED)",
                "Classic Sixth Edition (6ED)",
                "Fifth Edition (5ED)",
                "Fourth Edition (4ED)",
                "Revised Edition (3ED)",
                "Unlimited Edition (2ED)",
                "Limited Edition Beta (LEB)",
                "Limited Edition Alpha (LEA)"
            )
        }

        val adapter3 = ArrayAdapter(this, R.layout.spinner_item, spinnerItems3)

        adapter3.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner3.adapter = customDropDownAdapter2

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!spinner3.isFocusable) {
                    spinner3.isFocusable = true
                    return
                }
                core = when(position) {
                    0 -> {
                        ""
                    }
                    1 -> {
                        "set:m21"
                    }
                    2 -> {
                        "set:m20"
                    }
                    3 -> {
                        "set:m19"
                    }
                    4 -> {
                        "set:ori"
                    }
                    5 -> {
                        "set:m15"
                    }
                    6 -> {
                        "set:m14"
                    }
                    7 -> {
                        "set:m13"
                    }
                    8 -> {
                        "set:m12"
                    }
                    9 -> {
                        "set:m11"
                    }
                    10 -> {
                        "set:m10"
                    }
                    11 -> {
                        "set:10e"
                    }
                    12 -> {
                        "set:9ed"
                    }
                    13 -> {
                        "set:8ed"
                    }
                    14 -> {
                        "set:7ed"
                    }
                    15 -> {
                        "set:6ed"
                    }
                    16 -> {
                        "set:5ed"
                    }
                    17 -> {
                        "set:4ed"
                    }
                    18 -> {
                        "set:3ed"
                    }
                    19 -> {
                        "set:2ed"
                    }
                    20 -> {
                        "set:leb"
                    }
                    21 -> {
                        "set:lea"
                    }
                    else -> {
                        ""
                    }
                }
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
                check18()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner3.isFocusable = false

        checkbox.setOnCheckedChangeListener { _, _ ->
            if (checkbox.isChecked) {
                type = "type:creature or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }
        checkbox2.setOnCheckedChangeListener { _, _ ->
            if (checkbox2.isChecked) {
                type2 = "type:planeswalker or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type2 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }
        checkbox3.setOnCheckedChangeListener { _, _ ->
            if (checkbox3.isChecked) {
                type3 = "type:Artifact or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type3 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }
        checkbox4.setOnCheckedChangeListener { _, _ ->
            if (checkbox4.isChecked) {
                type4 = "type:Instant or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type4 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }
        checkbox5.setOnCheckedChangeListener { _, _ ->
            if (checkbox5.isChecked) {
                type5 = "type:Sorcery or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type5 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }
        checkbox6.setOnCheckedChangeListener { _, _ ->
            if (checkbox6.isChecked) {
                type6 = "type:Enchantment or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type6 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }
        checkbox7.setOnCheckedChangeListener { _, _ ->
            if (checkbox7.isChecked) {
                type7 = "type:Land or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type7 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }

        radiogroup.setOnCheckedChangeListener { _, _ ->
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
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox8.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color = "W"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox8.isChecked) {
                    color = "W"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox8.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color = "W"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox8.isChecked) {
                    color = "W"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox8.isChecked) {
                    color = "color=W or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox9.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox9.isChecked) {
                    color2 = "color=U or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color2 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox9.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color2 = "U"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox9.isChecked) {
                    color2 = "U"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color2 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox9.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color2 = "U"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox9.isChecked) {
                    color2 = "U"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color2 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox9.isChecked) {
                    color2 = "color=U or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color2 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox10.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox10.isChecked) {
                    color3 = "color=B or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color3 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox10.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color3 = "B"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox10.isChecked) {
                    color3 = "B"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color3 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox10.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color3 = "B"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox10.isChecked) {
                    color3 = "B"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color3 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox10.isChecked) {
                    color3 = "color=B or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color3 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox11.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox11.isChecked) {
                    color4 = "color=R or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color4 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox11.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color4 = "R"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox11.isChecked) {
                    color4 = "R"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color4 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox11.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color4 = "R"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox11.isChecked) {
                    color4 = "R"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color4 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox11.isChecked) {
                    color4 = "color=R or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color4 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox12.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox12.isChecked) {
                    color5 = "color=G or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color5 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox12.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color5 = "G"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox12.isChecked) {
                    color5 = "G"
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color5 = ""
                    colorsign = "Color="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox12.isChecked && checkbox13.isChecked){
                    checkbox13.isChecked = false
                    color6 = ""
                    color5 = "G"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                } else if (checkbox12.isChecked) {
                    color5 = "G"
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color5 = ""
                    colorsign = "Color<="
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox12.isChecked) {
                    color5 = "color=G or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color5 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox13.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox13.isChecked) {
                    color6 = "color=C or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
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
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($format$core)$cost$funny$firstprint")
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
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
                else -> if (checkbox13.isChecked) {
                    color6 = "color=C or "
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    check18()
                } else {
                    color6 = ""
                    edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                    checkColor()
                    check()
                }
            }
        }

        checkbox14.setOnCheckedChangeListener { _, _ ->
            if (checkbox14.isChecked) {
                funny = "-is:funny "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                funny= ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }

        checkbox15.setOnCheckedChangeListener { _, _ ->
            if (checkbox15.isChecked) {
                firstprint = "is:firstprint"
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                firstprint = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check()
            }
        }

        checkbox16.setOnCheckedChangeListener { _, _ ->
            if (checkbox16.isChecked) {
                type8 = "is:Commander or "
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
                check18()
            } else {
                type8 = ""
                edittext.setText("https://scryfall.com/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint")
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
                checkbox18.isChecked = false
                radiogroup.clearCheck()
                spinner.setSelection(0)
                spinner2.setSelection(0)
                spinner3.setSelection(0)
                edittext.setText("https://scryfall.com/random?q=")
            }
        }

        checkbox18.setOnCheckedChangeListener { _, _ ->
            if (checkbox18.isChecked) {
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
                radiogroup.clearCheck()
                spinner.setSelection(0)
                spinner2.setSelection(0)
                spinner3.setSelection(0)
                edittext.setText("https://scryfall.com/random?q=type:vanguard")
            } else {
                check()
            }
        }

        button.setOnClickListener{
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView2.visibility = View.INVISIBLE
            webView.loadUrl(edittext.text.toString())
        }
        button2.setOnClickListener{
            when {
                webView2.isVisible && webView.isInvisible -> {
                    webView2.visibility = View.INVISIBLE
                    layoutView.visibility = View.VISIBLE
                }
                webView2.isVisible -> {
                    webView2.visibility = View.INVISIBLE
                }
                webView.isVisible -> {
                    webView.visibility = View.INVISIBLE
                    layoutView.visibility = View.VISIBLE
                }
                webView.isInvisible -> {
                    webView.visibility = View.VISIBLE
                    layoutView.visibility = View.INVISIBLE
                }
            }
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
            val engName = webView.url?.replaceBeforeLast("/","")?.replace("/","")
            thread {
                try {
                    val api = URL("https://api.scryfall.com/cards/search?q=!$engName lang:ja").readText()

                    val jaName = api.replaceBeforeLast("\"printed_name\":\"","").replace("\"printed_name\":\"","").replaceAfterLast("\",\"lang\":\"ja\"","").replace("\",\"lang\":\"ja\"","/")
                    val enName = api.replaceBeforeLast("\"name\":\"","").replace("\"name\":\"","").replaceAfterLast("\",\"printed_name\":\"","").replace("\",\"printed_name\":\"","")

                    jaName2 = jaName
                    enName2 = enName
                } catch (e: Exception) {
                    val api = URL("https://api.scryfall.com/cards/search?q=!$engName").readText()

                    val enName = api.replaceBeforeLast("\"name\":\"","").replace("\"name\":\"","").replaceAfterLast("\",\"lang\":\"en\"","").replace("\",\"lang\":\"en\"","")

                    jaName2 = ""
                    enName2 = enName
                } finally {
                    return@thread
                }
            }.join()

            layoutView.visibility = View.INVISIBLE
            webView2.visibility = View.VISIBLE
            if (locale == Locale.JAPAN) {
                webView2.loadUrl("http://m.mtgwiki.com/wiki/$jaName2${enName2.replace(" ", "_")}")
            } else {
                webView2.loadUrl("https://translate.google.com/translate?sl=auto&tl=en&u=http://m.mtgwiki.com/wiki/$jaName2${enName2.replace(" ", "_")}")
            }

        }
        textview.setOnClickListener {
            spinner.performClick()
        }
        textview2.setOnClickListener {
            spinner2.performClick()
        }
        textview3.setOnClickListener {
            spinner3.performClick()
        }
    }
}