package com.codepath.apps.supersocial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.codepath.apps.supersocial.models.Tweet
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.Headers
import org.json.JSONException

class TimelineActivity : AppCompatActivity() {

    // TwitterClient variable
    lateinit var client: TwitterClient

    // Twitter RecyclerView
    lateinit var rvPosts: RecyclerView

    // Twitter Adapter
    lateinit var adapter: TweetsAdapter

    // Swipe container to refresh tweets
    lateinit var swipeContainer: SwipeRefreshLayout

    // List of tweets
    val tweets = ArrayList<Tweet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)


        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

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

        // initialize the client
        client = TwitterApplication.getRestClient(this)

        // getting the swipeContainer
        swipeContainer = findViewById(R.id.swipeContainer)

        // refreshes timeline
        swipeContainer.setOnRefreshListener {
            Log.i(TAG, "Refreshing timeline")
            populateHomeTimeline()
        }

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        // Initializes recyclerview and adapter
        rvPosts = findViewById(R.id.rvPosts)
        adapter = TweetsAdapter(tweets)

        // Sets the layoutManager and adapter
        rvPosts.layoutManager = LinearLayoutManager(this)
        rvPosts.adapter = adapter
        

        // populates the home timeline
        populateHomeTimeline()
    }



    // Handles when tweet comes back
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && resultCode == REQUEST_CODE) {
            // Get data from out tweet
            val tweet = data?.getParcelableExtra("tweet") as Tweet

            // Update timeline modifying source of tweets
            tweets.add(0, tweet)

            // Update adapter
            adapter.notifyItemInserted(0)
            rvPosts.smoothScrollToPosition(0)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    // populates the home timeline
    fun populateHomeTimeline() {
        client.getHomeTimeline(object: JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.i(TAG, "onFailure $statusCode")
            }

            // API call sucessfully made
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "onSuccess!")

                val jsonArray = json.jsonArray

                try {
                    // Clear out our currently fetched tweets
                    adapter.clear()
                    val listOfNewTweetsRetrieved = Tweet.fromJsonArray(jsonArray)
                    tweets.addAll(listOfNewTweetsRetrieved)
                    adapter.notifyDataSetChanged()
                    // Now we call setRefreshing(false) to signal refresh has finished
                    swipeContainer.setRefreshing(false)
                } catch(e: JSONException) {
                    Log.e(TAG, "JSON Exception $e")
                }
            }

        })
    }
    companion object {
        val TAG = "TimelineActivity"
        val REQUEST_CODE = 10
    }


}