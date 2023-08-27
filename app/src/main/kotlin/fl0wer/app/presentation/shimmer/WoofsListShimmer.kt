package fl0wer.app.presentation.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import fl0wer.app.presentation.MAX_SPAN_COUNT
import fl0wer.app.presentation.woofsContentPadding

private const val LOADING_ITEMS_COUNT = 10

@Composable
internal fun WoofsListShimmer() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(MAX_SPAN_COUNT),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = woofsContentPadding.add(WindowInsets.safeDrawing).asPaddingValues(),
        userScrollEnabled = false,
    ) {
        items(LOADING_ITEMS_COUNT) {
            WoofShimmer()
        }
    }
}
