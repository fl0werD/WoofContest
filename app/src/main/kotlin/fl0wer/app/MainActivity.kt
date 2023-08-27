package fl0wer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import fl0wer.app.domain.Model
import fl0wer.app.presentation.WoofsScreen
import fl0wer.ui.theme.ComposeContestTheme

internal class MainActivity : ComponentActivity() {

    init {
        Model.woofs()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            ComposeContestTheme {
                WoofsScreen()
            }
        }
    }

    override fun onDestroy() {
        Model.clear()
        super.onDestroy()
    }
}
