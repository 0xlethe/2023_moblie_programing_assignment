package com.moblie.programming.assignment.ui.component

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moblie.programming.assignment.type.Certificate
import com.moblie.programming.assignment.views.InfoActivity

@Composable
fun CertificateSimpleCard(certificate: Certificate, onClick: () -> Unit) {
    Button(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp),
        onClick = onClick
    ) {
        Column() {
            Text(certificate.name)
            Text(certificate.organization)
        }
    }
}
