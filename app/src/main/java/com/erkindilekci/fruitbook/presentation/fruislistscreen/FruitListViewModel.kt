package com.erkindilekci.fruitbook.presentation.fruislistscreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.fruitbook.domain.model.Fruit
import com.erkindilekci.fruitbook.domain.repository.FruitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitListViewModel @Inject constructor(
    private val repository: FruitRepository
) : ViewModel() {
    private val _state = mutableStateOf(FruitListState())
    val state: State<FruitListState> = _state

    val searchedList: List<Fruit> = emptyList()

    init {
        getFruits()
    }

    private fun getFruits() {
        viewModelScope.launch(Dispatchers.Default) {
            val fruits = repository.getFruits()
            _state.value = FruitListState(fruits = fruits)
        }
    }
}