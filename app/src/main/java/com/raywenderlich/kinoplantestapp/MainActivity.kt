package com.raywenderlich.kinoplantestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.ReleaseInfoFragment
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.RepertoryFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

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
