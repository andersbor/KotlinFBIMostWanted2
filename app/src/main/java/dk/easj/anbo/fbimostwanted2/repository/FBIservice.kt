package dk.easj.anbo.fbimostwanted2.repository

import dk.easj.anbo.fbimostwanted2.models.Catalog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FBIservice {
    @GET("list")
    fun getCatalog(@Query("page") page: Int): Call<Catalog>
}