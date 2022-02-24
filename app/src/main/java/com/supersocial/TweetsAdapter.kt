package com.supersocial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.text.format.DateUtils
import com.supersocial.models.Tweet
import java.text.ParseException
import java.text.SimpleDateFormat

import java.util.Locale




class TweetsAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

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
        val tvTwtDescription = itemView.findViewById<TextView>(R.id.tvTwtDescription)
        val tvTwtTimestamp = itemView.findViewById<TextView>(R.id.tvTwtTimestamp)
    }

    fun getRelativeTimeAgo(rawJsonDate: String): String {
        val twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy"
        val sf = SimpleDateFormat(twitterFormat, Locale.ENGLISH)
        sf.setLenient(true)
        var relativeDate = ""
        try {
            val dateMillis: Long = sf.parse(rawJsonDate).getTime()
            relativeDate = DateUtils.getRelativeTimeSpanString(
                dateMillis,
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS
            ).toString()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return relativeDate
    }
}