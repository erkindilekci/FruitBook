package com.erkindilekci.fruitbook.data.repository

import com.erkindilekci.fruitbook.data.remote.FruitApi
import com.erkindilekci.fruitbook.domain.model.Fruit
import com.erkindilekci.fruitbook.domain.repository.FruitRepository
import javax.inject.Inject

class FruitRepositoryImpl @Inject constructor(
    private val api: FruitApi
) : FruitRepository {
    override suspend fun getFruits(): List<Fruit> {
        return api.getFruits()
    }
}