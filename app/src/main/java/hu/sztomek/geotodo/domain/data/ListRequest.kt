package hu.sztomek.geotodo.domain.data

sealed class ListRequest {
    abstract val offset: Int
    abstract val size: Int

    data class CategoryListRequest(
            val nameFilter: String? = null,
            override val offset: Int,
            override val size: Int
    ) : ListRequest()

    data class PlaceListRequest(
            val nameFilter: String? = null,
            override val offset: Int,
            override val size: Int
    ) : ListRequest()


    data class TodoListRequest(
            val filter: String? = null,
            val showComplete: Boolean,
            override val offset: Int,
            override val size: Int
    ) : ListRequest()

}