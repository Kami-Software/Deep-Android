package com.example.deepwork.deep_work_app.presentation.timeline_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TimelineScreen(){
    Column (modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Text("Timeline", color = Color.White)
    }



    Box(
        modifier = Modifier // Bulanıklık efekti
            .background(Color.White.copy(alpha = 0.6f)).blur(radius = 10.dp).fillMaxWidth()
            .height(400.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("Timeline", color = Color.Black)

    }
}