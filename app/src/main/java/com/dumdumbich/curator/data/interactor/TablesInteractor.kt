package com.dumdumbich.curator.data.interactor

import com.dumdumbich.curator.domain.entity.database.Table
import com.dumdumbich.curator.domain.interactor.ITablesInteractor
import com.dumdumbich.curator.utils.debug.DEBUG_TablesInteractor
import com.dumdumbich.curator.utils.debug.IDebug
import io.reactivex.rxjava3.core.Single

class TablesInteractor : ITablesInteractor, IDebug {

    override fun getTables(): Single<List<Table>> = Single.fromCallable {
        debugMessage(DEBUG_TablesInteractor, "TablesInteractor(): getTables()")
        listOf(
            Table("Mentees", "", 0),
            Table("Curators", "", 0),
            Table("Aborigines", "", 0),
        )
    }

}