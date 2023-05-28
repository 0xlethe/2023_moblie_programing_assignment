package com.moblie.programming.assignment.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.ui.component.CertificateSimpleCard
import com.moblie.programming.assignment.ui.component.Header
import com.moblie.programming.assignment.ui.theme.AssignmentTheme

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
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(if (value.isNotEmpty()) 0.7f else 1f)
                    .padding(end = 8.dp),
                shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp),
                color = Color.White,
            ) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp)
                )
            }

            Button(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                onClick = onClick,
            ) {
                Text(text = "Clear")
            }
        }
    }

    @Composable
    fun SearchListView(textState: String) {
        if (textState?.isNotEmpty()) (
            CertificateManager.data.filter {
                it.name?.contains(textState) || it.organization?.contains(textState)
            }.map {
                CertificateSimpleCard(it) {
                    startActivity(
                        Intent(applicationContext, InfoActivity::class.java).putExtra("Certificate", it)
                    )
                }
            }
        ) else Box(modifier = Modifier.padding(24.dp), contentAlignment = Alignment.Center) {
            Text("검색어를 입력해 주세요")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        var textState by remember { mutableStateOf("") }
        AssignmentTheme {
            Column() {
                Surface(
                    color = Color.DarkGray,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Row() {
                            Header("Search", color = Color.White, onClick = { finish() })
                        }
                        SearchBar(textState, { text -> textState = text }, { textState = String() })
                    }
                }

                Column(
                    modifier = Modifier
                        .verticalScroll(state = ScrollState(0), enabled = true)
                        .padding(top = 24.dp)
                        .weight(1f)
                ) {
                    SearchListView(textState)
                }
            }
        }
    }
}