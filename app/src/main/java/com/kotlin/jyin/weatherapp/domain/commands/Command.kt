package com.kotlin.jyin.weatherapp.domain.commands

/**
 * Created by jyin on 3/7/18.
 */
interface Command<out T> {
    fun execute(): T
}