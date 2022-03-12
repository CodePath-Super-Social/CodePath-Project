package com.supersocial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RedditLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reddit_login)

        Toast.makeText(this, "reddit logged in", Toast.LENGTH_LONG).show()
        // redirect to home page
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}