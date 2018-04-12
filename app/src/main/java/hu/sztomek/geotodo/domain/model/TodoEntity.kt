package hu.sztomek.geotodo.domain.model

data class TodoEntity(
        val id: Long? = null,
        val description: String,
        val place: PlaceEntity? = null,
        val categories: List<CategoryEntity> = emptyList()
) : Entity