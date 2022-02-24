package com.supersocial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.supersocial.fragments.ComposeFragment
import com.supersocial.fragments.FeedFragment
import com.supersocial.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
                item ->

            var fragmentToShow: Fragment? = null
            when(item.itemId) {
                R.id.action_home -> {
                    // Navigate to the home screen
                    fragmentToShow = FeedFragment()
                }
                R.id.action_compose -> {
                    // Navigate to the Compose screen
                    fragmentToShow = ComposeFragment()
                }
                R.id.action_profile -> {
                    // Navigate to the Profile screen
                    fragmentToShow = SettingsFragment()
                }

            }
            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }

            // Return true to say that we've handled this user interaction on the item
            true
        }

        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_profile
    }
}