package fl0wer.ui.theme

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val colorScheme = lightColorScheme(
    primary = Teal,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeContestTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    SideEffect {
        (view.context as Activity).window.apply {
            val argbColor = SystemBarsColor.toArgb()
            statusBarColor = argbColor
            navigationBarColor = argbColor
        }
    }
    MaterialTheme(colorScheme = colorScheme) {
        CompositionLocalProvider(
            LocalOverscrollConfiguration provides null,
            content = content,
        )
    }
}
