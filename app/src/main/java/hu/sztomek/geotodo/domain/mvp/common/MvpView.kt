package hu.sztomek.geotodo.domain.mvp.common

import hu.sztomek.geotodo.domain.action.Action
import hu.sztomek.geotodo.domain.action.Result

interface MvpView {

    fun operationSuccessful(action: Action, result: Result)
    fun operationFailed(action: Action, exception: Exception)

}