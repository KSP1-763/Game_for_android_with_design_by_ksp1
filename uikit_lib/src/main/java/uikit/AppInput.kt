package uikit

import AppColor
import AppTextStyle
import UikitTheme
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/*
*Компонент для ввода текста.
*Отвечает за отображения поля плэйсхолдера и состояния
@param value - Текущий текст.
@param onValueChange - Колбэк при вводе текста.
@param placeHolder - Текст подсказка,
@param TrailingIcon - Иконка справа,
@param onTrailingIconClick - Нажатие на иконку,
@param isError - флаг ошибки,
@param isPassword - флаг пароля,

*Дата создания:21.10.2026, изменено:25.10.2026
* Автор: KSP1
 */
@Composable
fun AppInput(
    value: String?="",
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
    Column(modifier = modifier) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value.toString(),
            onValueChange = onValueChange,
            singleLine = true,
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }, decorationBox = { innerTextField ->
                Column {
                    Box() {
                        if (value.isNullOrBlank()) {
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

@Preview(showBackground = true, backgroundColor = 0xffffffff)
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
            placeHolder = "Input Field", modifier = Modifier.padding(20.dp)
        )
        AppInput(
            value = "abc",
            onValueChange = {},
            placeHolder = "Input Field",
            isError = true,modifier = Modifier.padding(20.dp)
        )
        AppInput(onValueChange = {}, placeHolder = "", value = "")}
    }
}