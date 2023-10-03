package com.raywenderlich.kinoplantestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.RepertoryFragment
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter

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
