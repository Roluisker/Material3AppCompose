package com.example.material3appcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage


@Composable
fun FavoritesScreen() {

    val image1 =
        "https://images.unsplash.com/photo-1561037404-61cd46aa615b?q=80&w=1740&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image2 =
        "https://images.unsplash.com/photo-1561037404-61cd46aa615b?q=80&w=1740&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    val image3 =
        "https://images.unsplash.com/photo-1561037404-61cd46aa615b?q=80&w=1740&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    var dogList = remember {
        mutableStateListOf(
            Dog(
                name = "Perry",
                image = image1
            ),
            Dog(
                name = "Perry",
                image = image2
            ),
            Dog(
                name = "Perry",
                image = image3
            ),
            Dog(
                name = "Perry",
                image = image1
            ),
            Dog(
                name = "Perry",
                image = image2
            ),
            Dog(
                name = "Perry",
                image = image3
            ),
            Dog(
                name = "Perry",
                image = image2
            ),
            Dog(
                name = "Perry",
                image = image1
            )
        )
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        content = {
            itemsIndexed(dogList) { index, dog ->
                Card(
                    modifier = Modifier.size(200.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(
                                    alpha = 0.6f
                                ),
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            ),
                            modifier = Modifier
                                .zIndex(1f)
                                .align(Alignment.TopEnd),
                            //.background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)),
                            onClick = {
                                dogList.removeAt(index)
                                dogList.add(index, dog.copy(isFavorite = !dog.isFavorite))
                            }) {
                            Icon(
                                imageVector = if (dog.isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                                contentDescription = null
                            )
                        }
                        AsyncImage(
                            model = dog.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f))
                        ) {
                            Text(
                                text = dog.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .zIndex(1f)
                                    .align(Alignment.CenterStart)
                            )
                        }


                    }
                }
            }
        })

    /*
        LazyColumn {
            items(dogList) { dog ->
                Card(
                    modifier = Modifier.size(200.dp)
                        .wrapContentSize(unbounded = true),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AsyncImage(
                            model = dog.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }*/
}

data class Dog(
    val name: String,
    val image: String,
    val isFavorite: Boolean = false
)