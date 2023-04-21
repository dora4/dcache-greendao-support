package dora.cache.holder

import dora.db.OrmLog
import dora.db.builder.Condition
import org.greenrobot.greendao.AbstractDao
import org.greenrobot.greendao.AbstractDaoSession

class GreenDaoListCacheHolder<T>(var session: AbstractDaoSession, var clazz: Class<T>) : ListCacheHolder<T>() {

    private lateinit var dao: AbstractDao<T, Long>

    override fun init() {
        dao = session.getDao(clazz) as AbstractDao<T, Long>
    }

    override fun queryCache(condition: Condition): MutableList<T>? {
        return session.callInTx {
            dao.queryRaw(condition.selection, *condition.selectionArgs)
        }
    }

    override fun removeOldCache(condition: Condition) {
        try {
            dao.deleteInTx(queryCache(condition))
            OrmLog.d("removeOldCache:true")
        } catch (e: Exception) {
            OrmLog.d("removeOldCache:false")
        }
    }

    override fun addNewCache(models: MutableList<T>) {
        try {
            dao.insertInTx(models)
            OrmLog.d("addNewCache:true")
        } catch (e: Exception) {
            OrmLog.d("addNewCache:false")
        }
    }

    override fun queryCacheSize(condition: Condition): Long {
        return session.callInTx {
            dao.count()
        }
    }
}