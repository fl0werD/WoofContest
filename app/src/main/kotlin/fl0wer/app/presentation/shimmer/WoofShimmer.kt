package fl0wer.app.presentation.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import fl0wer.app.presentation.CardSize
import fl0wer.ui.ext.shimmerEffect

@Composable
internal fun WoofShimmer() {
    Box(
        modifier = Modifier
            .size(CardSize)
            .clip(RoundedCornerShape(12.dp))
            .shimmerEffect()
    )
}
