package hu.sztomek.geotodo.domain.mvp.category.list

import hu.sztomek.geotodo.domain.action.Action
import hu.sztomek.geotodo.domain.mvp.common.MvpPresenter
import hu.sztomek.geotodo.domain.mvp.common.MvpView
import hu.sztomek.geotodo.domain.usecase.category.ListCategoryUseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import timber.log.Timber
import javax.inject.Inject

class CategoryListPresenter @Inject constructor(
        private val listCategoryUseCase: ListCategoryUseCase
) : MvpPresenter<MvpView> {

    private var view: MvpView? = null

    override fun takeView(view: MvpView) {
        this.view = view
    }

    fun onAction(action: Action) {
        when (action) {
            is Action.ListCategoryAction -> {
                launch(UI) {
                    try {
                        val result = async(CommonPool) {
                            listCategoryUseCase.execute(action)
                        }.await()
                        view?.operationSuccessful(action, result)
                    } catch (e: Exception) {
                        Timber.d(e)
                        view?.operationFailed(action, e)
                    }
                }
            }
        }
    }
}