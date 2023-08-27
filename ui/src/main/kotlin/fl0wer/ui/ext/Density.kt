package fl0wer.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.dpRoundToPx() = with(LocalDensity.current) { roundToPx() }
