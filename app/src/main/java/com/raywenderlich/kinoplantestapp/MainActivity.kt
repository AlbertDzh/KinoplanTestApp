package com.raywenderlich.kinoplantestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.model.ReleaseScreenItems
import com.raywenderlich.kinoplantestapp.model.RepertoryItem
import com.raywenderlich.kinoplantestapp.model.getMockRepertory
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.RepertoryFragment
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var adapter: ParentRepertoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.repertoryMainFragment, RepertoryFragment())
            .commit()
    }
}
