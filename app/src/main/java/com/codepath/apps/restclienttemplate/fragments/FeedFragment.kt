package com.codepath.apps.restclienttemplate.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codepath.apps.restclienttemplate.LoginActivity
import com.codepath.apps.restclienttemplate.R
import com.codepath.apps.restclienttemplate.TimelineActivity

class FeedFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_timeline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val i = Intent(requireContext(), TimelineActivity::class.java)
        startActivity(i)
    }

}