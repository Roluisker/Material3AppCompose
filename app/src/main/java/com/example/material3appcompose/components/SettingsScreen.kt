package com.example.material3appcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    var userName by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(20.dp)
    ) {
        Text(text = "Your user name is: $userName")
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            label = {
                Text(text = "Add your name here")
            },
            placeholder = {
                Text(text = "User name")
            },
            value = userName,
            onValueChange = { newValue ->
                userName = newValue
            },
            isError = userName.isEmpty()
        )
    }

}