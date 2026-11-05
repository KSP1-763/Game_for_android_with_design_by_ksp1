package com.example.uikit


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.ui.theme.AppTextStyle
import com.example.uikit.ui.theme.UikitTheme


@Composable
fun AppSelect(
    title: String,
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            style = AppTextStyle.Text_Regular.copy(color = Color(0xffFA5075), fontSize = 8.sp)
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = value,
                modifier= Modifier.padding(end = 16.dp),
                style = AppTextStyle.Caption_2_Regular.copy(color = Color(0xff030303))
            )
//            Spacer(Modifier.width(16.dp))
            Canvas(modifier = Modifier.size(10.dp)) {
                val path = Path().apply {
                    moveTo(size.width * 0.2f, size.height * 0.4f)
                    lineTo(size.width * 0.5f, size.height * 0.7f)
                    lineTo(size.width * 0.8f, size.height * 0.4f)
                }
                drawPath(
                    path = path,
                    color = Color(0xffFA5075),
                    style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSelect() {
    UikitTheme {
        AppSelect(
            modifier = Modifier.fillMaxWidth(),
            title = "From",
            onClick = {},
            value = "MON, NOV 4,2019"
        )
    }
}