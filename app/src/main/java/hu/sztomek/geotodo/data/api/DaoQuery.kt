package hu.sztomek.geotodo.data.api

sealed class DaoQuery {

    abstract class PagedQuery : DaoQuery() {
        abstract val skip: Int
        abstract val size: Int
    }

    data class CategoryQuery(
            val nameFilter: String?,
            override val size: Int,
            override val skip: Int
    ) : PagedQuery()

    data class PlaceQuery(
            val nameFilter: String?,
            override val size: Int,
            override val skip: Int
    ) : PagedQuery()

    data class TodoQuery(
            val descriptionFilter: String?,
            val showCompleted: Boolean,
            override val size: Int,
            override val skip: Int
    ) : PagedQuery()

}