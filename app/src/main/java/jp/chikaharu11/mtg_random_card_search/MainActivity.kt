package jp.chikaharu11.mtg_random_card_search

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import jp.chikaharu11.mtg_random_card_search.databinding.ActivityMainBinding
import org.json.JSONObject
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var type = ""
    private var type2 = ""
    private var type3 = ""
    private var type4 = ""
    private var type5 = ""
    private var type6 = ""
    private var type7 = ""
    private var type8 = ""
    private var rarity1 = ""
    private var rarity2 = ""
    private var rarity3 = ""
    private var rarity4 = ""
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

    private lateinit var apiURL: JSONObject
    private var apiURLimage = ""
    private var apiURLimage2 = ""
    private var apiName = ""

    private val handler = Handler()

    private val locale: Locale = Locale.getDefault()


    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n", "ClickableViewAccessibility", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .apply { setContentView(this.root) }

        val webView = findViewById<WebView>(R.id.webView)
        val webView2 = findViewById<WebView>(R.id.webView2)
        val webView3 = findViewById<WebView>(R.id.webView3)

        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.setInitialScale(1)
        webView.loadUrl("file:///android_asset/card_back.html")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?,
            ): Boolean {
                return false
            }
        }

        webView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                webView.visibility = View.INVISIBLE
                webView3.visibility = View.VISIBLE
            }
            false
        }

        webView3.settings.loadWithOverviewMode = true
        webView3.settings.useWideViewPort = true
        webView3.setInitialScale(1)
        webView3.loadUrl("file:///android_asset/card_back.html")

        webView3.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?,
            ): Boolean {
                return false
            }
        }

        webView3.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                webView.visibility = View.VISIBLE
                webView3.visibility = View.INVISIBLE
            }
            false
        }


        webView2.settings.loadWithOverviewMode = true
        webView2.settings.displayZoomControls = false
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

        MobileAds.initialize(this) {}

        val adView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val searchtext = findViewById<TextView>(R.id.searchText)

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

        val checkbox19 = findViewById<CheckBox>(R.id.checkBox19)
        val checkbox20 = findViewById<CheckBox>(R.id.checkBox20)
        val checkbox21 = findViewById<CheckBox>(R.id.checkBox21)
        val checkbox22 = findViewById<CheckBox>(R.id.checkBox22)

        val radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radiobutton = findViewById<RadioButton>(R.id.radioButton)
        val radiobutton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radiobutton3 = findViewById<RadioButton>(R.id.radioButton3)

        val textview = findViewById<TextView>(R.id.textView)
        val textview2 = findViewById<TextView>(R.id.textView2)
        val textview3 = findViewById<TextView>(R.id.textView3)


        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)


        fun check() {
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
                !checkbox19.isChecked &&
                !checkbox20.isChecked &&
                !checkbox21.isChecked &&
                !checkbox22.isChecked &&
                spinner.selectedItemPosition == 0 &&
                spinner2.selectedItemPosition == 0 &&
                spinner3.selectedItemPosition == 0
            ) {
                searchtext.text = "https://api.scryfall.com/cards/random?q="
            }
        }

        fun check18() {
            if (checkbox18.isChecked)
                checkbox18.isChecked = false
        }

        fun checkColor() {
            if (
                !checkbox8.isChecked &&
                !checkbox9.isChecked &&
                !checkbox10.isChecked &&
                !checkbox11.isChecked &&
                !checkbox12.isChecked &&
                !checkbox13.isChecked
            ) {
                colorsign = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
            }
        }

        binding.spinner.adapter = ModelArrayAdapter(
            this,
            listOf(
                Model(R.drawable.transparent, getString(R.string.specified)),
                Model(R.drawable.c0, "0"),
                Model(R.drawable.c1, "1"),
                Model(R.drawable.c2, "2"),
                Model(R.drawable.c3, "3"),
                Model(R.drawable.c4, "4"),
                Model(R.drawable.c5, "5"),
                Model(R.drawable.c6, "6"),
                Model(R.drawable.c7, "7"),
                Model(R.drawable.c8, "8"),
                Model(R.drawable.c9, "9"),
                Model(R.drawable.c10, "10"),
                Model(R.drawable.c11, "11"),
                Model(R.drawable.c12, "12"),
                Model(R.drawable.c13, "13"),
                Model(R.drawable.c14, "14"),
                Model(R.drawable.c15, "15"),
                Model(R.drawable.c16, "16"),
                Model(R.drawable.c17, "17")
            )
        )

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!spinner.isFocusable) {
                    spinner.isFocusable = true
                    return
                }
                cost = when (position) {
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
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
                check18()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner.isFocusable = false

        binding.spinner2.adapter = ModelArrayAdapter(
            this,
            listOf(
                Model(R.drawable.transparent, getString(R.string.specified)),
                Model(R.drawable.transparent, "Standard"),
                Model(R.drawable.transparent, "Future"),
                Model(R.drawable.transparent, "Historic"),
                Model(R.drawable.transparent, "Gladiator"),
                Model(R.drawable.transparent, "Pioneer"),
                Model(R.drawable.transparent, "Modern"),
                Model(R.drawable.transparent, "Legacy"),
                Model(R.drawable.transparent, "Pauper"),
                Model(R.drawable.transparent, "Vintage"),
                Model(R.drawable.transparent, "Penny"),
                Model(R.drawable.transparent, "Commander"),
                Model(R.drawable.transparent, "Brawl"),
                Model(R.drawable.transparent, "Duel"),
                Model(R.drawable.transparent, "Oldschool"),
                Model(R.drawable.transparent, "Premodern"),
                Model(R.drawable.mid, "Innistrad: Midnight Hunt ~ Innistrad: Crimson Vow"),
                Model(R.drawable.znr, "Zendikar Rising ~ Strixhaven: School of Mages"),
                Model(R.drawable.eld, "Throne of Eldraine ~ Ikoria: Lair of Behemoths"),
                Model(R.drawable.grn, "Guilds of Ravnica Block"),
                Model(R.drawable.xln, "Ixalan Block + Dominaria"),
                Model(R.drawable.akh, "Amonkhet Block"),
                Model(R.drawable.kld, "Kaladesh Block"),
                Model(R.drawable.soi, "Shadows over Innistrad Block"),
                Model(R.drawable.bfz, "Battle for Zendikar Block"),
                Model(R.drawable.ktk, "Khans of Tarkir Block"),
                Model(R.drawable.ths, "Theros Block"),
                Model(R.drawable.rtr, "Return to Ravnica Block"),
                Model(R.drawable.isd, "Innistrad Block"),
                Model(R.drawable.som, "Scars of Mirrodin Block"),
                Model(R.drawable.zen, "Zendikar Block"),
                Model(R.drawable.ala, "Alara Block"),
                Model(R.drawable.shm, "Shadowmoor Block"),
                Model(R.drawable.lrw, "Lorwyn Block"),
                Model(R.drawable.tsp, "Time Spiral Block"),
                Model(R.drawable.rav, "Ravnica Block"),
                Model(R.drawable.chk, "Kamigawa Block"),
                Model(R.drawable.mrd, "Mirrodin Block"),
                Model(R.drawable.ons, "Onslaught Block"),
                Model(R.drawable.ody, "Odyssey Block"),
                Model(R.drawable.inv, "Invasion Block"),
                Model(R.drawable.mmq, "Masques Block"),
                Model(R.drawable.usg, "Urza Block"),
                Model(R.drawable.tmp, "Tempest Block"),
                Model(R.drawable.mir, "Mirage Block"),
                Model(R.drawable.ice, "Ice Age Block"),
                Model(R.drawable.transparent, "Old Expansion")
            )
        )

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!spinner2.isFocusable) {
                    spinner2.isFocusable = true
                    return
                }

                format = when (position) {
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
                        "set:mid or set:vow or "
                    }
                    17 -> {
                        "set:stx or set:khm or set:znr or "
                    }
                    18 -> {
                        "set:iko or set:thb or set:eld or "
                    }
                    19 -> {
                        "block:grn or "
                    }
                    20 -> {
                        "block:xln or set:dom or "
                    }
                    21 -> {
                        "block:akh or "
                    }
                    22 -> {
                        "block:kld or "
                    }
                    23 -> {
                        "block:soi or "
                    }
                    24 -> {
                        "block:bfz or "
                    }
                    25 -> {
                        "block:ktk or "
                    }
                    26 -> {
                        "block:ths or "
                    }
                    27 -> {
                        "block:rtr or "
                    }
                    28 -> {
                        "block:isd or "
                    }
                    29 -> {
                        "block:som or "
                    }
                    30 -> {
                        "block:zen or "
                    }
                    31 -> {
                        "block:ala or "
                    }
                    32 -> {
                        "block:shm or "
                    }
                    33 -> {
                        "block:lrw or "
                    }
                    34 -> {
                        "block:tsp or "
                    }
                    35 -> {
                        "block:rav or "
                    }
                    36 -> {
                        "block:chk or "
                    }
                    37 -> {
                        "block:mrd or "
                    }
                    38 -> {
                        "block:ons or "
                    }
                    39 -> {
                        "block:ody or "
                    }
                    40 -> {
                        "block:inv or "
                    }
                    41 -> {
                        "block:mmq or "
                    }
                    42 -> {
                        "block:usg or "
                    }
                    43 -> {
                        "block:tmp or "
                    }
                    44 -> {
                        "block:mir or "
                    }
                    45 -> {
                        "block:ice or "
                    }
                    46 -> {
                        "set:hml or set:fem or set:drk or set:leg or set:atq or set:arn or "
                    }
                    else -> {
                        ""
                    }
                }
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
                check18()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinner2.isFocusable = false

        binding.spinner3.adapter = ModelArrayAdapter(
            this,
            listOf(
                Model(R.drawable.transparent, getString(R.string.specified)),
                Model(R.drawable.afr, "Adventures in the Forgotten Realms (AFR)"),
                Model(R.drawable.m21, "Core Set 2021 (M21)"),
                Model(R.drawable.m20, "Core Set 2020 (M20)"),
                Model(R.drawable.m19, "Core Set 2019 (M19)"),
                Model(R.drawable.ori, "Magic Origins (ORI)"),
                Model(R.drawable.m15, "Magic 2015 (M15)"),
                Model(R.drawable.m14, "Magic 2014 (M14)"),
                Model(R.drawable.m13, "Magic 2013 (M13)"),
                Model(R.drawable.m12, "Magic 2012 (M12)"),
                Model(R.drawable.m11, "Magic 2011 (M11)"),
                Model(R.drawable.m10, "Magic 2010 (M10)"),
                Model(R.drawable.e10, "Tenth Edition (10E)"),
                Model(R.drawable.ed9, "Ninth Edition (9ED)"),
                Model(R.drawable.ed8, "Eighth Edition (8ED)"),
                Model(R.drawable.ed7, "Seventh Edition (7ED)"),
                Model(R.drawable.ed6, "Classic Sixth Edition (6ED)"),
                Model(R.drawable.e5, "Fifth Edition (5ED)"),
                Model(R.drawable.e4, "Fourth Edition (4ED)"),
                Model(R.drawable.r, "Revised Edition (3ED)"),
                Model(R.drawable.u, "Unlimited Edition (2ED)"),
                Model(R.drawable.b, "Limited Edition Beta (LEB)"),
                Model(R.drawable.a, "Limited Edition Alpha (LEA)")
            )
        )

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!spinner3.isFocusable) {
                    spinner3.isFocusable = true
                    return
                }
                core = when (position) {
                    0 -> {
                        ""
                    }
                    1 -> {
                        "set:afr"
                    }
                    2 -> {
                        "set:m21"
                    }
                    3 -> {
                        "set:m20"
                    }
                    4 -> {
                        "set:m19"
                    }
                    5 -> {
                        "set:ori"
                    }
                    6 -> {
                        "set:m15"
                    }
                    7 -> {
                        "set:m14"
                    }
                    8 -> {
                        "set:m13"
                    }
                    9 -> {
                        "set:m12"
                    }
                    10 -> {
                        "set:m11"
                    }
                    11 -> {
                        "set:m10"
                    }
                    12 -> {
                        "set:10e"
                    }
                    13 -> {
                        "set:9ed"
                    }
                    14 -> {
                        "set:8ed"
                    }
                    15 -> {
                        "set:7ed"
                    }
                    16 -> {
                        "set:6ed"
                    }
                    17 -> {
                        "set:5ed"
                    }
                    18 -> {
                        "set:4ed"
                    }
                    19 -> {
                        "set:3ed"
                    }
                    20 -> {
                        "set:2ed"
                    }
                    21 -> {
                        "set:leb"
                    }
                    22 -> {
                        "set:lea"
                    }
                    else -> {
                        ""
                    }
                }
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
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
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }
        checkbox2.setOnCheckedChangeListener { _, _ ->
            if (checkbox2.isChecked) {
                type2 = "type:planeswalker or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type2 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }
        checkbox3.setOnCheckedChangeListener { _, _ ->
            if (checkbox3.isChecked) {
                type3 = "type:Artifact or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type3 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }
        checkbox4.setOnCheckedChangeListener { _, _ ->
            if (checkbox4.isChecked) {
                type4 = "type:Instant or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type4 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }
        checkbox5.setOnCheckedChangeListener { _, _ ->
            if (checkbox5.isChecked) {
                type5 = "type:Sorcery or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type5 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }
        checkbox6.setOnCheckedChangeListener { _, _ ->
            if (checkbox6.isChecked) {
                type6 = "type:Enchantment or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type6 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }
        checkbox7.setOnCheckedChangeListener { _, _ ->
            if (checkbox7.isChecked) {
                type7 = "type:Land or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type7 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
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
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox8.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color = "W"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox8.isChecked) {
                    color = "W"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color = ""
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox8.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color = "W"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox8.isChecked) {
                    color = "W"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color = ""
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                else -> if (checkbox8.isChecked) {
                    color = "color=W or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
            }
        }

        checkbox9.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox9.isChecked) {
                    color2 = "color=U or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color2 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox9.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color2 = "U"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox9.isChecked) {
                    color2 = "U"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color2 = ""
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox9.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color2 = "U"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox9.isChecked) {
                    color2 = "U"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color2 = ""
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                else -> if (checkbox9.isChecked) {
                    color2 = "color=U or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color2 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
            }
        }

        checkbox10.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox10.isChecked) {
                    color3 = "color=B or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color3 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox10.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color3 = "B"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox10.isChecked) {
                    color3 = "B"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color3 = ""
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox10.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color3 = "B"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox10.isChecked) {
                    color3 = "B"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color3 = ""
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                else -> if (checkbox10.isChecked) {
                    color3 = "color=B or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color3 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
            }
        }

        checkbox11.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox11.isChecked) {
                    color4 = "color=R or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color4 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox11.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color4 = "R"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox11.isChecked) {
                    color4 = "R"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color4 = ""
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox11.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color4 = "R"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox11.isChecked) {
                    color4 = "R"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color4 = ""
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                else -> if (checkbox11.isChecked) {
                    color4 = "color=R or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color4 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
            }
        }

        checkbox12.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox12.isChecked) {
                    color5 = "color=G or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color5 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton2.isChecked -> if (checkbox12.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color5 = "G"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox12.isChecked) {
                    color5 = "G"
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color5 = ""
                    colorsign = "Color="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                radiobutton3.isChecked -> if (checkbox12.isChecked && checkbox13.isChecked) {
                    checkbox13.isChecked = false
                    color6 = ""
                    color5 = "G"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                } else if (checkbox12.isChecked) {
                    color5 = "G"
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color5 = ""
                    colorsign = "Color<="
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                else -> if (checkbox12.isChecked) {
                    color5 = "color=G or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color5 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
            }
        }

        checkbox13.setOnCheckedChangeListener { _, _ ->
            when {
                radiobutton.isChecked -> if (checkbox13.isChecked) {
                    color6 = "color=C or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color6 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
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
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color6 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($format$core)$cost$funny$firstprint"
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
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color6 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
                else -> if (checkbox13.isChecked) {
                    color6 = "color=C or "
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    check18()
                } else {
                    color6 = ""
                    searchtext.text =
                        "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                    checkColor()
                    check()
                }
            }
        }

        checkbox14.setOnCheckedChangeListener { _, _ ->
            if (checkbox14.isChecked) {
                funny = "-is:funny "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                funny = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }

        checkbox15.setOnCheckedChangeListener { _, _ ->
            if (checkbox15.isChecked) {
                firstprint = "is:firstprint"
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                firstprint = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }

        checkbox16.setOnCheckedChangeListener { _, _ ->
            if (checkbox16.isChecked) {
                type8 = "is:Commander or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                type8 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
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
                checkbox19.isChecked = false
                checkbox20.isChecked = false
                checkbox21.isChecked = false
                checkbox22.isChecked = false

                radiogroup.clearCheck()
                spinner.setSelection(0)
                spinner2.setSelection(0)
                spinner3.setSelection(0)
                searchtext.text = "https://api.scryfall.com/cards/random?q="
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
                checkbox19.isChecked = false
                checkbox20.isChecked = false
                checkbox21.isChecked = false
                checkbox22.isChecked = false
                radiogroup.clearCheck()
                spinner.setSelection(0)
                spinner2.setSelection(0)
                spinner3.setSelection(0)
                searchtext.text = "https://api.scryfall.com/cards/random?q=type:vanguard"
            } else {
                check()
            }
        }

        checkbox19.setOnCheckedChangeListener { _, _ ->
            if (checkbox19.isChecked) {
                rarity1 = "rarity:c or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                rarity1 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }

        checkbox20.setOnCheckedChangeListener { _, _ ->
            if (checkbox20.isChecked) {
                rarity2 = "rarity:u or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                rarity2 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }

        checkbox21.setOnCheckedChangeListener { _, _ ->
            if (checkbox21.isChecked) {
                rarity3 = "rarity:r or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                rarity3 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
            }
        }

        checkbox22.setOnCheckedChangeListener { _, _ ->
            if (checkbox22.isChecked) {
                rarity4 = "rarity:m or "
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check18()
            } else {
                rarity4 = ""
                searchtext.text =
                    "https://api.scryfall.com/cards/random?q=($type$type2$type3$type4$type5$type6$type7$type8)($rarity1$rarity2$rarity3$rarity4)($colorsign$color$color2$color3$color4$color5$color6)($format$core)$cost$funny$firstprint"
                check()
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
        binding.imageButton.setOnClickListener {
            when {
                binding.webView2.isVisible && binding.webView.isInvisible -> {
                    binding.webView2.visibility = View.INVISIBLE
                    binding.layoutView.visibility = View.VISIBLE
                }
                binding.webView2.isVisible -> {
                    binding.webView2.visibility = View.INVISIBLE
                }
                binding.webView.isVisible -> {
                    binding.webView.visibility = View.INVISIBLE
                    binding.layoutView.visibility = View.VISIBLE
                }
                binding.webView3.isVisible -> {
                    binding.webView.visibility = View.VISIBLE
                    binding.webView3.visibility = View.INVISIBLE
                    binding.layoutView.visibility = View.INVISIBLE
                }
                binding.webView.isInvisible -> {
                    binding.webView.visibility = View.VISIBLE
                    binding.layoutView.visibility = View.INVISIBLE
                }
            }
        }
        binding.imageButton2.setOnClickListener {
            thread {
                try {
                    val api = URL(findViewById<TextView>(R.id.searchText).text.toString()).readText()
                    apiURL = JSONObject(api)
                    apiURLimage = apiURL.getJSONObject("image_uris").getString("normal")
                    apiName = apiURL.getString("name")
                    println(apiName)
                    apiURLimage2 = "file:///android_asset/card_back.html"
                } catch (e: Exception) {
                    try {
                        val cardFaces = apiURL.getJSONArray("card_faces").getJSONObject(0)
                        val cardFaces2 = apiURL.getJSONArray("card_faces").getJSONObject(1)
                        apiName = cardFaces.getString("name")
                        println(apiName)
                        apiURLimage = cardFaces.getJSONObject("image_uris").getString("normal")
                        apiURLimage2 = cardFaces2.getJSONObject("image_uris").getString("normal")

                    } catch (e: Exception) {
                        apiURLimage = "file:///android_asset/card_back.html"
                        apiURLimage2 = "file:///android_asset/card_back.html"
                    }
                }
            }.join()
            binding.webView.setInitialScale(1)
            binding.webView3.setInitialScale(1)
            binding.webView.loadUrl(apiURLimage)
            binding.webView3.loadUrl(apiURLimage2)
            binding.layoutView.visibility = View.INVISIBLE
            binding.webView.visibility = View.VISIBLE
            binding.webView3.visibility = View.INVISIBLE
            binding.webView2.visibility = View.INVISIBLE
        }
        binding.imageButton3.setOnClickListener {
            thread {
                try {
                    println(cardName[apiName])
                    if (cardName[apiName] != null){
                        jaName2 = cardName[apiName].toString() + "/"
                        enName2 = apiName
                    } else {
                        val name = apiName.replace(" ", "-").lowercase(Locale.getDefault())
                        val api =
                            URL("https://api.scryfall.com/cards/search?q=!$name%20lang:ja").readText()
                        val json = JSONObject(api)
                        val data = json.getJSONArray("data").getJSONObject(0)
                        val cardFaces = data.getJSONArray("card_faces").getJSONObject(0)
                        val jaName = cardFaces.getString("printed_name")
                        val enName = cardFaces.getString("name")

                        jaName2 = "$jaName/"
                        enName2 = enName
                    }
                } catch (e: Exception) {
                    try {
                        val name = apiName.replace(" ", "-").lowercase(Locale.getDefault())
                        val api =
                            URL("https://api.scryfall.com/cards/search?q=!$name%20lang:ja").readText()
                        val json = JSONObject(api)
                        val data = json.getJSONArray("data").getJSONObject(0)
                        val jaName = data.getString("printed_name")
                        val enName = data.getString("name")

                        jaName2 = "$jaName/"
                        enName2 = enName
                    } catch (e: Exception) {
                        try {
                            val name = apiName.replace(" ", "-").lowercase(Locale.getDefault())
                            val api =
                                URL("https://api.scryfall.com/cards/search?q=!$name").readText()
                            val json = JSONObject(api)
                            val data = json.getJSONArray("data").getJSONObject(0)
                            val enName = data.getString("name")

                            jaName2 = ""
                            enName2 = enName
                        } catch (e: Exception) {
                            handler.post {
                                Toast.makeText(applicationContext,
                                    R.string.error,
                                    Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                }
            }.join()

            binding.layoutView.visibility = View.INVISIBLE
            binding.webView2.visibility = View.VISIBLE
            binding.webView3.visibility = View.INVISIBLE
            if (locale == Locale.JAPAN) {
                binding.webView2.loadUrl("http://m.mtgwiki.com/wiki/$jaName2${enName2.replace(" ", "_")}")
            } else {
                binding.webView2.loadUrl("https://translate.google.com/translate?sl=auto&tl=en&u=http://m.mtgwiki.com/wiki/$jaName2${
                    enName2.replace(" ", "_")}")
            }
        }
        binding.imageButton4.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.exit2)
                .setPositiveButton("YES") { _, _ ->
                    finish()
                }
                .setNegativeButton("NO") { _, _ ->

                }
                .show()
        }
    }

    private val cardName = mapOf(
        "Alluring Suitor" to "魅惑する求婚者",
        "Ambitious Farmhand" to "野心的な農場労働者",
        "Arlinn, the Pack's Hope" to "群れの希望、アーリン",
        "Avabruck Caretaker" to "アヴァブルックの世話人",
        "Baithook Angler" to "餌鉤の釣り人",
        "Ballista Watcher" to "バリスタの監視兵",
        "Baneblade Scoundrel" to "破滅刃の悪漢",
        "Beloved Beggar" to "愛される物乞い",
        "Bereaved Survivor" to "先立たれた生存者",
        "Binding Geist" to "拘束の霊",
        "Biolume Egg" to "生物光の卵",
        "Bird Admirer" to "鳥の称賛者",
        "Bloodsworn Squire" to "血誓いの従士",
        "Brine Comber" to "塩水漁り",
        "Brutal Cathar" to "粗暴な聖戦士",
        "Burly Breaker" to "筋骨隆々の破壊者",
        "Catapult Fodder" to "カタパルトの有象無象",
        "Chaplain of Alms" to "施しの司祭",
        "Child of the Pack" to "群れの仔",
        "Concealing Curtains" to "隠し幕",
        "Covert Cutpurse" to "思慮深き巾着切り",
        "Covetous Castaway" to "欲深き逃散者",
        "Curse of Leeches" to "ヒルの呪い",
        "Deathbonnet Sprout" to "シボウタケの若芽",
        "Delver of Secrets" to "秘密を掘り下げる者",
        "Dennick, Pious Apprentice" to "敬虔な新米、デニック",
        "Desperate Farmer" to "不貞腐れる農家",
        "Devoted Grafkeeper" to "意気盛んな墓守り",
        "Distracting Geist" to "撹乱する霊",
        "Dormant Grove" to "休樹林帯",
        "Dorothea, Vengeful Victim" to "復讐に燃えた犠牲者、ドロテア",
        "Drogskol Infantry" to "ドラグスコルの歩兵",
        "Ecstatic Awakener" to "有頂天の呼び覚ます者",
        "Edgar, Charmed Groom" to "魅せられた花婿、エドガー",
        "Enduring Angel" to "不朽の天使",
        "Faithbound Judge" to "信仰縛りの審判官",
        "Fangblade Brigand" to "牙刃の盗賊",
        "Fearful Villager" to "恐れる村人",
        "Flame Channeler" to "炎の媒介者",
        "Foreboding Statue" to "予言の像",
        "Galedrifter" to "突風漂い",
        "Graveyard Trespasser" to "墓地の侵入者",
        "Gutter Skulker" to "排水路に潜むもの",
        "Harvesttide Infiltrator" to "収穫祭の潜入者",
        "Heirloom Mirror" to "先祖伝来の鏡",
        "Henrika Domnathi" to "ヘンリカ・ダムナティ",
        "Hookhand Mariner" to "鉤手の船乗り",
        "Hostile Hostel" to "敵意ある宿屋",
        "Hound Tamer" to "猟犬調教師",
        "Howlpack Piper" to "吠え群れの笛吹き",
        "Ill-Tempered Loner" to "不機嫌な一匹狼",
        "Infestation Expert" to "寄生の専門家",
        "Innocent Traveler" to "無害な旅人",
        "Jacob Hauken, Inspector" to "捜査員、ジェイコブ・ハーキン",
        "Jerren, Corrupted Bishop" to "堕落した司教、ジェレン",
        "Katilda, Dawnhart Martyr" to "ドーンハルトの殉教者、カティルダ",
        "Kessig Naturalist" to "ケッシグの自然主義者",
        "Kindly Ancestor" to "慈愛の祖霊",
        "Lambholt Raconteur" to "ラムホルトの講談家",
        "Lantern Bearer" to "ランタンを携える者",
        "Ludevic, Necrogenius" to "屍術の俊英、ルーデヴィック",
        "Lunarch Veteran" to "月皇の古参兵",
        "Malevolent Hermit" to "心悪しき隠遁者",
        "Mirrorhall Mimic" to "鏡の間のミミック",
        "Mischievous Catgeist" to "悪戯な猫霊",
        "Mourning Patrol" to "哀悼の巡回兵",
        "Mysterious Tome" to "不思議な秘本",
        "Mystic Skull" to "神秘の頭蓋骨",
        "Oakshade Stalker" to "樫影の忍び寄るもの",
        "Outland Liberator" to "辺境地の罠外し",
        "Overwhelmed Archivist" to "圧倒される文書管理人",
        "Panicked Bystander" to "動揺する傍観者",
        "Poppet Stitcher" to "戯れ児の縫い師",
        "Radiant Grace" to "放光の恵み",
        "Ragged Recluse" to "ほつれ服の世捨て人",
        "Reckless Stormseeker" to "無謀な嵐探し",
        "Restless Bloodseeker" to "眠れぬ求血者",
        "Runo Stromkirk" to "流城のルノ",
        "Shady Traveler" to "不審な旅行者",
        "Smoldering Egg" to "くすぶる卵",
        "Soulcipher Board" to "魂暗号の木盤",
        "Spellrune Painter" to "ルーン綴りの絵描き",
        "Suspicious Stowaway" to "怪しげな密航者",
        "Tavern Ruffian" to "酒場のごろつき",
        "Tireless Hauler" to "不屈の運び屋",
        "Tovolar, Dire Overlord" to "不吉な首領、トヴォラー",
        "Tovolar's Huntmaster" to "トヴォラーの猟匠",
        "Twinblade Geist" to "双刃の霊",
        "Ulvenwald Oddity" to "ウルヴェンワルドの奇異",
        "Vengeful Strangler" to "復讐に燃えた絞殺者",
        "Village Watch" to "村の見張り番",
        "Volatile Arsonist" to "移り気な放火魔",
        "Voldaren Bloodcaster" to "ヴォルダーレンの投血士",
        "Voltaic Visionary" to "通電の幻想家",
        "Weary Prisoner" to "困憊の在監者",
        "Weaver of Blossoms" to "花の織り手",
        "Wedding Announcement" to "婚礼の発表",
        "Wolfkin Outcast" to "狼族ののけ者")
}