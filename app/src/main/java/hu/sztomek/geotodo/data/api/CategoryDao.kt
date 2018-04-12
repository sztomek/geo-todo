package hu.sztomek.geotodo.data.api

import hu.sztomek.geotodo.data.model.CategoryDbModel
import io.objectbox.Box
import io.objectbox.BoxStore

class CategoryDao(boxStore: BoxStore) : BaseDao<CategoryDbModel, DaoQuery.CategoryQuery> {

    private val box: Box<CategoryDbModel> = boxStore.boxFor(CategoryDbModel::class.java)

    override fun list(query: DaoQuery.CategoryQuery): List<CategoryDbModel> {
        return box.query()
                .filter {
                    if (query.nameFilter == null) true else it.title.contains(query.nameFilter)
                }
                .build()
                .find(query.skip.toLong(), query.size.toLong())
    }

    override fun save(model: CategoryDbModel): Long {
        return box.put(model)
    }

    override fun delete(id: Long) {
        return box.remove(id)
    }
}