package com.kotlin.jyin.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by jyin on 3/6/18.
 */
class Request(private val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}