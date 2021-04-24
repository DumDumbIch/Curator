package com.dumdumbich.curator.ui.pages.tables

import com.dumdumbich.curator.di.scope.tables.ITablesScopeContainer
import com.dumdumbich.curator.domain.entity.database.Table
import com.dumdumbich.curator.domain.interactor.ITablesInteractor
import com.dumdumbich.curator.ui.navigator.IScreens
import com.dumdumbich.curator.ui.pages.tables.list.ITableItemView
import com.dumdumbich.curator.ui.pages.tables.list.ITablesListPresenter
import com.dumdumbich.curator.utils.debug.DEBUG_TablesPresenter
import com.dumdumbich.curator.utils.debug.IDebug
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named


class TablesPresenter : MvpPresenter<ITablesView>(), IDebug {

    @Inject
    lateinit var tablesScopeContainer: ITablesScopeContainer

    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

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

        fun itemAdd(){
            debugMessage(DEBUG_TablesPresenter, "TablesPresenter : TablesListPresenter(): itemAdd()")
        }

        fun itemDelete(){
            debugMessage(DEBUG_TablesPresenter, "TablesPresenter : TablesListPresenter(): itemDelete()")
        }

        fun itemEdit(){
            debugMessage(DEBUG_TablesPresenter, "TablesPresenter : TablesListPresenter(): itemEdit()")
        }

        fun itemUpdate(){
            debugMessage(DEBUG_TablesPresenter, "TablesPresenter : TablesListPresenter(): itemUpdate()")
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

    fun closeScreen(): Boolean {
        router.exit()
        return true
    }

    fun itemAdd(){
        tablesListPresenter.itemAdd()
    }

    fun itemDelete(){
        tablesListPresenter.itemDelete()
    }

    fun itemEdit(){
        tablesListPresenter.itemEdit()
    }

    fun itemUpdate(){
        tablesListPresenter.itemUpdate()
    }


}