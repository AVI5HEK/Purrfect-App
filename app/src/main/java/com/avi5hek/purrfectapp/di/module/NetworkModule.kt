package com.avi5hek.purrfectapp.di.module

import com.avi5hek.purrfectapp.util.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by "Avishek" on 8/19/2019.
 */
@Module
class NetworkModule {

  companion object {
    const val HEADER_AUTHORIZATION = "x-api-key"
    const val HEADER_CONTENT_TYPE = "Content-Type"
    const val HEADER_CONTENT_TYPE_VALUE = "application/json"
    const val CONNECT_TIMEOUT: Long = 60
    const val READ_TIMEOUT: Long = 60
    const val WRITE_TIMEOUT: Long = 60
  }

  @Provides
  fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
  }

  @Provides
  fun provideInterceptor(): Interceptor {
    return Interceptor { chain ->
      val original = chain.request()
      val requestBuilder = original.newBuilder()
      requestBuilder.header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE)
      requestBuilder.header(HEADER_AUTHORIZATION, "b9dba2a3-5001-44d5-8013-a87eca50abc7")
      val request = requestBuilder.build()
      chain.proceed(request)
    }
  }

  @Provides
  fun provideOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    interceptor: Interceptor
  ): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(httpLoggingInterceptor)
    httpClient.addInterceptor(interceptor)
    httpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
    httpClient.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
    httpClient.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
    return httpClient.build()
  }

  @Singleton
  @Provides
  fun provideRetrofit(httpClient: OkHttpClient, schedulerProvider: SchedulerProvider): Retrofit {

    return Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(
        RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.io())
      )
      .client(httpClient)
      .build()
  }
}
