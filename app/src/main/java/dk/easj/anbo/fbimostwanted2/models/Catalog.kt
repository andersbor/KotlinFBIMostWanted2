package dk.easj.anbo.fbimostwanted2.models

import com.squareup.moshi.Json

data class Catalog(
    @field:Json(name = "items") val items: List<Item>,
    val page: Int,
    val total: Int
)