package com.sparsh.composebasics.screens.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen() {
    val list = mutableListOf<Int>()
    (0..100).forEach {
        list.add(it)
    }

    val lazyColumnState = rememberLazyListState()

    val showScrollToTopButton by remember {
        derivedStateOf { lazyColumnState.firstVisibleItemIndex > 0 }
    }

//    var showScrollToTopButton by remember {
//        mutableStateOf(false)
//    }

//    LaunchedEffect(lazyColumnState.firstVisibleItemIndex) {
//        showScrollToTopButton = lazyColumnState.firstVisibleItemIndex > 0
//    }

    val coroutineScope = rememberCoroutineScope()


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = lazyColumnState
        ) {
            stickyHeader {
                Text(
                    "Profile Screen",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }

            items(list) {
                Text("Item: $it", modifier = Modifier.padding(10.dp))
            }

            item {
                Canvas(modifier = Modifier.size(200.dp)) {
                    drawCircle(
                        brush = Brush.sweepGradient(
                            listOf(
                                Color.DarkGray,
                                Color.Gray,
                                Color.LightGray
                            )
                        )
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = showScrollToTopButton,
            enter = fadeIn() + slideInVertically { it / 2 },
            exit = fadeOut() + slideOutVertically { it / 2 }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .clickable {
                        coroutineScope.launch {
                            lazyColumnState.animateScrollToItem(0)
                        }
                    }
                    .padding(bottom = 20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Gray)
                    .padding(10.dp)
            )
        }
    }
}