package hu.sztomek.geotodo.domain.model

data class CategoryEntity(
        val id: Long? = null,
        val name: String,
        val color: Int
) : Entity