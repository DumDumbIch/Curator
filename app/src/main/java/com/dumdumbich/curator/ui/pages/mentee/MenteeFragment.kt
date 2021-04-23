package com.dumdumbich.curator.ui.pages.mentee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dumdumbich.curator.databinding.FragmentMenteeBinding
import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.utils.debug.DEBUG_MenteeFragment
import com.dumdumbich.curator.utils.debug.IDebug
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MenteeFragment : MvpAppCompatFragment(), IMenteeView, IBackClickListener, IDebug {

    companion object {
        private const val MENTEE_ARG = "mentee"

        fun newInstance(mentee: Mentee) = MenteeFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MENTEE_ARG, mentee)
            }
        }
    }

    private val presenter by moxyPresenter {
        val mentee = arguments?.getParcelable<Mentee>(MENTEE_ARG) as Mentee
        MenteePresenter(mentee).apply {
            App.instance.menteesSubcomponent?.inject(this)
        }
    }

    private var ui: FragmentMenteeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentMenteeBinding.inflate(inflater, container, false).also {
            ui = it
            debugMessage(DEBUG_MenteeFragment, "MenteeFragment(): onCreateView()")
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun setMenteeName(text: String) {
        ui?.tvMenteeName?.text = text
    }

    override fun isBackPressed(): Boolean = presenter.closeScreen()

}