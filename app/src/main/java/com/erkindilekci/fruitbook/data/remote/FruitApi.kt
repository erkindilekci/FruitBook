package com.erkindilekci.fruitbook.data.remote

import com.erkindilekci.fruitbook.domain.model.Fruit
import retrofit2.http.GET

interface FruitApi {
    @GET("erkindil/Json/main/fruit.json")
    suspend fun getFruits(): List<Fruit>
}