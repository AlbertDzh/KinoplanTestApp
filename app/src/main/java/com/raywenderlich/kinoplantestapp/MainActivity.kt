package com.raywenderlich.kinoplantestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.model.RepertoryItem
import com.raywenderlich.kinoplantestapp.model.getMockRepertory
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: ParentRepertoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repertory = getMockRepertory()
        val repertoryItems = listOf(
            RepertoryItem("Now", repertory.now),
            RepertoryItem("Premiere", repertory.premiere),
            RepertoryItem("Kids", repertory.kids),
            RepertoryItem("Soon", repertory.soon)
        )

        var recyclerView: RecyclerView = findViewById(R.id.repertoireParentView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ParentRepertoryAdapter(repertoryItems)
        recyclerView.adapter = adapter
    }
}