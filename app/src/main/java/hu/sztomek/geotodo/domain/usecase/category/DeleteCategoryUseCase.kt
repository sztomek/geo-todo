package hu.sztomek.geotodo.domain.usecase.category

import hu.sztomek.geotodo.domain.action.Action
import hu.sztomek.geotodo.domain.action.Result
import hu.sztomek.geotodo.domain.data.DataSource
import hu.sztomek.geotodo.domain.usecase.BaseUseCase
import javax.inject.Inject

class DeleteCategoryUseCase @Inject constructor(
        private val dataSource: DataSource
) : BaseUseCase<Action.DeleteCategoryAction, Result.LogicalResult> {

    override suspend fun execute(action: Action.DeleteCategoryAction): Result.LogicalResult {
        dataSource.deleteCategory(action.categoryEntity)
        return Result.LogicalResult()
    }
}