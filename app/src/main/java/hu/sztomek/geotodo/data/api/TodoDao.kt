package hu.sztomek.geotodo.data.api

import hu.sztomek.geotodo.data.model.TodoDbModel
import io.objectbox.Box
import io.objectbox.BoxStore

class TodoDao(boxStore: BoxStore) : BaseDao<TodoDbModel, DaoQuery.TodoQuery> {

    private val box: Box<TodoDbModel> = boxStore.boxFor(TodoDbModel::class.java)

    override fun list(query: DaoQuery.TodoQuery): List<TodoDbModel> {
        return box.query()
                .filter {
                    if (query.descriptionFilter == null) true else it.description.contains(query.descriptionFilter)
                }
                .build()
                .find(query.skip.toLong(), query.size.toLong())
    }

    override fun save(model: TodoDbModel): Long {
        return box.put(model)
    }

    override fun delete(id: Long) {
        return box.remove(id)
    }
}