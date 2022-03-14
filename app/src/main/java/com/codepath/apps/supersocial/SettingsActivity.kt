package com.codepath.apps.supersocial

import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.codepath.apps.supersocial.fragments.FeedFragment
import com.codepath.apps.supersocial.models.SampleModel
import com.codepath.apps.supersocial.models.SampleModelDao
import com.codepath.oauth.OAuthLoginActionBarActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsActivity : OAuthLoginActionBarActivity<TwitterClient>() {

    var sampleModelDao: SampleModelDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_settings

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
                item ->

            when(item.itemId) {
                R.id.action_home -> {
                    // Navigate to the home screen
                    startActivity(Intent(this, TimelineActivity::class.java))
                }
                R.id.action_post -> {
                    // Navigate to the Compose screen
                    startActivity(Intent(this, ComposeActivity::class.java))
                }
                R.id.action_settings -> {
                    // Navigate to the Profile screen
                    startActivity(Intent(this, SettingsActivity::class.java))
                }

            }

            // Return true to say that we've handled this user interaction on the item
            true
        }

        // Does the login
        val sampleModel = SampleModel()
        sampleModel.name = "CodePath"
        sampleModelDao = (applicationContext as TwitterApplication).myDatabase?.sampleModelDao()
        AsyncTask.execute { sampleModelDao?.insertModel(sampleModel) }

        findViewById<Button>(R.id.btnRedditLogin).setOnClickListener {
            val CLIENT_ID = "I-OVFMnKBAf0hT7lauH-aQ";

            val REDIRECT_URI =
                "http://localhost:8080";

            val STATE = "MY_RANDOM_STRING_1";

            val AUTH_URL = "https://www.reddit.com/api/v1/authorize.compact?client_id=$CLIENT_ID" +
                    "&response_type=code&state=$STATE&redirect_uri=$REDIRECT_URI&" +
                    "duration=permanent&scope=identity";

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(AUTH_URL))
            startActivity(intent)
        }

    }


    // Inflate the menu; this adds items to the action bar if it is present.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login, menu)
        return true
    }

    // OAuth authenticated successfully, launch primary authenticated activity
    // i.e Display application "homepage"
    override fun onLoginSuccess() {

        Log.i("Yaseen", "Logged in successfully!")

        Toast.makeText(this, "twitter logged in", Toast.LENGTH_LONG).show()

        // launch the activity
        val i = Intent(this, FeedFragment::class.java)
        startActivity(i)
    }

    // OAuth authentication flow failed, handle the error
    // i.e Display an error dialog or toast
    override fun onLoginFailure(e: Exception) {
        Log.i("Yaseen", "Login failed")
        e.printStackTrace()
    }

    // Click handler method for the button used to start OAuth flow
    // Uses the client to initiate OAuth authorization
    // This should be tied to a button used to login
    fun loginToRest(view: View?) {
        client.connect()
    }
}