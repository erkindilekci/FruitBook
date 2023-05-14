package com.erkindilekci.fruitbook.presentation.fruislistscreen

import com.erkindilekci.fruitbook.domain.model.Fruit

data class FruitListState(
    val fruits: List<Fruit> = emptyList(),
    val fruitNames: List<String> = emptyList(),
    var isError: Boolean = false,
    var isLoading: Boolean = true
)
