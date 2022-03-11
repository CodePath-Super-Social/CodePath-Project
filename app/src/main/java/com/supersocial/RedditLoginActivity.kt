package com.supersocial

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class RedditLoginActivity : AppCompatActivity() {
    private val AUTH_URL = "https://www.reddit.com/api/v1/authorize.compact?client_id=%s" +
    "&response_type=code&state=%s&redirect_uri=%s&" +
    "duration=permanent&scope=identity";

    private val CLIENT_ID = "ABCDEFGHIJKLM012345-AA";

    private val REDIRECT_URI =
    "http://www.example.com/my_redirect";

    private val STATE = "MY_RANDOM_STRING_1";

    private val ACCESS_TOKEN_URL = "https://www.reddit.com/api/v1/access_token";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun startSignIn(view: View?): Unit {
        val url = String.format(AUTH_URL, CLIENT_ID, STATE, REDIRECT_URI)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}