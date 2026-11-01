package com.example.uikit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.ui.theme.AppColor
import com.example.uikit.ui.theme.UikitTheme

@Composable
fun AppCheckBox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val strokeColor=Color(0xffD6E5F2)
    val bgColor = if (isChecked) {
        AppColor.Background
    } else {
        AppColor.White
    }
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .border(color= AppColor.Stroke_color_checkbox, width = 1.dp, shape = RoundedCornerShape(3.dp))
                .background(color = Color(0xff1E1E1E), shape = RoundedCornerShape(3.dp))
                .clickable {
                    onCheckedChange(!isChecked)
                }, contentAlignment = Alignment.Center
        ) {

            if (isChecked) {
                Canvas(modifier= Modifier.width(5.dp).height(7.dp)) {
                    val path=Path().apply {
                        moveTo(size.width * 0.1f, size.height * 0.5f)
                        lineTo(size.width * 0.3f, size.height * 0.7f)
                        lineTo(size.width * 1f, size.height * 0.05f)
                    }
                    drawPath(path=path,color= AppColor.Stroke_color_checkbox,
                        style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round))

                }
            }
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xff000000)
@Composable
fun PreviewAppCheckBox() {
    UikitTheme {
        Row(modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
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