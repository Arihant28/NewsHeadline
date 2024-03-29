package com.work.asinghi.news.data.network

enum class Status {
    SUCCESS,
    ERROR,
    LOADING;

    fun isSuccessful() = this == SUCCESS
    fun isLoading() = this == LOADING
}