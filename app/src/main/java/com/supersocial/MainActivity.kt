package com.supersocial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.supersocial.fragments.ComposeFragment
import com.supersocial.fragments.FeedFragment
import com.supersocial.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    lateinit var bottomNav : BottomNavigationView

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

        val fragmentManager : FragmentManager = supportFragmentManager

        val homeFragment = FeedFragment()
        val postFragment = ComposeFragment()
        val settingsFragment = SettingsFragment()

        bottomNav = findViewById(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener { it ->
            lateinit var fragment : Fragment
            when (it.itemId) {
                R.id.action_home -> {
                    fragment = homeFragment
                }

                R.id.action_post -> {
                    fragment = postFragment
                }

                R.id.action_settings -> {
                    fragment = settingsFragment
                }
            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
            // Return true to tell that we've handled this
            true
        }

    }

    override fun onStart() {
        super.onStart()

        val firebaseUser = firebaseAuth.getCurrentUser()
        if (firebaseUser != null) {
            Log.i(TAG, "there's user currently signed in")
        } else {
            Log.i(TAG, "nobody's signed in rn")
        }
    }

}