//package com.example.uikit
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.drawBehind
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.SolidColor
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.uikit.ui.theme.*
//
//// Градиент для обводки из Figma (Style/7)
//val BorderGradient = Brush.linearGradient(
//    colors = listOf(
//        Color(0xFFE9F0F7), // 0%
//        Color(0xFFFFFFFF)  // 100%
//    )
//)
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
//    // Если ошибка — красная рамка, иначе градиентная
//    val strokeBrush = if (isError) SolidColor(MaterialTheme.colorScheme.error) else BorderGradient
//
//    Column(modifier = modifier) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(30.dp) // Точная высота 30 из Figma
//                // Фон поля: белый (FFFFFF)
//                .background(color = Color.White, shape = RoundedCornerShape(60.dp))
//                // Кастомная градиентная обводка (толщина 1dp)
//                .drawBehind {
//                    drawRoundRect(
//                        brush = strokeBrush,
//                        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx()),
//                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(60.dp.toPx())
//                    )
//                }
//                .padding(start = 12.dp, end = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BasicTextField(
//                modifier = Modifier.weight(1f),
//                value = value,
//                onValueChange = onValueChange,
//                textStyle = MaterialTheme.typography.labelLarge.copy(
//                    color = Black,
//                    fontSize = 14.sp
//                ),
//                singleLine = true,
//                cursorBrush = SolidColor(Accent),
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
//                ),
//                visualTransformation = if (isPassword) {
//                    PasswordVisualTransformation()
//                } else {
//                    VisualTransformation.None
//                },
//                decorationBox = { innerTextField ->
//                    if (value.isEmpty()) {
//                        Text(
//                            text = placeHolder,
//                            style = AppTextStyle.Caption_2_Regular.copy(
//                                brush = GradientBrush, // Плейсхолдер остается градиентным
//                                fontSize = 14.sp
//                            )
//                        )
//                    }
//                    innerTextField()
//                }
//            )
//
//            // Иконка ровно 16x16
//            if (TrailingIcon != null) {
//                Box(
//                    modifier = Modifier
//                        .size(16.dp)
//                        .clickable(enabled = onTrailingIconClick != null) {
//                            onTrailingIconClick?.invoke()
//                        },
//                    contentAlignment = Alignment.Center
//                ) {
//                    TrailingIcon()
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewAppINput() {
//    UikitTheme {
//        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
//            // 1. Обычное поле (Белое с градиентной рамкой)
//            AppInput(
//                value = "",
//                onValueChange = {},
//                placeHolder = "Input field"
//            )
//
//            // 2. Поле с ошибкой
//            AppInput(
//                value = "",
//                onValueChange = {},
//                placeHolder = "Input field",
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