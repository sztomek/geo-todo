package hu.sztomek.geotodo.domain.usecase

import hu.sztomek.geotodo.domain.action.Action
import hu.sztomek.geotodo.domain.action.Result

interface BaseUseCase<in A: Action, out R: Result> {

    suspend fun execute(action: A): R

}