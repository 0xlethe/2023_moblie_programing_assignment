package com.moblie.programming.assignment.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moblie.programming.assignment.ui.component.Header
import com.moblie.programming.assignment.ui.theme.AssignmentTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ) {
                    DefaultPreview()
                }
            }
        }
    }

    @Composable
    fun MainHeader() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
        ) {
            Column() {
                Header("Demo", color = Color.White)
                Button(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth().padding(16.dp, 0.dp, 16.dp, 16.dp),
                    onClick = {
                    }
                ) {
                    Text("원하시는 검색어를 입력해주세요")
                }
            }
        }
    }

    @Composable
    fun MainButton(text: String, onClick: () -> Unit) {
        Button(
            modifier = Modifier
            .fillMaxWidth().height(160.dp)
            .padding(8.dp, 16.dp, 8.dp, 0.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = onClick
        ) {
            Text(text = text, fontWeight = FontWeight.Bold, fontSize = 32.sp)
        }
    }

    @Composable
    fun MainButtonList() {
        Surface(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp, vertical = 8.dp),
        ) {
            Column() {
                MainButton("Button 1", { /* TODO */})
                MainButton("Button 2", { /* TODO */})
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Column() {
            MainHeader()
            MainButtonList()
        }
    }
}