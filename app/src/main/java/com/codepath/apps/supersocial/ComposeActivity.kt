package com.codepath.apps.supersocial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class ComposeActivity : AppCompatActivity() {

    //lateinit var etCompose: EditText
    //lateinit var btnTweet: Button
    //lateinit var counter: TextView

    //lateinit var client: TwitterClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)

        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_post

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

        /*
        etCompose = findViewById(R.id.etTweetCompose)
        btnTweet = findViewById(R.id.btnTweet)
        counter = findViewById(R.id.counter)

        client = TwitterApplication.getRestClient(this)

        etCompose.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Fires right as the text is being changed (even supplies the range of text)
                counter.setText(Integer.toString(280 - etCompose.length()))
                if (etCompose.length() > 280) {
                    btnTweet.setEnabled(false)
                    counter.setTextColor(Color.RED)
                }
                else {
                    btnTweet.setEnabled(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Fires right before text is changing
            }

            override fun afterTextChanged(s: Editable) {
                // Fires right after the text has changed

            }
        })


        // Handling the user's click on the tweet button
        btnTweet.setOnClickListener {
            // Grab the content of edittext (etCompose)
            val tweetContent = etCompose.text.toString()

            // 1. Make sure the tweet isn't empty
            if (tweetContent.isEmpty()) {
                Toast.makeText(this, "Empty tweets not allowed!", Toast.LENGTH_SHORT).show()
            }

            // 2. Make sure the tweet is under character count
            else if (tweetContent.length > 280) {
                Toast.makeText(this, "Tweet is too long! Limit is 280 characters", Toast.LENGTH_SHORT).show()
            }

            else {
                client.publishTweet(tweetContent, object : JsonHttpResponseHandler() {
                    override fun onFailure(
                        statusCode: Int,
                        headers: Headers?,
                        response: String?,
                        throwable: Throwable?
                    ) {
                        Log.e(TAG, "Failed to publish tweet", throwable)
                    }

                    override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                        // Send the tweet back to TimelineActivity
                        val tweet = Tweet.fromJson(json.jsonObject)

                        val intent = Intent()
                        intent.putExtra("tweet", tweet)
                        setResult(RESULT_OK, intent)
                        finish()

                    }

                })
            }


        }

         */



    }
    companion object {
        val TAG = "ComposeActivity"
    }

}