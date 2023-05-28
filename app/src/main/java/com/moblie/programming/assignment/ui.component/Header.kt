package com.moblie.programming.assignment.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(title: String, color: Color = Color.Black) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$title", fontWeight = FontWeight.Bold, fontSize = 32.sp, color = color)
    }
}
@Composable
fun Header(title: String, color: Color = Color.Black, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$title", fontWeight = FontWeight.Bold, fontSize = 32.sp, color = color)
        TextButton(
            modifier = Modifier.height(48.dp).width(48.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        ) {
            Text(text = "X", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp, textAlign = TextAlign.Center)
        }
    }
}