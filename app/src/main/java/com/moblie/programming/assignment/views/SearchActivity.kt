package com.moblie.programming.assignment.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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
import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.ui.component.Header
import com.moblie.programming.assignment.ui.theme.AssignmentTheme
import java.util.*

class SearchActivity : ComponentActivity() {
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
    fun SearchBar(value : String, onValueChange: (text: String) -> Unit, onClick: () -> Unit) {
        Row(
            modifier = Modifier
                .height(72.dp)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(0.7f)
                    .padding(end = 8.dp),
                shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp),
                color = Color.White,
            ) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    value = value,
                    onValueChange = onValueChange,
                )
            }

            Button(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(4.dp),
                onClick = onClick
            ) {
                Text(text = "search")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        var text by remember { mutableStateOf("Click a button") }
        var textState by remember { mutableStateOf("") }
        AssignmentTheme {
            Column() {
                Surface(
                    color = Color.DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
                ) {
                    Column() {
                        Header("Search", color = Color.White)
                        SearchBar(textState, { text -> textState = text }, {})
                    }
                }

                Column(
                    modifier = Modifier.verticalScroll(state = ScrollState(0) , enabled = true).weight(1f)
                ) {
                    CertificateManager.data.filter {
                        if (textState?.isNotEmpty()) {
                            it.name?.contains(textState) || it.company?.contains(textState)
                        } else {
                            true
                        }
                    }.map {
                        Button(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 0.dp, 16.dp, 16.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Column() {
                                Text(it.name)
                                Text(it.company)
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                ) {
                    Button(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { /*TODO*/ }
                    ) {
                        Text("ASDF")
                    }
                }
            }
        }
    }
}