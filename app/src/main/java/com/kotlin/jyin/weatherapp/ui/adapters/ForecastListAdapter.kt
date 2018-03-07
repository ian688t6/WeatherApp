package com.kotlin.jyin.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.jyin.weatherapp.R
import com.kotlin.jyin.weatherapp.domain.model.Forecast
import com.kotlin.jyin.weatherapp.domain.model.ForecastList
import com.kotlin.jyin.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find


class ForecastListAdapter(private val weekForecast: ForecastList,
//                          private val itemClick: ForecastListAdapter.OnItemClickListener)
                            private val itemClick:(Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent,false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, private val itemClick: (Forecast) ->Unit) :RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                minTemperatureView.text = "${low}º"
                maxTemperatureView.text = "${high}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

//    interface OnItemClickListener {
//        operator fun invoke(forecast: Forecast)
//    }
}