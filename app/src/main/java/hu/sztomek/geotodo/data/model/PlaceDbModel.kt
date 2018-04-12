package hu.sztomek.geotodo.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class PlaceDbModel(
        @Id var id: Long = 0L,
        val name: String,
        val latitude: Double,
        val longitude: Double
) : DbModel
{
    lateinit var categories: ToMany<CategoryDbModel>
}