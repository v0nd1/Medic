package com.huggydugy.medic

import android.app.Application
import com.google.firebase.FirebaseApp

class MedicApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}