package hu.sztomek.geotodo.domain.data

import hu.sztomek.geotodo.domain.model.CategoryEntity
import hu.sztomek.geotodo.domain.model.PlaceEntity
import hu.sztomek.geotodo.domain.model.TodoEntity

interface DataSource {

    fun listCategories(request: ListRequest): List<CategoryEntity>
    fun saveCategory(categoryEntity: CategoryEntity): Long
    fun deleteCategory(categoryEntity: CategoryEntity)

    fun listPlaces(request: ListRequest): List<PlaceEntity>
    fun savePlace(placeEntity: PlaceEntity): Long
    fun deletePlace(placeEntity: PlaceEntity)

    fun listTodos(request: ListRequest): List<TodoEntity>
    fun saveTodo(todoEntity: TodoEntity): Long
    fun deleteTodo(todoEntity: TodoEntity)

}