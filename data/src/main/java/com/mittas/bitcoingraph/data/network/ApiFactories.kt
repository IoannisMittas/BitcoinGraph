package com.mittas.bitcoingraph.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactories {

    fun <T> createApi(baseUrl: String, api: Class<T>): T {
        return createRetrofitApi(baseUrl, api)
    }

    private fun <T> createRetrofitApi(baseUrl: String, api: Class<T>): T {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(createGson()))
            .baseUrl(baseUrl)
            .build()
            .create(api)
    }

    private fun createGson(): Gson {
        return GsonBuilder().create()
    }
}