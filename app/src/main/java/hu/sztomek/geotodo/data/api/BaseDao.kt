package hu.sztomek.geotodo.data.api

import hu.sztomek.geotodo.data.model.DbModel

interface BaseDao<M: DbModel, in Q: DaoQuery> {

    fun list(query: Q): List<M>
    fun save(model: M): Long
    fun delete(id: Long)

}