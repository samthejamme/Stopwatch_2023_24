package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
        val ASTROPHYSICISTS_PI = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")
    }

    override fun onStart() {
        super.onStart()
    }
}