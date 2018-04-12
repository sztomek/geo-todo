package hu.sztomek.geotodo.domain.usecase.category

import hu.sztomek.geotodo.domain.action.Action
import hu.sztomek.geotodo.domain.action.Result
import hu.sztomek.geotodo.domain.data.DataSource
import hu.sztomek.geotodo.domain.model.CategoryEntity
import hu.sztomek.geotodo.domain.usecase.BaseUseCase
import javax.inject.Inject

class SaveCategoryUseCase @Inject constructor(
        private val dataSource: DataSource
) : BaseUseCase<Action.SaveCategoryAction, Result.SingleResult<CategoryEntity>> {

    override suspend fun execute(action: Action.SaveCategoryAction): Result.SingleResult<CategoryEntity> {
        val categoryId = dataSource.saveCategory(action.categoryEntity)
        return Result.SingleResult(action.categoryEntity.copy(id = categoryId))
    }
}