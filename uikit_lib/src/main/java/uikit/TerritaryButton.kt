package uikit

import AppTextStyle
import UikitTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit_lib.R

@Composable
fun TertiaryButton(
    title: String,
    modifier: Modifier = Modifier

) {
    Row(modifier = modifier.height(20.dp)) {
        Image(painter = painterResource(R.drawable.logout_icon), contentDescription = title)
        Spacer(Modifier.width(18.dp))
        Text(text = title, style = AppTextStyle.Headline_Regular.copy(letterSpacing = -0.3.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTertiaryButton() {
    UikitTheme { TertiaryButton(title = "Logout", modifier = Modifier.padding(20.dp)) }
}