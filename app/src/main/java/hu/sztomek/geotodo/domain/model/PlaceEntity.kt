package hu.sztomek.geotodo.domain.model

data class PlaceEntity(
        val id: Long? = null,
        val name: String,
        val latitude: Double,
        val longitude: Double,
        val categories: List<CategoryEntity> = emptyList()
) : Entity