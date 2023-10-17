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
    private var stoppedTime: Long = 0
    companion object {
        // TAG is the default for naming logs
        val TAG = "MainActivity"

        // make constants for you key-value pairs
        val STATE_DISPLAY_TIME = "actual time"
        val IS_STATE_RUNNING = "it's running"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: this is a log")

        startButton = findViewById(R.id.button_main_startbutton)
        stopButton = findViewById(R.id.button2_main_stopButton)

        wireWidgets()

        // restore saveInstanceState if it exists
        if(savedInstanceState != null) {
            stoppedTime = savedInstanceState.getLong(STATE_DISPLAY_TIME)
            started = savedInstanceState.getBoolean(IS_STATE_RUNNING)
            timer.base = SystemClock.elapsedRealtime() - stoppedTime
            if(started) {
                timer.start()
            }
        }

        startButton.setOnClickListener() {
            if(!started)
            { // if it's BEEN stopped
                timer.start()
                timer.base = SystemClock.elapsedRealtime() - stoppedTime
                started = true
                startButton.text = "Resume"
                stopButton.text = "Pause"
            }
        }

        stopButton.setOnClickListener() {
            if(started) {
                timer.stop()
                // if it's BEEN started
                started = false
                stoppedTime = SystemClock.elapsedRealtime() - timer.base
                startButton.text = "Resume"
                stopButton.text = "Stop"
            }
            else {
                reset()
            }
        }
    }

    private fun reset() {
        started = false
        startButton.text = "Start"
        stopButton.text = "Stop"
        timer.base = SystemClock.elapsedRealtime()
        stoppedTime = 0
    }

    private fun wireWidgets() {
        timer = findViewById(R.id.chronometer_main_stopwatch)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // calculate the display time if currently running
        if(started) {
            stoppedTime = SystemClock.elapsedRealtime() - timer.base
        }
        // save key-value pairs to the bundle before the superclass call
        savedInstanceState.putLong(STATE_DISPLAY_TIME, stoppedTime)
        savedInstanceState.putBoolean(IS_STATE_RUNNING, started)
//        savedInstanceState.putBoolean(IS_STATE_PAUSED, paused)
//        savedInstanceState.putBoolean(IS_STATE_STOOPED, stopped)

        super.onSaveInstanceState(savedInstanceState)
    }


    // for future reference Integer.parseInt(timer.text.toString())



//
//    fun itsStarted() {
//        started = true
//        stopped = false
//        paused = false
//    }
//
//    fun itsPaused() {
//        started = false
//        stopped = false
//        paused = true
//    }
//
//    fun itsStopped() {
//         started = false
//        stopped = true
//        paused = false
//    }




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
