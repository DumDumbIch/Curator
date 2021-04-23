package com.dumdumbich.curator.ui.pages.mentee

import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MenteePresenter(
    private val mentee: Mentee
) : MvpPresenter<IMenteeView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setMenteeName(mentee.contactInfo.name)
    }

    fun closeScreen(): Boolean {
        router.exit()
        return true
    }

}