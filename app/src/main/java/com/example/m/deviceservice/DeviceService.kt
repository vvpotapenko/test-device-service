package com.example.m.deviceservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class DeviceService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    private val binder: IDeviceService.Stub by lazy {
        object : IDeviceService.Stub() {
            override fun getVersion(): String {
                return try {
                    val pInfo = packageManager.getPackageInfo(packageName, 0)
                    pInfo.versionName
                } catch (e: Exception) {
                    e.printStackTrace()
                    "Error on getting version info"
                }
            }
        }
    }

}