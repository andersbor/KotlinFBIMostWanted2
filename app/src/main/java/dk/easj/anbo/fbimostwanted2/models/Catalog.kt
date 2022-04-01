package dk.easj.anbo.fbimostwanted2.models

data class Catalog(
    val items: List<Item>,
    val page: Int,
    val total: Int
)