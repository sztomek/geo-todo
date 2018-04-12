package hu.sztomek.geotodo.domain.usecase.category

import hu.sztomek.geotodo.domain.action.Action
import hu.sztomek.geotodo.domain.action.Result
import hu.sztomek.geotodo.domain.data.DataSource
import hu.sztomek.geotodo.domain.data.ListRequest
import hu.sztomek.geotodo.domain.model.CategoryEntity
import hu.sztomek.geotodo.domain.usecase.BaseUseCase
import javax.inject.Inject

class ListCategoryUseCase @Inject constructor(
        private val dataSource: DataSource
) : BaseUseCase<Action.ListCategoryAction, Result.ListResult<CategoryEntity>> {

    override suspend fun execute(action: Action.ListCategoryAction): Result.ListResult<CategoryEntity> {
        val categories = dataSource.listCategories(
                ListRequest.CategoryListRequest(
                        action.descriptionFilter,
                        action.page,
                        action.size
                )
        )
        return Result.ListResult(categories)
    }
}