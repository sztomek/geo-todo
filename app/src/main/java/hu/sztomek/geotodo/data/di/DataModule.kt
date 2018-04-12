package hu.sztomek.geotodo.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.sztomek.geotodo.data.api.*
import hu.sztomek.geotodo.data.model.CategoryDbModel
import hu.sztomek.geotodo.data.model.MyObjectBox
import hu.sztomek.geotodo.data.model.PlaceDbModel
import hu.sztomek.geotodo.data.model.TodoDbModel
import io.objectbox.BoxStore

@Module
class DataModule {

    @Provides
    fun provideBoxStore(context: Context): BoxStore {
        return MyObjectBox.builder()
                .androidContext(context)
                .build()
    }

    @Provides
    fun provideCategoryDao(boxStore: BoxStore): BaseDao<CategoryDbModel, DaoQuery.CategoryQuery> {
        return CategoryDao(boxStore)
    }

    @Provides
    fun providePlaceDao(boxStore: BoxStore): BaseDao<PlaceDbModel, DaoQuery.PlaceQuery> {
        return PlaceDao(boxStore)
    }

    @Provides
    fun provideTodoDao(boxStore: BoxStore): BaseDao<TodoDbModel, DaoQuery.TodoQuery> {
        return TodoDao(boxStore)
    }

}