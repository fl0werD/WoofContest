package fl0wer.app.domain

import fl0wer.app.data.network.Api
import fl0wer.app.presentation.entity.toItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object Model {

    private const val DEFAULT_LIMIT = 10
    private const val BASE_URL = "https://compose-challenge.vercel.app/api/"

    private val api: Api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(Api::class.java)

    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private val state = MutableStateFlow<State>(State.Loading)

    fun observeState() = state.asStateFlow()

    fun woofs() = scope.launch {
        val dataState = state.value as? State.Data
        if (dataState != null && dataState.woofs.count() >= dataState.paging.total) {
            return@launch
        }
        val page = when (dataState) {
            null -> 1
            else -> dataState.paging.page + 1
        }
        val result = getWoofs(page, DEFAULT_LIMIT)
        state.update {
            val woofs = when (it) {
                is State.Data -> it.woofs
                else -> emptyList()
            }
            State.Data(
                woofs = woofs + result.items.toItems(),
                paging = result.paging,
            )
        }
    }

    private suspend fun getWoofs(page: Int, limit: Int) = withContext(Dispatchers.IO) {
        api.getWoofs(page, limit).body()!!
    }

    fun clear() {
        scope.cancel()
    }
}
