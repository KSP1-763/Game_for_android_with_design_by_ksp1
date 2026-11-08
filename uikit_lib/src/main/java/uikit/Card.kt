package uikit

import AppColor
import AppTextStyle
import UikitTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit_lib.R

@Composable
fun Card(
    title: String? = "",
    content: String? = "",
    onClick: () -> Unit,
    image: @Composable () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(169.dp)
            .background(
                shape = RoundedCornerShape(10.dp),
                brush = AppColor.Gradient_red
            )
            .padding(vertical = 1.dp)
    ) {

        Column(
            modifier = Modifier
//                .fillMaxWidth()
                .padding(start = 24.dp, top = 30.dp, bottom = 23.67.dp)
        ) {
            Text(
                text = title.toString(),
                color = Color.White,
                style = AppTextStyle.Headline_Regular.copy(
                    letterSpacing = -0.3.sp,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.height(14.dp))
            Text(
                text = content.toString(),
                color = Color.White,
                style = AppTextStyle.Headline_Regular.copy( letterSpacing = -0.3.sp,
                    fontSize = 10.sp,
                    )
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.forward_arrow),
                contentDescription = "Arrow",
                modifier = Modifier.clickable { onClick() }.height(9.33.dp)
                    .width(14.dp))
            }
        Box(modifier = Modifier
            .align(Alignment.BottomEnd)
            .width(112.dp)
            .height(107.dp).padding(end = 7.15.dp, bottom = 16.73.dp))
        {
            image()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    UikitTheme {
        Card(
            onClick = {},
            modifier = Modifier.padding(20.dp),
            title = "Schedule",
            content = "Easily schedule event/games\n" +
                    "then find like minded players for \n battle. You up for it?",
            image = {
                Image(

                    painter = painterResource(R.drawable.picture_1),
                    contentDescription = "picture.1",

                    )
            }
        )
    }
}