package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import kotlin.math.abs

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
        val IS_STATE_RUNNING = ""
        val IS_STATE_PAUSED = ""
        val IS_STATE_STOOPED = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")

        startButton = findViewById(R.id.button_main_startbutton)
        stopButton = findViewById(R.id.button2_main_stopButton)
//        timer = findViewById(R.id.chronometer_main_stopwatch)

        wireWidgets()

        // restore saveInstanceState if it exists
        if(savedInstanceState != null) {
            displayTime = savedInstanceState.getLong(STATE_DISPLAY_TIME)
            started = savedInstanceState.getBoolean(IS_STATE_RUNNING)
            timer.base = SystemClock.elapsedRealtime() - displayTime
            timer.start()

            started = true; stopped = false; paused = false
        }

        startButton.setOnClickListener() {
            timer.start()
            timer.base = SystemClock.elapsedRealtime() + stoppedTime
            if(stopped)
            { // if it's BEEN stopped
                itsStarted()
                startButton.text = "Resume"
                stopButton.text = "Pause" // include this when it gets started again from rotating
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
            stoppedTime = timer.base - SystemClock.elapsedRealtime()
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
                timer.base = SystemClock.elapsedRealtime()
            }
        }
    }

    private fun wireWidgets() {
        timer = findViewById(R.id.chronometer_main_stopwatch)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // calculate the display time if currently running
        if(started) {
            displayTime = timer.base - SystemClock.elapsedRealtime()
        }
        // save key-value pairs to the bundle before the superclass call
        outState.putLong(STATE_DISPLAY_TIME, displayTime)
        outState.putBoolean(IS_STATE_RUNNING, started)
        outState.putBoolean(IS_STATE_PAUSED, paused)
        outState.putBoolean(IS_STATE_STOOPED, stopped)

        super.onSaveInstanceState(outState)
    }


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
