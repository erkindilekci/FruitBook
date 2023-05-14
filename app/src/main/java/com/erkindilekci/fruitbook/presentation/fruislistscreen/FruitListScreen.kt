package com.erkindilekci.fruitbook.presentation.fruislistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.erkindilekci.fruitbook.presentation.fruislistscreen.components.FruitListItemCard
import com.erkindilekci.fruitbook.presentation.fruislistscreen.components.FruitListScreenTopAppBar
import com.erkindilekci.fruitbook.presentation.ui.theme.Background

@Composable
fun FruitListScreen(viewModel: FruitListViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            FruitListScreenTopAppBar()
        },
        content = {
            if (state.isError) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Background)
                        .padding(it),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Error! Please check internet connection.",
                        color = Color.White,
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(Background)
                ) {
                    item {
                        //SearchBar(modifier = Modifier.padding(vertical = 10.dp, horizontal = 7.dp).height(50.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    items(state.fruits) { fruit ->
                        FruitListItemCard(fruit = fruit)
                    }
                }
            }
        },
        bottomBar = {
            //MainBannerAdView()
        }
    )
}