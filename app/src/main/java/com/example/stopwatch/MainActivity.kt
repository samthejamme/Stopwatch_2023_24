package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var timer: Chronometer
    private var started: Boolean = false; private var paused: Boolean = false; private var stopped: Boolean = true
    private var displayTime: Long = 0; private var stoppedTime: Long = 0
    companion object {
        // TAG is the default for naming logs
        val TAG = "MainActivity"
        // this is to test github pushing
        val ASTROPHYSICISTS_PI = 3

        // make constants for you key-value pairs
        val STATE_DISPLAY_TIME = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")

        //wireWidgets()

        // restore saveInstanceState if it exists
        if(savedInstanceState != null) {
            displayTime = savedInstanceState.getLong(STATE_DISPLAY_TIME)
            timer.base = Math.abs(SystemClock.elapsedRealtime())
        }

        startButton = findViewById(R.id.button_main_startbutton)
        stopButton = findViewById(R.id.button2_main_stopButton)
        timer = findViewById(R.id.chronometer_main_stopwatch)
        startButton.setOnClickListener() {
            timer.start()
            timer.base = displayTime
            if(stopped)
            { // if it's BEEN stopped
                itsStarted()
                startButton.text = "Resume"
                stopButton.text = "Pause"
            }
            else if(paused) {
                // if it's BEEN paused
                itsStarted()
                startButton.text = "Resume"
                stopButton.text = "Pause"
            }
        }

        stopButton.setOnClickListener() {
            timer.stop()
            stoppedTime = SystemClock.elapsedRealtime()
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

//    override fun onSaveInstanceState(outState: Bundle?) {
//        if(started) {
//            displayTime = SystemClock.elapsedRealtime() - timer.base
//        }
//        // if it weren't running, you would have saved the displaytime in the stop button's onclick listener
//
//        // save key-value pairs to the bundle before the superclass call
//        outState?.putLong(STATE_DISPLAY_TIME, displayTime)
//        if (outState != null) {
//            super.onSaveInstanceState(outState)
//        }
//    }

    // for future reference Integer.parseInt(timer.text.toString())







    // switching the booleans
    fun switchNames() {

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
