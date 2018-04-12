package hu.sztomek.geotodo.data.converter

import hu.sztomek.geotodo.data.api.DaoQuery
import hu.sztomek.geotodo.data.model.CategoryDbModel
import hu.sztomek.geotodo.data.model.PlaceDbModel
import hu.sztomek.geotodo.data.model.TodoDbModel
import hu.sztomek.geotodo.domain.data.ListRequest
import hu.sztomek.geotodo.domain.model.CategoryEntity
import hu.sztomek.geotodo.domain.model.PlaceEntity
import hu.sztomek.geotodo.domain.model.TodoEntity

fun CategoryDbModel.toEntity() = CategoryEntity(
        id = this.id,
        name = this.title,
        color = this.color
)

fun CategoryEntity.toDbModel() = CategoryDbModel(
        id = this.id ?: 0L,
        title = this.name,
        color = this.color
)

fun ListRequest.CategoryListRequest.toQuery() = DaoQuery.CategoryQuery(
        nameFilter = this.nameFilter,
        skip = this.offset,
        size = this.size
)

fun PlaceDbModel.toEntity() = PlaceEntity(
        id = this.id,
        name = this.name,
        latitude = this.latitude,
        longitude = this.longitude,
        categories = this.categories.map { it.toEntity() }
)

fun PlaceEntity.toDbModel() = PlaceDbModel(
        id = this.id ?: 0,
        name = this.name,
        latitude = this.latitude,
        longitude = this.longitude
)

fun ListRequest.PlaceListRequest.toQuery() = DaoQuery.PlaceQuery(
        nameFilter = this.nameFilter,
        size = this.size,
        skip =  this.offset
)

fun TodoDbModel.toEntity() = TodoEntity(
        id = this.id,
        description = this.description,
        place = this.place.target?.toEntity(),
        categories = this.categories.map { it.toEntity() }
)

fun TodoEntity.toDbModel() = TodoDbModel(
        id = this.id ?: 0L,
        description = this.description

)

fun ListRequest.TodoListRequest.toQuery() = DaoQuery.TodoQuery(
        descriptionFilter = this.filter,
        showCompleted = this.showComplete,
        size = this.size,
        skip = this.offset
)
