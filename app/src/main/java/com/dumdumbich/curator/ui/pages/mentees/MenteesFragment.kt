package com.dumdumbich.curator.ui.pages.mentees

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dumdumbich.curator.databinding.FragmentMenteesBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.LOG_D_TAG
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.ui.pages.mentees.list.MenteesRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MenteesFragment : MvpAppCompatFragment(), IMenteesView, IBackClickListener {

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
        Log.d(LOG_D_TAG, "MenteesFragment(): onCreateView()")
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        Log.d(LOG_D_TAG, "MenteesFragment(): init()")
        ui?.rvMentees?.layoutManager = LinearLayoutManager(requireContext())
        adapter = MenteesRVAdapter(presenter.menteesListPresenter).apply {
            App.instance.appComponent.menteesSubcomponent().inject(this)
        }
        ui?.rvMentees?.adapter = adapter
    }

    override fun updateList() {
        Log.d(LOG_D_TAG, "MenteesFragment(): updateList()")
        adapter?.notifyDataSetChanged()
    }

    override fun isBackPressed(): Boolean = presenter.backClick()

}