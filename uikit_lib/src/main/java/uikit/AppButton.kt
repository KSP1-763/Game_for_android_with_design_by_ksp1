package uikit

import AppColor
import AppTextStyle
import UikitTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.sp

@Composable
fun AppButton(
    onClick: () -> Unit,
    title: String = "",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(100.dp))
            .background(brush = AppColor.Gradient_red)
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = AppTextStyle.Caption_2_Bold.copy(fontSize = 14.sp),
            color = Color.White
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewAppButton() {
    UikitTheme {
        AppButton(
            onClick = {},
            title = "Let’s Combat!",
            modifier = Modifier.padding(20.dp)
        )
    }
}