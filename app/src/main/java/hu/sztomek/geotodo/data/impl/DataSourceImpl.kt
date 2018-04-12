package hu.sztomek.geotodo.data.impl

import hu.sztomek.geotodo.data.api.CategoryDao
import hu.sztomek.geotodo.data.api.PlaceDao
import hu.sztomek.geotodo.data.api.TodoDao
import hu.sztomek.geotodo.data.converter.toDbModel
import hu.sztomek.geotodo.data.converter.toEntity
import hu.sztomek.geotodo.data.converter.toQuery
import hu.sztomek.geotodo.domain.data.DataSource
import hu.sztomek.geotodo.domain.data.ListRequest
import hu.sztomek.geotodo.domain.model.CategoryEntity
import hu.sztomek.geotodo.domain.model.PlaceEntity
import hu.sztomek.geotodo.domain.model.TodoEntity

class DataSourceImpl(
        private val categoryDao: CategoryDao,
        private val placeDao: PlaceDao,
        private val todoDao: TodoDao
) : DataSource{

    override fun listCategories(request: ListRequest): List<CategoryEntity> {
        return categoryDao.list(
                (request as ListRequest.CategoryListRequest).toQuery()
        ).map {
            it.toEntity()
        }
    }

    override fun saveCategory(categoryEntity: CategoryEntity): Long {
        return categoryDao.save(categoryEntity.toDbModel())
    }

    override fun deleteCategory(categoryEntity: CategoryEntity) {
        categoryDao.delete(categoryEntity.id!!)
    }

    override fun listPlaces(request: ListRequest): List<PlaceEntity> {
        return placeDao.list(
                (request as ListRequest.PlaceListRequest).toQuery()
        ).map {
            it.toEntity()
        }
    }

    override fun savePlace(placeEntity: PlaceEntity): Long {
        return placeDao.save(placeEntity.toDbModel())
    }

    override fun deletePlace(placeEntity: PlaceEntity) {
        placeDao.delete(placeEntity.id!!)
    }

    override fun listTodos(request: ListRequest): List<TodoEntity> {
        return todoDao.list(
                (request as ListRequest.TodoListRequest).toQuery()
        ).map {
            it.toEntity()
        }
    }

    override fun saveTodo(todoEntity: TodoEntity): Long {
        return todoDao.save(todoEntity.toDbModel())
    }

    override fun deleteTodo(todoEntity: TodoEntity) {
        todoDao.delete(todoEntity.id!!)
    }
}