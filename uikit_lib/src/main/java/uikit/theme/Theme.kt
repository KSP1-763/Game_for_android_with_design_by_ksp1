import uikit.theme.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
//    primary = Accent,
//    onPrimary = White,
//    background = Background,
//    onBackground = Black,
//    error = Error,
//    secondary = Accent_inactive

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun UikitTheme(context: @Composable ()->Unit) {
    MaterialTheme(colorScheme = LightColorScheme,
        typography = Typography,
        content = context)
}