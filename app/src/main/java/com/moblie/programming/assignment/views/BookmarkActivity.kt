package com.moblie.programming.assignment.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moblie.programming.assignment.manager.CertificateManager
import com.moblie.programming.assignment.manager.DBHelper
import com.moblie.programming.assignment.ui.component.CertificateSimpleCard
import com.moblie.programming.assignment.ui.component.Header
import com.moblie.programming.assignment.ui.theme.AssignmentTheme

class BookmarkActivity : ComponentActivity() {
    lateinit var db: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DBHelper(this)
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
    fun BookmarkHeader() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
        ) {
            Column() {
                Header("Bookmark", color = Color.White, onClick = { finish() })
            }
        }
    }

    @Composable
    fun bottomButton(onClick: () -> Unit) {
        Surface(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            color = Color.DarkGray,
        ) {
            Row(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            ) {
                Button(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClick
                ) {
                    Text("Delete All")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        var (list, setList) = remember { mutableStateOf(db.getList()) }
        Column() {
            BookmarkHeader()
            Column(
                modifier = Modifier
                    .verticalScroll(state = ScrollState(0), enabled = true)
                    .padding(top = 24.dp)
                    .weight(1f)
            ) {
                list.mapNotNull {
                    CertificateManager.data.find { cer -> it == cer.id }
                }.map {
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
            bottomButton {
                db.deleteAllFav()
                setList(listOf<Int>())
            }
        }
    }
}