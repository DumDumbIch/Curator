package com.dumdumbich.curator.ui.pages.tables

import com.dumdumbich.curator.di.scope.tables.ITablesScopeContainer
import com.dumdumbich.curator.domain.entity.database.Table
import com.dumdumbich.curator.domain.interactor.ITablesInteractor
import com.dumdumbich.curator.ui.pages.PagePresenter
import com.dumdumbich.curator.ui.pages.tables.list.ITableItemView
import com.dumdumbich.curator.ui.pages.tables.list.ITablesListPresenter
import com.dumdumbich.curator.utils.debug.DEBUG_TablesPresenter
import com.dumdumbich.curator.utils.debug.IDebug
import javax.inject.Inject


class TablesPresenter : PagePresenter<ITablesView>() {

    @Inject
    lateinit var tablesScopeContainer: ITablesScopeContainer

    @Inject
    lateinit var interactor: ITablesInteractor


    class TablesListPresenter : ITablesListPresenter, IDebug {

        val tables = mutableListOf<Table>()
        override var itemClickListener: ((ITableItemView) -> Unit)? = null
        override var itemLongClickListener: ((ITableItemView) -> Boolean)? = null

        override fun bindView(view: ITableItemView) {
            val table = tables[view.pos]
            view.setTitle(table.title)
        }

        override fun getCount(): Int = tables.size

        fun itemAdd() {
            debugMessage(
                DEBUG_TablesPresenter,
                "TablesPresenter : TablesListPresenter(): itemAdd()"
            )
        }

        fun itemDelete() {
            debugMessage(
                DEBUG_TablesPresenter,
                "TablesPresenter : TablesListPresenter(): itemDelete()"
            )
        }

        fun itemEdit() {
            debugMessage(
                DEBUG_TablesPresenter,
                "TablesPresenter : TablesListPresenter(): itemEdit()"
            )
        }

        fun itemUpdate() {
            debugMessage(
                DEBUG_TablesPresenter,
                "TablesPresenter : TablesListPresenter(): itemUpdate()"
            )
        }

    }


    val tablesListPresenter = TablesListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        tablesListPresenter.itemClickListener = { itemView ->
            val table = tablesListPresenter.tables[itemView.pos]
            debugMessage(
                DEBUG_TablesPresenter,
                "TablesPresenter(): onFirstViewAttach() - tablesListPresenter.itemClickListener: table = ${table.title}"
            )
        }
        tablesListPresenter.itemLongClickListener = { itemView ->
            val table = tablesListPresenter.tables[itemView.pos]
            debugMessage(
                DEBUG_TablesPresenter,
                "TablesPresenter(): onFirstViewAttach() - tablesListPresenter.itemLongClickListener: table = ${table.title}"
            )
            false
        }
    }

    private fun loadData() {
        tablesListPresenter.tables.clear()
        interactor.getTables()
            .observeOn(uiScheduler)
            .subscribe(
                { table ->
                    tablesListPresenter.tables.addAll(table)
                    viewState.updateList()
                },
                { error ->
                    error.printStackTrace()
                }
            )
    }

    override fun onDestroy() {
        tablesScopeContainer.releaseTablesScope()
        super.onDestroy()
    }

    fun itemAdd() {
        tablesListPresenter.itemAdd()
    }

    fun itemDelete() {
        tablesListPresenter.itemDelete()
    }

    fun itemEdit() {
        tablesListPresenter.itemEdit()
    }

    fun itemUpdate() {
        tablesListPresenter.itemUpdate()
    }

}