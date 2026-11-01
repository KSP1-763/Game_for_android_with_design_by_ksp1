package com.example.uikit

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R.drawable.icon_error
import com.example.uikit.ui.theme.AppColor
import com.example.uikit.ui.theme.AppTextStyle
import com.example.uikit.ui.theme.UikitTheme
import kotlin.io.path.Path
import kotlin.io.path.moveTo

/*
*Компонент для ввода текста.
*Отвечает за отоброжения поля плэйсхолдера и состояния
@param value - Текущий текст.
@param onValueChange - Колбэк при вводе текста.
@param placeHolder - Текст подсказка,
@param TrailingIcon - Иконка справа,
@param onTrailingIconClick - Нажаите на иконку,
@param isError - флаг ошибкм,
@param isPassword - флаг пароля,

*Дата создания:21.10.2026, изменено:25.10.2026
* Автор: KSP1
 */
@Composable
fun AppInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String = "",
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    isPassword: Boolean = false
) {
    val borderColor = if (isError) {
        SolidColor(MaterialTheme.colorScheme.error)
    } else {
        AppColor.BorderGradient
    }
    Column(modifier = modifier.padding(20.dp)) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }, decorationBox = { innerTextField ->
                Column {
                    Box() {
                        if (value.isEmpty()) {
                            Text(text = placeHolder, style = AppTextStyle.Caption_2_Regular)
                        }
                        innerTextField()
                    }
                    Spacer(Modifier.height(8.dp))
                    Canvas(modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)) {
                        drawLine(
                            brush = AppColor.Gradient_red,
                            start = Offset(0f, size.height / 2),
                            end = Offset(size.width, size.height / 2),
                            strokeWidth = size.height
                        )
                    }
                }
            }
        )
    }

}

@Preview(showBackground = true, backgroundColor = 0xff1E1E1E)
@Composable
fun PreviewAppInput() {
    UikitTheme {
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start){
//        AppInput(
//            modifier = Modifier.padding(20.dp),
//            value = "",
//            onValueChange = {},
//            placeHolder = "Input Field",
//            isError = true,
//
//            )
        AppInput(
            value = "user@mail.ru",
            onValueChange = {},
            placeHolder = "Input Field"
        )
        AppInput(
            value = "abc",
            onValueChange = {},
            placeHolder = "Input Field",
            isError = true
        )}
    }
}