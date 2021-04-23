package com.dumdumbich.curator.di.scope.tables.module

import com.dumdumbich.curator.data.interactor.TablesInteractor
import com.dumdumbich.curator.di.scope.tables.TablesScope
import com.dumdumbich.curator.di.scope.tables.ITablesScopeContainer
import com.dumdumbich.curator.domain.interactor.ITablesInteractor
import com.dumdumbich.curator.ui.App
import dagger.Module
import dagger.Provides


@Module
class TablesModule {

    @TablesScope
    @Provides
    fun getTables(): ITablesInteractor = TablesInteractor()

    @TablesScope
    @Provides
    fun tablesScopeContainer(app: App): ITablesScopeContainer = app

}