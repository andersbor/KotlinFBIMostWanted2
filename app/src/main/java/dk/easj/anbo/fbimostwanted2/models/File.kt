package dk.easj.anbo.fbimostwanted2.models

import com.squareup.moshi.Json

data class File(
    @field:Json(name = "name") val name: String,
    val url: String
)