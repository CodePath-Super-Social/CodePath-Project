package com.codepath.apps.supersocial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.supersocial.models.Tweet
import android.text.format.DateUtils
import org.w3c.dom.Text
import java.text.ParseException
import java.text.SimpleDateFormat

import java.util.Locale
import android.util.Log







class TweetsAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    private val SECOND_MILLIS = 1000
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private val DAY_MILLIS = 24 * HOUR_MILLIS

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate our item layout
        val view = inflater.inflate(R.layout.item_tweet, parent, false)

        return ViewHolder(view)
    }

    // Populating data into the item through holder
    override fun onBindViewHolder(holder: TweetsAdapter.ViewHolder, position: Int) {
        // Get the data model based on the position
        val tweet: Tweet = tweets.get(position)

        // Set item views based on views and data model

        holder.tvTwtName.text = tweet.user?.name
        val username = "@" + tweet.user?.screenName
        holder.tvTwtUsername.text = username
        holder.tvTwtDescription.text = tweet.body
        holder.tvTwtTimestamp.text = getRelativeTimeAgo(tweet.createdAt)

        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).into(holder.ivTwtAvatar)
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    // Clean all elements of the recycler
    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    // Add a list of items
    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivTwtAvatar = itemView.findViewById<ImageView>(R.id.ivTwtAvatar)
        val tvTwtName = itemView.findViewById<TextView>(R.id.tvTwtName)
        val tvTwtUsername = itemView.findViewById<TextView>(R.id.tvTwtUsername)
        val tvTwtDescription = itemView.findViewById<TextView>(R.id.tvTwtDescription)
        val tvTwtTimestamp = itemView.findViewById<TextView>(R.id.tvTwtTimestamp)
    }

    fun getRelativeTimeAgo(rawJsonDate: String?): String? {
        val twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy"
        val sf = SimpleDateFormat(twitterFormat, Locale.ENGLISH)
        sf.isLenient = true
        try {
            val time = sf.parse(rawJsonDate).time
            val now = System.currentTimeMillis()
            val diff = now - time
            return if (diff < MINUTE_MILLIS) {
                "just now"
            } else if (diff < 2 * MINUTE_MILLIS) {
                "a minute ago"
            } else if (diff < 50 * MINUTE_MILLIS) {
                (diff / MINUTE_MILLIS).toString() + " m"
            } else if (diff < 90 * MINUTE_MILLIS) {
                "an hour ago"
            } else if (diff < 24 * HOUR_MILLIS) {
                (diff / HOUR_MILLIS).toString() + " h"
            } else if (diff < 48 * HOUR_MILLIS) {
                "yesterday"
            } else {
                (diff / DAY_MILLIS).toString() + " d"
            }
        } catch (e: ParseException) {
            //Log.i(TAG, "getRelativeTimeAgo failed")
            e.printStackTrace()
        }
        return ""
    }
}