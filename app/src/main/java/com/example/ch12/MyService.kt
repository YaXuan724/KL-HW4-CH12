package com.example.ch12

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*
import kotlinx.coroutines.delay as coroutinesDelay

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()

        val intent = Intent(this,SecActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        GlobalScope.launch(Dispatchers.Main){
            try {
                coroutinesDelay(3000)
                startActivity(intent)
            } catch (e: InterruptedException){
                e.printStackTrace()
            }
        }.start()
    }

    override fun onStartCommand(intent: Intent,flags: Int,startid: Int) : Int {
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? = null
}