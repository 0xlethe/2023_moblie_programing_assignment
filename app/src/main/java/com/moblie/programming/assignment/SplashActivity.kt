package com.moblie.programming.assignment

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TextInputService
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.type.Certificate
import com.moblie.programming.assignment.ui.component.Header
import com.moblie.programming.assignment.ui.theme.AssignmentTheme
import com.moblie.programming.assignment.views.MainActivity
import kotlinx.coroutines.NonCancellable.cancel
import kotlin.concurrent.timer

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var progress = 0.1f
        CertificateManager.data = arrayOf(
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
//            Certificate("TEST", "ASDF"),
            Certificate("TEST2", "ASDF2"))

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

        timer(initialDelay = 1000, period = 1000) {
            cancel()
            startActivity(
                Intent(applicationContext, MainActivity::class.java)
                .setFlags(FLAG_ACTIVITY_CLEAR_TOP)
            )
            finish()
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AssignmentTheme {
            Column() {
                Header("Splash")
            }
        }
    }
}