package com.dumdumbich.curator.domain.interactor

import com.dumdumbich.curator.domain.entity.database.Table
import io.reactivex.rxjava3.core.Single


interface ITablesInteractor {
    fun getTables(): Single<List<Table>>
}