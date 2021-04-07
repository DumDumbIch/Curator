package com.dumdumbich.curator.ui.pages.mentees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dumdumbich.curator.databinding.FragmentMenteesBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.navigator.AndroidScreens
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.ui.pages.mentees.list.MenteesRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MenteesFragment : MvpAppCompatFragment(), IMenteesView, IBackClickListener {

    companion object {
        fun newInstance() = MenteesFragment()
    }

    private val presenter by moxyPresenter {
        MenteesPresenter(
            App.instance.router,
            AndroidScreens(),
            AndroidSchedulers.mainThread()
        )
    }

    private var ui: FragmentMenteesBinding? = null
    private var adapter: MenteesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentMenteesBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        ui?.rvMentees?.layoutManager=LinearLayoutManager(requireContext())
        adapter= MenteesRVAdapter(presenter.menteesListPresenter)
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun isBackPressed(): Boolean  = presenter.backClick()
    }
}