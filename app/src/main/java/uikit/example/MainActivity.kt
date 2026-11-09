package uikit.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit_lib.R
import uikit.AppButton
import uikit.AppCheckBox
import uikit.AppInput
import uikit.AppPagination
import uikit.AppSelect
import uikit.AppTimer
import uikit.BottomBar
import uikit.Card
import uikit.TertiaryButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        PreviewStorybook()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStorybook() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StorySelection("AppButton") {
            AppButton(onClick = {}, title = "Let's Combat!")
        }
        Row{
        StorySelection("AppCheckbox_is_not_checked") {
            AppCheckBox(isChecked = false, onCheckedChange = {})
        }
            StorySelection("AppCheckbox_checked") {
            AppCheckBox(isChecked = true, onCheckedChange = {})
        }
        }
        StorySelection("Appinput_login") { AppInput(value="FullName",onValueChange = {}) }
        StorySelection("Appinput_password") { AppInput(value="PASSWORD",onValueChange = {}, isPassword = true) }
        StorySelection("AppPagination") { AppPagination(count=3, selectedIndex = 0) }
        StorySelection("AppTimer") { AppTimer() }
        StorySelection("AppBottomBar") { BottomBar() }
        StorySelection("AppCard") { Card(onClick = {},
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
        ) }
        StorySelection("Select") { AppSelect("From", onClick = {},value="MON, NOV 4,2019") }
        StorySelection("TertiaryButton()") { TertiaryButton(title = "Logout") }

    }
}

@Composable
fun StorySelection(title: String, content: @Composable () -> Unit) {
    Column {
        Text(text = title, Modifier.padding(10.dp), textAlign = TextAlign.Center)
        content()
    }
}



