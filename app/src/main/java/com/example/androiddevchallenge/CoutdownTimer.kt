/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun CountdownTimer() {

    val countDownTime by remember { mutableStateOf(20) }
    var remaining by remember { mutableStateOf(20) }
    var isRunning by remember { mutableStateOf(false) }
    val remainingFormatted = "%d".format(remaining)
    val targetValue = (remaining.toFloat() / countDownTime)
    val progress by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    MaterialTheme {
        val typography = MaterialTheme.typography
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 3.dp,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            backgroundColor = Color(0xFF111111)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    " ... Countdown Timer",
                    style = typography.h3,
                    color = Color(0xFFB2FF59),
                    fontFamily = FontFamily.Cursive

                )
                Spacer(Modifier.height(50.dp))
                Box(modifier = Modifier.aspectRatio(1f), contentAlignment = Alignment.Center) {

                    CircularProgressIndicator(
                        color = Color(0xFFE65100),
                        strokeWidth = 20.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFEF6C00),
                        strokeWidth = 18.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFF57C00),
                        strokeWidth = 16.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFB8C00),
                        strokeWidth = 14.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFF9800),
                        strokeWidth = 12.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFFA726),
                        strokeWidth = 10.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFFB74D),
                        strokeWidth = 8.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFFCC80),
                        strokeWidth = 6.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFFE0B2),
                        strokeWidth = 4.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    CircularProgressIndicator(
                        color = Color(0xFFFFF3E0),
                        strokeWidth = 2.dp,
                        progress = progress,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row {
                            Text(
                                text = remainingFormatted, style = typography.h1,
                                color = Color(0xFFF4511E),
                                fontFamily = FontFamily.Cursive
                            )
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(48.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(40.dp)
                    )
                    Card(
                        shape = CircleShape,
                        elevation = 3.dp,
                        backgroundColor = Color(0xFF4CAF50),
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    if (!isRunning) {
                                        if (remaining > 0) {
                                            isRunning = true
                                        }
                                    }
                                }
                            ),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_play_arrow),
                            contentDescription = null,
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            contentScale = ContentScale.Inside,

                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Card(
                        shape = CircleShape,
                        elevation = 3.dp,
                        backgroundColor = Color(0xFFFF6D00),
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    if (isRunning) {
                                        isRunning = false
                                    }
                                }
                            ),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_pause),
                            contentDescription = null,
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            contentScale = ContentScale.Inside
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                    )
                    Card(
                        shape = CircleShape,
                        elevation = 3.dp,
                        backgroundColor = Color(0xFFE53935),
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    isRunning = false
                                    remaining = countDownTime
                                }
                            ),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_stop),
                            contentDescription = null,
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            contentScale = ContentScale.Inside

                        )
                    }
                }
            }
        }
    }

    if (isRunning) {
        LaunchedEffect("timer") {
            while (isActive) {
                if (isActive) {
                    remaining--
                    if (remaining == 0) {
                        isRunning = false
                    }
                }
                delay(1000)
            }
        }
    }
}
