package com.supersocial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.supersocial.R
import com.supersocial.TweetsAdapter
import com.supersocial.TwitterApplication
import com.supersocial.TwitterClient
import com.supersocial.models.Tweet
import okhttp3.Headers
import org.json.JSONException


class FeedFragment : Fragment() {

    // TweetClient for Twitter
   // lateinit var TweetClient: TwitterClient

    // rvPosts for the Recyclerview
   // lateinit var rvPosts: RecyclerView

    // TwitterAdapter to populate recyclerview
   // lateinit var TwitterAdapter: TweetsAdapter

    // Holds all the tweets displayed
   // val allTweets = ArrayList<Tweet>()

    // Used to refresh tweets
    //lateinit var swipeContainer: SwipeRefreshLayout

    // Inflates the fragment feed layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.empty_feed, container, false)
    }

    /*
    // Used to populate timeline
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize the Twitter client
        TweetClient = TwitterApplication.getRestClient(requireContext())

        // References rvPosts
        rvPosts = view.findViewById(R.id.rvPosts)

        // set adapter on RecyclerView
        TwitterAdapter = TweetsAdapter(allTweets)
        rvPosts.adapter = TwitterAdapter

        // set layout manager on Recyclerview
        rvPosts.layoutManager = LinearLayoutManager(requireContext())

        // references swipeContainer
        swipeContainer = view.findViewById(R.id.swipeContainer)

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light)

        // Shown when posts are being refreshed
        swipeContainer.setOnRefreshListener {
            populateHomeTimeline()
        }

        // populates the home timeline
        populateHomeTimeline()
    }


    // populates the home timeline
    fun populateHomeTimeline() {
        TweetClient.getHomeTimeline(object: JsonHttpResponseHandler() {
            // Fails to get tweets. Displays a toast to user
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Toast.makeText(requireContext(), "Could not retrieve tweets", Toast.LENGTH_SHORT).show()
            }

            // Tweets are able to be received
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                val jsonArray = json.jsonArray

                try {
                    // Clear out our currently fetched tweets
                    TwitterAdapter.clear()
                    val listOfNewTweetsRetrieved = Tweet.fromJsonArray(jsonArray)
                    allTweets.addAll(listOfNewTweetsRetrieved)
                    TwitterAdapter.notifyDataSetChanged()

                    // Now we call setRefreshing(false) to signal refresh has finished
                    swipeContainer.setRefreshing(false)
                } catch(e: JSONException) {
                    Toast.makeText(requireContext(), "Could not retrieve tweets", Toast.LENGTH_SHORT).show()
                }
            }

        })


}
     */
}