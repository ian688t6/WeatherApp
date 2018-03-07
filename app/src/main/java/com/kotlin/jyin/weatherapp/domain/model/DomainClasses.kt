package com.kotlin.jyin.weatherapp.domain.model

/**
 * Created by jyin on 3/7/18.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    fun size():Int = dailyForecast.size
    operator fun get(position: Int): Forecast = dailyForecast[position]
}
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
