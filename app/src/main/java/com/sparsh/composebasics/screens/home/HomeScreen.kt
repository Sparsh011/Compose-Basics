package com.sparsh.composebasics.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    var text1 by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Column {
        OutlinedTextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            modifier = Modifier
                .padding(10.dp),
            label = {
                Text("Enter value")
            }
        )

        Text(
            "This is my heading for Home Screen", fontSize = 25.sp, modifier = Modifier
                .padding(10.dp)
                .background(Color.Red)
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Row {
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "build icon 1",
            )

            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "build icon 1"
            )
        }

        Row {
            Text("This is text 1")
            Text("This is text 2 on the right")
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(200.dp)) {
                drawCircle(Color.Blue)
            }

            Text(
                text = "Add",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                modifier = Modifier
                    .background
                        (Color.Green)

            )
        }
    }
}