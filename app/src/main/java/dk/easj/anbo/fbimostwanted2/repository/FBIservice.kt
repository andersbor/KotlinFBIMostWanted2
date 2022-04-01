package dk.easj.anbo.fbimostwanted.repository

import dk.easj.anbo.fbimostwanted2.models.Catalog
import retrofit2.Call
import retrofit2.http.GET

interface FBIservice {
    @GET("list")
    fun getCatalog(): Call<Catalog>
}