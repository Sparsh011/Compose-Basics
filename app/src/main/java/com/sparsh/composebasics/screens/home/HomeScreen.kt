package com.sparsh.composebasics.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sparsh.composebasics.screens.profile.ProfileScreen
import kotlin.io.path.Path

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var text1 by remember {
        mutableStateOf(TextFieldValue(""))
    }

    val context = LocalContext.current

    var showBottomSheet by rememberSaveable {
        mutableStateOf(false)
    }

    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }

//    LaunchedEffect(key1 = Unit) {
//        showDialog = true
//    }

    SideEffect {
        Log.d("SideEffectTag", "SideEffect called")
    }

    if (showDialog) {
        BasicAlertDialog(onDismissRequest = {
            showDialog = false
        }) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(15.dp)
            ) {
                Text(
                    text = "This is heading",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black
                )
                Text(
                    text = "This is the body body body body body body body bodyb body \n This is the body body body body body body body bodyb body \n This is the body body body body body body body bodyb body \n This is the body body body body body body body bodyb body ",
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    color = Color.Black
                )
            }
        }
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
                contentDescription = "build icon 1",
            )
        }

        Row {
            Text("This is text 1")
            Text("This is text 2 on the right")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast.makeText(context, "Showing toast", Toast.LENGTH_SHORT).show()
                },
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(200.dp)) {
                drawCircle(Color.Blue)
            }

            Text(
                text = "Show toast",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                modifier = Modifier
                    .background
                        (Color.Green)

            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showBottomSheet = true
                },
            contentAlignment = Alignment.Center

        ) {
            Canvas(modifier = Modifier.size(100.dp)) {
                drawRect(Color.Red)
            }
        }

        val sheetState = rememberModalBottomSheetState()

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                containerColor = Color.Transparent,
                dragHandle = null
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        null,
                        tint = Color.Red,
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .clickable {
                                showBottomSheet = false
                            }
                            .background(Color.Gray)
                            .padding(10.dp)
                    )
                }

                Spacer(Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                        .background(Color.Gray)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        "This is text in bottom sheet",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        fontSize = 23.sp
                    )

                    for (i in 0..100) {
                        Text(
                            "Item: $i",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}