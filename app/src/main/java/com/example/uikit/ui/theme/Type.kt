package com.example.uikit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppFont = FontFamily.SansSerif

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = AppFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.33.sp,
        lineHeight = 28.sp
    ),
    displaySmall = TextStyle(
        fontFamily = AppFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.33.sp,
        lineHeight = 28.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = AppFont,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.38.sp,
        lineHeight = 28.sp
    ), headlineMedium = TextStyle(
        fontFamily = AppFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.38.sp,
        lineHeight = 28.sp
    ), headlineSmall = TextStyle(
        fontFamily = AppFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        letterSpacing = 0.38.sp,
        lineHeight = 28.sp
    ), titleLarge = TextStyle(
        fontFamily = AppFont,
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ), titleMedium = TextStyle(
        fontFamily = AppFont,
        fontSize = 17.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ), titleSmall = TextStyle(
        fontFamily = AppFont,
        fontSize = 17.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    )


)