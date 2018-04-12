package hu.sztomek.geotodo.domain.action

import hu.sztomek.geotodo.domain.model.Entity

sealed class Result {

    data class ListResult<out E: Entity>(val list: List<E>) : Result()
    data class SingleResult<out E: Entity>(val item: E) : Result()
    class LogicalResult : Result()

}