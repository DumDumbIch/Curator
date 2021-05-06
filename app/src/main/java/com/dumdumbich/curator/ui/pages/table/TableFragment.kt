package com.dumdumbich.curator.ui.pages.table

import android.os.Bundle
import com.dumdumbich.curator.domain.entity.database.Table
import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.pages.PageFragment
import moxy.ktx.moxyPresenter


class TableFragment : PageFragment(), ITableView {

    companion object {
        private const val TABLE_ARG = "table"

        fun newInstance(table: Table) = TableFragment().apply {
            arguments = Bundle().apply {
                putParcelable(TABLE_ARG, table)
            }
        }
    }

    private val presenter by moxyPresenter {
        val table = arguments?.getParcelable<Table>(TABLE_ARG) as Mentee
        TablePresenter(table).apply {
            App.instance.tablesSubcomponent?.inject(this)
        }
    }

    override fun isBackPressed(): Boolean = presenter.closeScreen()

}