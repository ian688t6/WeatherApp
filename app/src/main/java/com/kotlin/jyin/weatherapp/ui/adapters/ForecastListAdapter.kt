package com.kotlin.jyin.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.jyin.weatherapp.domain.model.ForecastList


class ForecastListAdapter(val weekForecast: ForecastList)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(TextView(parent.context))

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}