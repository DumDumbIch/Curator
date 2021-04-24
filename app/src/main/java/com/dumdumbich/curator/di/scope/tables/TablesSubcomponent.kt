package com.dumdumbich.curator.di.scope.tables

import com.dumdumbich.curator.di.scope.tables.module.TablesModule
import com.dumdumbich.curator.ui.pages.tables.TablesPresenter
import com.dumdumbich.curator.ui.pages.tables.list.TablesRVAdapter
import dagger.Subcomponent


@TablesScope
@Subcomponent(
    modules = [
        TablesModule::class
    ]
)
interface TablesSubcomponent {

    fun inject(tablesPresenter: TablesPresenter)
    fun inject(tablesRVAdapter: TablesRVAdapter)
}