package com.ecs.hellobart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ecs.hellobart.api.BARTService
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TrainCountViewModel: ViewModel() {

    private val lazyService: BARTService by lazy {
        getRetrofit().create(BARTService::class.java)
    }

    val trainCount = liveData(Dispatchers.IO) {
        emit(getBARTService().getTrainCount())
    }

    val stations = liveData(Dispatchers.IO) {
        emit(getBARTService().getStations())
    }

    // Put this in dependency injection later pls
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.call().request()
            val httpUrl = request.url.newBuilder()
                .addQueryParameter("key", BuildConfig.ApiKey)
                .addQueryParameter("json", "y").build()
            val newRequest = request.newBuilder().url(httpUrl).build()
            chain.proceed(newRequest)
        }.build()
    }

    fun getRetrofit(): Retrofit {
        val moshiFactory = MoshiConverterFactory.create(getMoshi())
        // put baseURL in gradle config pls
        return Retrofit.Builder().baseUrl("https://api.bart.gov/api/")
            .addConverterFactory(moshiFactory)
            .client(getHttpClient()).build()
    }

    private fun getMoshi() = Moshi.Builder().build()

    fun getBARTService(): BARTService {
        return lazyService
    }
}