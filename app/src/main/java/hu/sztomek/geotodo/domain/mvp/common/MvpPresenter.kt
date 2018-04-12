package hu.sztomek.geotodo.domain.mvp.common

interface MvpPresenter<in V: MvpView> {

    fun takeView(view: V)

}