package com.example.harmonyhome.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme

@Composable
fun PreviewView(modifier: Modifier = Modifier) {
    Box(modifier.border(1.dp, MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))) {
        Column(modifier.fillMaxWidth()) {
            PreviewRow(3f, 2f)
            PreviewRow(2f, 3f)

        }
    }
}

@Composable
private fun PreviewRow(leftPillSize: Float, rightPillSize: Float) {
    Row(Modifier.fillMaxWidth()) {
        PreviewCard(
            Modifier
                .height(120.dp)
                .padding(8.dp)
                .weight(leftPillSize),
            title = "4",
            subtitle = "Tasks"
        )
        PreviewCard(
            Modifier
                .height(120.dp)
                .padding(8.dp)
                .weight(rightPillSize),
            title = "2",
            subtitle = "Today"
        )

    }
}

@Composable
private fun PreviewCard(modifier: Modifier = Modifier, title: String = "", subtitle: String = "") {
    OutlinedCard(
        modifier,
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(start = 24.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(text = subtitle, modifier = Modifier.padding(start = 24.dp, bottom = 18.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewViewPreview() {
    HarmonyHomeTheme {
        PreviewView()
    }

}