package com.dumdumbich.curator.ui.pages.mentee

import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.ui.pages.PagePresenter

class MenteePresenter(
    private val mentee: Mentee
) : PagePresenter<IMenteeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setMenteeName(mentee.contactInfo.name)
    }

}