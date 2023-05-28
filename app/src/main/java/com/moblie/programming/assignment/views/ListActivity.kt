package com.moblie.programming.assignment.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.ui.component.CertificateSimpleCard
import com.moblie.programming.assignment.ui.component.Header
import com.moblie.programming.assignment.ui.theme.AssignmentTheme

class ListActivity : ComponentActivity() {
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
    fun ListHeader() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
        ) {
            Column() {
                Header("List", color = Color.White, onClick = { finish() })
            }
        }
    }

    @Composable
    fun CertificateListView() {
        CertificateManager.data.map {
            CertificateSimpleCard(it) {
                startActivity(
                    Intent(
                        applicationContext,
                        InfoActivity::class.java
                    ).putExtra("Certificate", it)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Column() {
            ListHeader()
            Column(
                modifier = Modifier
                    .verticalScroll(state = ScrollState(0), enabled = true)
                    .padding(top = 24.dp)
                    .weight(1f)
            ) {
                CertificateListView()
            }
        }
    }
}