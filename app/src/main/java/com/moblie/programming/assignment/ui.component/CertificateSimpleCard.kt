package com.moblie.programming.assignment.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moblie.programming.assignment.type.Certificate

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
