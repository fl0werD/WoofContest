package fl0wer.app.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import fl0wer.app.presentation.entity.WoofItem
import fl0wer.app.presentation.paging.PagingLoader

private const val LOADER_KEY = -1

internal const val MAX_SPAN_COUNT = 2

internal val woofsContentPadding = WindowInsets(
    left = 16.dp,
    top = 24.dp,
    right = 16.dp,
    bottom = 24.dp,
)

@Composable
internal fun WoofsList(
    items: List<WoofItem>,
    totalItems: Int,
    requestNextPage: () -> Unit,
) {
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        state = listState,
        columns = GridCells.Fixed(MAX_SPAN_COUNT),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = woofsContentPadding.add(WindowInsets.safeDrawing).asPaddingValues(),
    ) {
        items(items, { it.id }) {
            WoofCard(it)
        }
        if (items.count() < totalItems) {
            item(LOADER_KEY, { GridItemSpan(MAX_SPAN_COUNT) }) {
                PagingLoader()
            }
        }
    }
    val layoutInfo by remember {
        derivedStateOf { listState.layoutInfo }
    }
    val isAtBottom = !listState.canScrollForward
    LaunchedEffect(isAtBottom) {
        if (!isAtBottom || !layoutInfo.isScrolledToEnd() || items.count() >= totalItems) {
            return@LaunchedEffect
        }
        requestNextPage()
    }
}

private fun LazyGridLayoutInfo.isScrolledToEnd() = visibleItemsInfo.lastOrNull()?.key == LOADER_KEY
