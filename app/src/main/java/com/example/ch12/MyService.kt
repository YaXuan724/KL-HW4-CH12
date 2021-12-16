package com.example.ch12

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*
import kotlinx.coroutines.delay as coroutinesDelay

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        val intent = Intent(this, SecActivity::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            kotlinx.coroutines.delay(3000)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        return START_NOT_STICKY  //Service終止後不再做
    }

    override fun onBind(intent: Intent): IBinder? = null
}