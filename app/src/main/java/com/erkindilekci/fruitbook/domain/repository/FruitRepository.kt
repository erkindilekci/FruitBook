package com.erkindilekci.fruitbook.domain.repository

import com.erkindilekci.fruitbook.domain.model.Fruit

interface FruitRepository {
    suspend fun getFruits(): List<Fruit>
}