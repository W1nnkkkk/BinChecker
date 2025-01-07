package com.w1nkkkk.binchecker

import android.app.Application
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.w1nkkkk.binchecker.domain.ConnectivityReceiver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter().apply {
            addAction(ConnectivityManager.CONNECTIVITY_ACTION)
            addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        }
        registerReceiver(ConnectivityReceiver(), intentFilter)
    }
}