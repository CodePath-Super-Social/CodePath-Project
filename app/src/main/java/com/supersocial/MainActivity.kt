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

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

}