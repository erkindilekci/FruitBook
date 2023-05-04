package com.erkindilekci.fruitbook.presentation.fruislistscreen.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.fruitbook.domain.model.Fruit
import com.erkindilekci.fruitbook.domain.model.Nutritions
import com.erkindilekci.fruitbook.presentation.ui.theme.Background
import com.erkindilekci.fruitbook.presentation.ui.theme.TopBar

@Composable
fun FruitListItemCard(fruit: Fruit) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(elevation = 4.dp, contentColor = Color.White, modifier = Modifier
        .padding(8.dp)
        .clip(RoundedCornerShape(15.dp))) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(TopBar)
            .padding(horizontal = 16.dp)
            .clickable { isExpanded = !isExpanded }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = fruit.name,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp
                )

                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(26.dp)
                )
            }
            
            if (isExpanded) {
                Spacer(modifier = Modifier.height(1.dp))
                
                Text(text = "Family: ${fruit.family}", fontSize = 20.sp, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Order: ${fruit.order}", fontSize = 20.sp, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Genus: ${fruit.genus}", fontSize = 20.sp, style = MaterialTheme.typography.h3)

                Spacer(modifier = Modifier.height(3.dp))

                Text(text = "Nutritions: (Per 100 g)", fontSize = 20.sp, style = MaterialTheme.typography.h3)

                Spacer(modifier = Modifier.height(1.dp))

                Text(text = "Calories: ${fruit.nutritions.calories}", fontSize = 20.sp, style = MaterialTheme.typography.h2)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Carbohydrates: ${fruit.nutritions.carbohydrates}", fontSize = 20.sp, style = MaterialTheme.typography.h2)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Fat: ${fruit.nutritions.fat}", fontSize = 20.sp, style = MaterialTheme.typography.h2)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Protein: ${fruit.nutritions.protein}", fontSize = 20.sp, style = MaterialTheme.typography.h2)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "Sugar: ${fruit.nutritions.sugar}", fontSize = 20.sp, style = MaterialTheme.typography.h2)

                Spacer(modifier = Modifier.height(7.dp))
            }
        }
    }
}
