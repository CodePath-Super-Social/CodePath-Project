package com.supersocial.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.supersocial.MainActivity
import com.supersocial.R
import com.supersocial.LoginActivity


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
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.btnTwitterLogout).setOnClickListener {
            firebaseAuth.signOut()

            // go back to main activity
            val i = Intent(activity, MainActivity::class.java)
            startActivity(i)

            Toast.makeText(activity, "logged out", Toast.LENGTH_LONG).show()
        }
    }
}