package com.dumdumbich.curator.ui.pages.tables

import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.dumdumbich.curator.R
import com.dumdumbich.curator.databinding.FragmentTablesBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.pages.PageFragment
import com.dumdumbich.curator.ui.pages.tables.list.TablesRVAdapter
import com.dumdumbich.curator.utils.debug.DEBUG_TablesFragment
import moxy.ktx.moxyPresenter


class TablesFragment : PageFragment(), ITablesView {

    companion object {
        fun newInstance() = TablesFragment()
    }

    private val presenter by moxyPresenter {
        TablesPresenter().apply {
            App.instance.initTablesSubcomponent().inject(this)
        }
    }

    private var ui: FragmentTablesBinding? = null
    private var adapter: TablesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTablesBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        debugMessage(DEBUG_TablesFragment, "TablesFragment(): init()")
        ui?.rvTables?.layoutManager = LinearLayoutManager(requireContext())
        adapter = TablesRVAdapter(presenter.tablesListPresenter).apply {
            App.instance.appComponent.tablesSubcomponent().inject(this)
        }
        ui?.rvTables?.adapter = adapter
        ui?.rvTables?.let { registerForContextMenu(it) }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun isBackPressed(): Boolean = presenter.closeScreen()

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        debugMessage(DEBUG_TablesFragment, "TablesFragment(): onCreateContextMenu()")
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = MenuInflater(requireContext())
        inflater.inflate(R.menu.menu_context_tables, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        debugMessage(DEBUG_TablesFragment, "TablesFragment(): onContextItemSelected")
        val result = true
        when (item.itemId) {
            R.id.mi_tables_add -> presenter.itemAdd()
            R.id.mi_tables_delete -> presenter.itemDelete()
            R.id.mi_tables_edit -> presenter.itemEdit()
            R.id.mi_tables_update -> presenter.itemUpdate()
            else -> false
        }
        return result
    }

}