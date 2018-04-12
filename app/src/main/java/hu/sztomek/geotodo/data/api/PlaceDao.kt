package hu.sztomek.geotodo.data.api

import hu.sztomek.geotodo.data.model.PlaceDbModel
import io.objectbox.Box
import io.objectbox.BoxStore

class PlaceDao(boxStore: BoxStore) : BaseDao<PlaceDbModel, DaoQuery.PlaceQuery> {

    private val box: Box<PlaceDbModel> = boxStore.boxFor(PlaceDbModel::class.java)

    override fun list(query: DaoQuery.PlaceQuery): List<PlaceDbModel> {
        return box.query()
                .filter {
                    if (query.nameFilter == null) true else it.name.contains(query.nameFilter)
                }
                .build()
                .find(query.skip.toLong(), query.size.toLong())
    }

    override fun save(model: PlaceDbModel): Long {
        return box.put(model)
    }

    override fun delete(id: Long) {
        box.remove(id)
    }
}