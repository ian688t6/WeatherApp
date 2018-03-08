package com.kotlin.jyin.weatherapp.ui

import android.app.Application
import com.kotlin.jyin.weatherapp.ui.utils.DelegatesExt

/**
 * Created by jyin on 3/8/18.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}