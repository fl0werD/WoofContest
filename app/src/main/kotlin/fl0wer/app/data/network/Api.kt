package fl0wer.app.data.network

import fl0wer.entity.Woofs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface Api {

    @GET("random")
    suspend fun getWoofs(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): Response<Woofs>
}
