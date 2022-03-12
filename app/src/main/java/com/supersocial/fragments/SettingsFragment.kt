package com.supersocial.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.supersocial.MainActivity
import com.supersocial.R
import com.supersocial.TwitterLoginActivity


private const val TAG = "Settings Segment"

class SettingsFragment : Fragment() {

    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        view.findViewById<Button>(R.id.btnTwitterLogin).setOnClickListener {
            val intent = Intent(activity, TwitterLoginActivity::class.java)
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.btnTwitterLogout).setOnClickListener {
            firebaseAuth.signOut()

            // go back to main activity
            val i = Intent(activity, MainActivity::class.java)
            startActivity(i)

            Toast.makeText(activity, "twitter logged out", Toast.LENGTH_LONG).show()
        }

        view.findViewById<Button>(R.id.btnRedditLogin).setOnClickListener {
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
}