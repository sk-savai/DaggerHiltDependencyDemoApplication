package com.example.daggerhiltdependencydemoapplication.network



import android.net.Uri
import android.util.Log
import com.example.daggerhiltdependencydemoapplication.constant.Constant
import com.example.daggerhiltdependencydemoapplication.network.Client.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit


@Module
@InstallIn(ViewModelComponent::class)
class ApiData {

    @Provides
    fun retrofitObject(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClientBuilder())
            .build()
            .create(ApiInterface::class.java)
    }

    private fun getOkHttpClientBuilder(): OkHttpClient {
        val mHttpLoggingInterceptor =
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient=OkHttpClient.Builder().apply {
            addInterceptor(mHttpLoggingInterceptor)
                .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
                .protocols(listOf(Protocol.HTTP_1_1))
            connectTimeout(50000, TimeUnit.SECONDS)
            writeTimeout(1000, TimeUnit.SECONDS)
            readTimeout(1000, TimeUnit.SECONDS)

        }.build()

        return mOkHttpClient
    }


}