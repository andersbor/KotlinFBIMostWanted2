package dk.easj.anbo.fbimostwanted2.models

data class Item(
    val id: String,
    val additional_information: Any,
    val age_max: Any,
    val age_min: Any,
    val age_range: Any,
    val aliases: Any,
    val build: Any,
    val caution: Any,
    val complexion: Any,
    val coordinates: List<Any>,
    val dates_of_birth_used: List<String>,
    val description: String,
    val details: String,
    val eyes: String,
    val eyes_raw: String,
    val field_offices: List<String>,
    val files: List<File>,
    val hair: String,
    val hair_raw: String,
    val height_max: Int,
    val height_min: Int,
    val images: List<Image>,
    val languages: Any,
    val legat_names: Any,
    val locations: Any,
    val modified: String,
    val nationality: String,
    val ncic: Any,
    val occupations: Any,
    val path: String,
    val person_classification: String,
    val place_of_birth: String,
    val possible_countries: Any,
    val possible_states: Any,
    val publication: String,
    val race: String,
    val race_raw: String,
    val remarks: Any,
    val reward_max: Int,
    val reward_min: Int,
    val reward_text: String,
    val scars_and_marks: Any,
    val sex: String,
    val status: String,
    val subjects: List<String>,
    val suspects: Any,
    val title: String,
    val uid: String,
    val url: String,
    val warning_message: Any,
    val weight: String,
    val weight_max: Int,
    val weight_min: Int
) {
    override fun toString(): String {
        return title + "\n" + description
    }
}