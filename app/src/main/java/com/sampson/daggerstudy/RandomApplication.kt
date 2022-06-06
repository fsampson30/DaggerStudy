package com.sampson.daggerstudy

import android.app.Application

class RandomApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }
}