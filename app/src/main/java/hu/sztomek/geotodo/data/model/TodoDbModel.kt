package hu.sztomek.geotodo.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
data class TodoDbModel(
        @Id var id: Long = 0L,
        val description: String,
        val completedAt: Long? = null
) : DbModel
{

    lateinit var categories: ToMany<CategoryDbModel>
    lateinit var place: ToOne<PlaceDbModel>

}