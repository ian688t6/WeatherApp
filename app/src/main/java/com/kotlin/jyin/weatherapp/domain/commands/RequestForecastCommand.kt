package com.kotlin.jyin.weatherapp.domain.commands

import com.kotlin.jyin.weatherapp.data.ForecastRequest
import com.kotlin.jyin.weatherapp.domain.mappers.ForecastDataMapper
import com.kotlin.jyin.weatherapp.domain.model.ForecastList

/**
 * Created by jyin on 3/7/18.
 */

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
