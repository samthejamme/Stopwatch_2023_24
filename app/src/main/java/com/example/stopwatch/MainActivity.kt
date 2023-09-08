package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var timer: Chronometer
    private var started: Boolean = false; private var paused: Boolean = false; private var stopped: Boolean = true
    companion object {
        // TAG is the default for naming logs
        val TAG = "MainActivity"
        // this is to test github pushing
        val ASTROPHYSICISTS_PI = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")
        startButton = findViewById(R.id.button_main_startbutton)
        stopButton = findViewById(R.id.button2_main_stopButton)
        timer = findViewById(R.id.chronometer_main_stopwatch)
        startButton.setOnClickListener() {
            timer.start()
            if(stopped)
            { // if it's BEEN stopped
                itsStarted()
                switchNames()
            }
            else if(paused) {
                // if it's BEEN paused
                itsStarted()
                switchNames()
            }
        }
        stopButton.setOnClickListener() {
            timer.stop()
            if(started) {
                // if it's BEEN started
                itsPaused()
                startButton.text = "Resume"
                stopButton.text = "Stop"
            }
            else if(paused) {
                // if it's BEEN paused
                itsStopped()
                startButton.text = "Start"
                stopButton.text = "Stop"
            }
        }
    }

    fun switchNames() {
        startButton.text = "Resume"
        stopButton.text = "Pause"
    }

    fun itsStarted() {
        started = true
        stopped = false
        paused = false
    }

    fun itsPaused() {
        started = false
        stopped = false
        paused = true
    }

    fun itsStopped() {
        started = false
        stopped = true
        paused = false
    }

    fun updateDisplay(stopTime: Int) {
        //get amt of time that has been paused, and subtract it from stopTime
    }






    override fun onStart() {
        super.onStart()
    }
    override fun onPause() {
        super.onPause()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onRestart() {
        super.onRestart()
    }
    override fun onResume() {
        super.onResume()
    }
    override fun onStop() {
        super.onStop()
    }
}
