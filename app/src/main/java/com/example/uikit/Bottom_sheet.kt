package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.ui.theme.AppColor
import com.example.uikit.ui.theme.UikitTheme

@Composable
fun Bottom_sheet(
    heightIn: Dp = 500.dp,
    title: String = "",
    isActive: Boolean = false,
    content: @Composable () -> Unit,

) {
    if (isActive) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = AppColor.Gradient_red,
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                )
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .heightIn(max = heightIn),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .heightIn(1.dp)
                    .background(color = AppColor.White, shape = RoundedCornerShape(2.dp))
            )
            Spacer(Modifier.height(20.dp))
            if (title.isNotEmpty()) {
                Text(
                    text = title,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(20.dp))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                content()
            }
        }
    } else {
        Column(Modifier.fillMaxSize()) {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottom_sheet_T() {
    UikitTheme {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Bottom_sheet(title = "TEsT", isActive = true) {
                repeat(5) {
                    Text(text="bnmjkl",style = MaterialTheme.typography.labelLarge.copy(brush = AppColor.GradientBrush)
//                        style = )
                    )
                }
            }
        }
    }
}@Preview(showBackground = true)
@Composable
fun PreviewBottom_sheet_F() {
    UikitTheme {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Bottom_sheet(title = "TEsT", isActive = false) {
                repeat(5) {
                    Text(text="bnmjkl"
                         )

                }
            }
        }
    }
}