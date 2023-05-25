package com.moblie.programming.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextInputService
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.type.Certificate
import com.moblie.programming.assignment.ui.theme.AssignmentTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var progress = 0.1f
        CertificateManager.data = arrayOf(Certificate("TEST", "ASDF"), Certificate("TEST", "ASDF"))

        setContent {
            AssignmentTheme {
                // A surface container using the 'background' color from the theme
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
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        var text by remember { mutableStateOf("Click a button") }
        AssignmentTheme {
            Column() {
                Row() {
                    Greeting(text)
                }
                Row() {
                    Greeting("Androi2d")
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(modifier = Modifier.fillMaxWidth(0.8f).padding(4.dp), text="Androi2d")
                    Button(modifier = Modifier.fillMaxWidth().padding(4.dp), onClick = { text = "search" }) {
                        Text(text = "Button 2")
                    }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(modifier = Modifier.fillMaxWidth(0.5f).padding(4.dp), onClick = { text = "Button1" }) {
                        Text(text = "Button 1")
                    }
                    Button(modifier = Modifier.fillMaxWidth().padding(4.dp), onClick = { text = "Button 2" }) {
                        Text(text = "Button 2")
                    }
                }
            }
        }
    }
}