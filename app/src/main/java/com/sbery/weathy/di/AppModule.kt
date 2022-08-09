package com.sbery.weathy.di

import android.content.Context
import androidx.room.Room
import com.sbery.weathy.app.db.LocationWeatherDatabase
import com.sbery.weathy.data.db.LocationWeatherDao
import com.sbery.weathy.data.retrofit.WeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApiService(): WeatherApiService =
        Retrofit.Builder()
            .baseUrl(WeatherApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)

    @Provides
    @Singleton
    fun provideLocationWeatherDatabase(@ApplicationContext appContext: Context): LocationWeatherDatabase =
        Room.databaseBuilder(
            appContext,
            LocationWeatherDatabase::class.java,
            "weathy-location-weather-db"
        )
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideLocationWeatherDao(db: LocationWeatherDatabase): LocationWeatherDao =
        db.provideLocationWeatherDao()
}