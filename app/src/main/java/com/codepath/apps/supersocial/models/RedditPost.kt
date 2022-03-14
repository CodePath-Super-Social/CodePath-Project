package com.codepath.apps.supersocial.models

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import org.json.JSONArray
import org.json.JSONObject

@Parcelize
data class RedditPost(
    var id: Long = -1,
    var subreddit: String = "",
    var title: String = "",
    var body: String = "",
    var createdAt: String = "",
    var user: String = "",
    var karma: Int = 0,
    var url: String = ""
) : Parcelable {

    companion object {
        fun fromJson(jsonObject: JSONObject) : RedditPost {
            val redditPost = RedditPost()
            redditPost.id = jsonObject.getLong("id")
            redditPost.subreddit = jsonObject.getString("subreddit")
            redditPost.title = jsonObject.getString("title")
            redditPost.body = jsonObject.getString("selftext")
            redditPost.createdAt = jsonObject.getString("created")
            redditPost.user = jsonObject.getString("author")
            redditPost.karma = jsonObject.getInt("score")
            redditPost.url = jsonObject.getString("url")

            //
//            if (max_id == (-1).toLong() || tweet.id < max_id) {
//                max_id = tweet.id
//            }
            return redditPost
        }

        fun fromJsonArray(jsonArray: JSONArray) : List<RedditPost> {
            val redditPosts = ArrayList<RedditPost>()
            for (i in 0 until jsonArray.length()) {
                redditPosts.add(fromJson(jsonArray.getJSONObject(i)))
            }
            return redditPosts
        }
    }
}