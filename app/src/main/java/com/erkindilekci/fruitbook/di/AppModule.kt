package com.erkindilekci.fruitbook.di

import com.erkindilekci.fruitbook.data.remote.FruitApi
import com.erkindilekci.fruitbook.data.repository.FruitRepositoryImpl
import com.erkindilekci.fruitbook.domain.repository.FruitRepository
import com.erkindilekci.fruitbook.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFruitApi(): FruitApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FruitApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: FruitApi): FruitRepository {
        return FruitRepositoryImpl(api)
    }
}