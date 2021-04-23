package com.dumdumbich.curator.ui.pages.mentees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dumdumbich.curator.databinding.FragmentMenteesBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.ui.pages.mentees.list.MenteesRVAdapter
import com.dumdumbich.curator.utils.debug.DEBUG_MenteesFragment
import com.dumdumbich.curator.utils.debug.IDebug
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MenteesFragment : MvpAppCompatFragment(), IMenteesView, IBackClickListener, IDebug {

    companion object {
        fun newInstance() = MenteesFragment()
    }

    private val presenter by moxyPresenter {
        MenteesPresenter().apply {
            App.instance.initMenteesSubcomponent().inject(this)
        }
    }

    private var ui: FragmentMenteesBinding? = null
    private var adapter: MenteesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMenteesBinding.inflate(inflater, container, false).also {
        ui = it
        debugMessage(DEBUG_MenteesFragment, "MenteesFragment(): onCreateView()")
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        debugMessage(DEBUG_MenteesFragment, "MenteesFragment(): init()")
        ui?.rvMentees?.layoutManager = LinearLayoutManager(requireContext())
        adapter = MenteesRVAdapter(presenter.menteesListPresenter).apply {
            App.instance.appComponent.menteesSubcomponent().inject(this)
        }
        ui?.rvMentees?.adapter = adapter
    }

    override fun updateList() {
        debugMessage(DEBUG_MenteesFragment, "MenteesFragment(): updateList()")
        adapter?.notifyDataSetChanged()
    }

    override fun isBackPressed(): Boolean = presenter.closeScreen()

}