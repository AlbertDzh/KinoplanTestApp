package com.raywenderlich.kinoplantestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.kinoplantestapp.model.network.services.getMockRepertory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var logTag = "test"
        Log.v(logTag, getMockRepertory().toString())
    }
}