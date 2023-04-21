package dora.cache.repository

import android.content.Context
import dora.cache.holder.*
import org.greenrobot.greendao.AbstractDaoSession

abstract class GreenDaoDatabaseCacheRepository<T>(context: Context)
    : BaseDatabaseCacheRepository<T>(context) {

    override fun createCacheHolder(clazz: Class<T>): CacheHolder<T> {
        return GreenDaoCacheHolder<T>(getDaoSession(), clazz)
    }

    override fun createListCacheHolder(clazz: Class<T>): CacheHolder<MutableList<T>> {
        return GreenDaoListCacheHolder<T>(getDaoSession(), clazz)
    }

    abstract fun getDaoSession() : AbstractDaoSession
}