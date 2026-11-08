package uikit

import AppColor
import UikitTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit_lib.R

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .drawBehind {
                val path = Path().apply {
                    moveTo(0f, size.height)
                    lineTo(0f, 40.dp.toPx())
                    lineTo(size.width / 2 - 70.dp.toPx(), 40.dp.toPx())
                    cubicTo(
                        size.width / 2 - 30.dp.toPx(), 40.dp.toPx(),
                        size.width / 2 - 40.dp.toPx(), 10.dp.toPx(),
                        size.width / 2, 10.dp.toPx()
                    )
                    cubicTo(
                        size.width / 2 + 40.dp.toPx(), 10.dp.toPx(),
                        size.width / 2 + 30.dp.toPx(), 40.dp.toPx(),
                        size.width / 2 + 70.dp.toPx(), 40.dp.toPx()
                    )
                    lineTo(size.width, 40.dp.toPx())
                    lineTo(size.width, size.height)
                    close()
                }
                drawPath(path = path, brush = AppColor.Gradient_red)
            }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 12.dp, end = 12.dp, bottom = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                BottomBarItems("Statistics", R.drawable.statistics_icon)
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                BottomBarItems("Discover", R.drawable.location_icon)
            }
            Spacer(Modifier.width(70.dp))
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                BottomBarItems("Chat", R.drawable.chat_icon)
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                BottomBarItems("Profile", R.drawable.profile_icon)
            }
        }
        Box(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 15.dp)
            .size(60.dp), contentAlignment = Alignment.Center
    ){
            Image(
                painter = painterResource(id = R.drawable.calendar_icon),
                contentDescription = "Calendar",
                modifier = Modifier.size(60.dp))
        }


    }
}

@Composable
fun BottomBarItems(
    title: String,
    iconRes: Int
) {
    Column(modifier = Modifier.clickable{},horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            modifier = Modifier.size(15.dp)
        )
//        Spacer()
        Text(text = title, color = Color.White, fontSize = 10.sp, maxLines = 1, textAlign = TextAlign.Center)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomBar() {
    UikitTheme { BottomBar(modifier = Modifier.padding(20.dp)) }
}