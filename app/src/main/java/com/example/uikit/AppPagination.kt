package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.ui.theme.UikitTheme


@Composable
fun APPPagination(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    count: Int = 3,

    ) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        repeat(count) { index ->
            val color = if (index == selectedIndex) Color(0xffFA5075) else {
                Color(0xffFA5075).copy(alpha = 0.35f)
            }
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(shape = CircleShape, color = color)
            )
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun PreviewAppPagination() {
    UikitTheme { APPPagination(modifier = Modifier.fillMaxWidth(), count = 5, selectedIndex = 1) }
}