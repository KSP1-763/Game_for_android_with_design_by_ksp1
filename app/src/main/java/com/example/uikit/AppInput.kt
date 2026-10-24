package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R.drawable.icon_error
import com.example.uikit.ui.theme.AppTextStyle
import com.example.uikit.ui.theme.BorderGradient
import com.example.uikit.ui.theme.GradientBrush
import com.example.uikit.ui.theme.White

@Composable
fun AppInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String = "",
    TrailingIcon: (@Composable () -> Unit)? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    isPassword: Boolean = false
) {
    val borderColor = if (isError) {
        SolidColor(MaterialTheme.colorScheme.error)
    } else {
        BorderGradient
    }
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(
                    color = White, shape = RoundedCornerShape(60.dp),
                )
                .drawBehind {
                    drawRoundRect(
                        brush = borderColor,
                        style = Stroke(width = 1.dp.toPx()),
                        cornerRadius = CornerRadius(60.dp.toPx())
                    )
                }
                .border(color = Color.White, shape = RoundedCornerShape(60.dp), width = 1.dp)
                .padding(start = 10.dp, end = 13.dp, top = 9.dp, bottom = 7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .weight(1f),
                value = value,
                onValueChange = onValueChange,
                textStyle = MaterialTheme.typography.labelLarge.copy(
                    brush = GradientBrush,
                    fontSize = 10.sp
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeHolder,
                            style = AppTextStyle.Caption_2_Regular.copy(brush = GradientBrush)
                            , fontSize = 10.sp
                        )

                    }
                    innerTextField()
                },
                visualTransformation = if (isPassword) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                }

            )
            if (!isError) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clickable(
                            enabled = onTrailingIconClick != null
                        ) {
                            onTrailingIconClick?.invoke()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    TrailingIcon?.invoke()
                }


            }

        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xffE9F0F7)
@Composable
fun PreviewAppInput() {
    _root_ide_package_.com.example.uikit.ui.theme.UikitTheme {
        AppInput(
            modifier = Modifier.padding(20.dp),
            value = "",
            onValueChange = {},
            placeHolder = "Input Field",
//            isError = true,
            TrailingIcon = {
                Image(
                    painter = painterResource(id = icon_error),
                    contentDescription = "icon_error",
                    modifier = Modifier
                        .size(16.dp)
                        .padding()

                )
            }
        )
//        AppInput(
//            value = "user@mail.ru",
//            onValueChange = {},
//            placeHolder = "Input Field"
//        )
//        AppInput(
//            value = "abc",
//            onValueChange = {},
//            placeHolder = "Input Field",
//            isError = true
//        )
    }
}