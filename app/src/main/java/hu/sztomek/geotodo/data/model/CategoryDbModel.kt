package hu.sztomek.geotodo.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class CategoryDbModel(
        @Id var id: Long = 0L,
        val title: String,
        val color: Int
) : DbModel