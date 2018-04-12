package hu.sztomek.geotodo.domain.action

import hu.sztomek.geotodo.domain.model.CategoryEntity
import hu.sztomek.geotodo.domain.model.PlaceEntity
import hu.sztomek.geotodo.domain.model.TodoEntity

sealed class Action {

    abstract class PagedAction : Action() {
        abstract val page: Int
        abstract val size: Int
    }

    data class SaveCategoryAction(val categoryEntity: CategoryEntity): Action()
    data class DeleteCategoryAction(val categoryEntity: CategoryEntity): Action()
    data class ListCategoryAction(
            val descriptionFilter: String?,
            override val page: Int,
            override val size: Int
    ) : PagedAction()

    data class SavePlaceAction(val placeEntity: PlaceEntity): Action()
    data class DeletePlaceAction(val placeEntity: PlaceEntity): Action()
    data class ListPlaceAction(
            val placeNameFilter: String?,
            override val page: Int,
            override val size: Int
    ) : PagedAction()

    data class SaveTodoAction(val todoEntity: TodoEntity): Action()
    data class DeleteTodoAction(val todoEntity: TodoEntity): Action()
    data class ListTodoAction(
            val descriptionFilter: String?,
            val showComplete: Boolean,
            override val page: Int,
            override val size: Int
    ) : PagedAction()

}