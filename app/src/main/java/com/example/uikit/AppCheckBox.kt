package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.ui.theme.Background
import com.example.uikit.ui.theme.UikitTheme
import com.example.uikit.ui.theme.White

@Composable
fun AppCheckBox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val strokeColor=Color(0xffD6E5F2)
    val bgColor = if (isChecked) {
        Background
    } else {
        White
    }
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(3.dp),
                    ambientColor = Color(0xff8A9BBD).copy(alpha = 0.3f),
                    spotColor = Color(0xffffffff).copy(alpha = 0.9f)
                )
                .background(color = bgColor, shape = RoundedCornerShape(3.dp))
                .border(color=strokeColor, width = 0.2.dp, shape = RoundedCornerShape(3.dp)).clickable {
                    onCheckedChange(!isChecked)
                }, contentAlignment = Alignment.Center
        ) {
            if (isChecked) {
                Image(
                    modifier = Modifier.size(10.dp),
                    painter = painterResource(id = R.drawable.tick),
                    contentDescription = "path"
                )
            }
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xff000000)
@Composable
fun PreviewAppCheckBox() {
    UikitTheme {
        Row(modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.spacedBy(9.dp)) {
            AppCheckBox(
                isChecked = true,
                onCheckedChange = {},

            )
            AppCheckBox(
                isChecked = false,
                onCheckedChange = {},

            )
        }
    }
}