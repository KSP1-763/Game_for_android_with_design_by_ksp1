package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.ui.theme.AppColor
import com.example.uikit.ui.theme.AppTextStyle
import com.example.uikit.ui.theme.UikitTheme

@Composable
fun AppTimer(
    time: String = "00:59",
    title: String = "Timer",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(99.82.dp)
            .background(
                brush = AppColor.Gradient_red,
                shape = RoundedCornerShape(10.dp)
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(7.dp))
        Text(
            text = title,
            style = AppTextStyle.Caption_2_Regular.copy(letterSpacing = 0.33.sp),
            color = Color.White
        )
        Spacer(Modifier.height(14.dp))
        Text(
            text = time,
            style = MaterialTheme.typography.displayLarge.copy(fontSize = 30.sp, fontWeight = FontWeight.Bold),
            color= Color.White,
            modifier = Modifier
                .height(45.dp)
                .width(88.dp)
        )


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewAppTimer() {
    UikitTheme {
        AppTimer(modifier = Modifier.padding(20.dp), time = "00:00")
    }
}