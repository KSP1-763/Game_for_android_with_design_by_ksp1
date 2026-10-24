//package com.example.uikit
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.drawBehind
//import androidx.compose.ui.geometry.CornerRadius
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.SolidColor
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.uikit.ui.theme.*
//
//@Composable
//fun AppInput(
//    value: String,
//    onValueChange: (String) -> Unit,
//    placeHolder: String = "",
//    TrailingIcon: (@Composable () -> Unit)? = null,
//    onTrailingIconClick: (() -> Unit)? = null,
//    modifier: Modifier = Modifier,
//    isError: Boolean = false,
//    isPassword: Boolean = false
//) {
//    val borderColor = if (isError) SolidColor(MaterialTheme.colorScheme.error) else BorderGradient
//
//    // Градиент для имитации внутренней тени из Figma
//    val innerShadowBrush = Brush.verticalGradient(
//        colors = listOf(
//            Color(0xFF8A9BBD).copy(alpha = 0.4f), // Темная тень сверху
//            Color.White.copy(alpha = 0.7f),       // Светлая тень снизу
//            Color.Transparent
//        )
//    )
//
//    Column(modifier = modifier) {
//        Box(
//            modifier = Modifier
//                .width(200.dp)
//                .height(30.dp)
//                .background(color = White, shape = RoundedCornerShape(60.dp))
//                // 1. Рисуем внутреннюю тень (поверх фона)
//                .drawBehind {
//                    drawRoundRect(
//                        brush = innerShadowBrush,
//                        cornerRadius = CornerRadius(60.dp.toPx())
//                    )
//                }
//                // 2. Рисуем градиентную обводку (поверх тени)
//                .drawBehind {
//                    drawRoundRect(
//                        brush = borderColor,
//                        style = Stroke(width = 1.dp.toPx()),
//                        cornerRadius = CornerRadius(60.dp.toPx())
//                    )
//                }
//                // 3. Внутренний отступ, чтобы текст не прилипал к краям
//                .padding(horizontal = 1.dp, vertical = 1.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(color = White, shape = RoundedCornerShape(60.dp))
//                    .padding(start = 10.dp, end = 13.dp, top = 9.dp, bottom = 7.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                BasicTextField(
//                    modifier = Modifier.weight(1f),
//                    value = value,
//                    onValueChange = onValueChange,
//                    textStyle = MaterialTheme.typography.labelLarge.copy(
//                        brush = GradientBrush,
//                        fontSize = 10.sp
//                    ),
//                    singleLine = true,
//                    decorationBox = { innerTextField ->
//                        if (value.isEmpty()) {
//                            Text(
//                                text = placeHolder,
//                                style = AppTextStyle.Caption_2_Regular.copy(
//                                    brush = GradientBrush,
//                                    fontSize = 10.sp
//                                )
//                            )
//                        }
//                        innerTextField()
//                    },
//                    visualTransformation = if (isPassword) {
//                        PasswordVisualTransformation()
//                    } else {
//                        VisualTransformation.None
//                    }
//                )
//
//                if (isError && TrailingIcon != null) {
//                    Box(
//                        modifier = Modifier
//                            .size(16.dp)
//                            .clickable(enabled = onTrailingIconClick != null) {
//                                onTrailingIconClick?.invoke()
//                            },
//                        contentAlignment = Alignment.Center
//                    ) {
//                        TrailingIcon()
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true, backgroundColor = 0xffE9F0F7)
//@Composable
//fun PreviewAppInput() {
//    UikitTheme {
//        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
//            AppInput(
//                value = "",
//                onValueChange = {},
//                placeHolder = "Input Field"
//            )
//            AppInput(
//                value = "",
//                onValueChange = {},
//                placeHolder = "Input Field",
//                isError = true,
//                TrailingIcon = {
//                    Image(
//                        painter = painterResource(id = R.drawable.icon_error),
//                        contentDescription = "icon_error",
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            )
//        }
//    }
//}