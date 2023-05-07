package com.example.mymenu

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import java.net.URLEncoder


class DeeplTranslatorActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text: String = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT) ?: ""
        val encodedText = URLEncoder.encode(text, "UTF-8").replace("+", "%20")
        val baseUrl = "https://www.deepl.com/translator#en/ja/"

        val url = baseUrl + encodedText

        openDefaultBrowser(url)

    }

    private fun openDefaultBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(intent)
    }
}
