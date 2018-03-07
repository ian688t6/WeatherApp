package com.kotlin.jyin.weatherapp.ui.activities

import com.kotlin.jyin.weatherapp.ui.adapters.ForecastListAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.jyin.weatherapp.R
import com.kotlin.jyin.weatherapp.data.Request
import com.kotlin.jyin.weatherapp.domain.commands.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

//    private val m_items = listOf(
//            "Mon 6/23 - Sunny - 31/17",
//            "Tue 6/24 - Foggy - 21/8",
//            "Wed 6/25 - Cloudy - 22/17",
//            "Thurs 6/26 - Rainy - 18/11",
//            "Fri 6/27 - Foggy - 21/10",
//            "Sat 6/28 - TAPPED IN WEATHERSTATION - 23/18",
//            "Sun 6/29 - Sunny - 20/7"
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
//        forecastList.adapter = ForecastListAdapter(m_items)

//        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
//                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

//        doAsync {
//            Request(url).run()
//            uiThread { longToast("Request performed") }
//        }

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }
}
