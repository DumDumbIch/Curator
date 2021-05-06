package com.dumdumbich.curator.ui.pages.mentees

import com.dumdumbich.curator.di.scope.mentees.IMenteesScopeContainer
import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.domain.interactor.IMenteesInteractor
import com.dumdumbich.curator.ui.pages.PagePresenter
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteeItemView
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteesListPresenter
import com.dumdumbich.curator.utils.debug.DEBUG_MenteesPresenter
import javax.inject.Inject

class MenteesPresenter : PagePresenter<IMenteesView>(){

    @Inject
    lateinit var menteesScopeContainer: IMenteesScopeContainer

    @Inject
    lateinit var interactor: IMenteesInteractor


    class MenteesListPresenter : IMenteesListPresenter {

        val mentees = mutableListOf<Mentee>()
        override var itemClickListener: ((IMenteeItemView) -> Unit)? = null

        override fun bindView(view: IMenteeItemView) {
            val mentee = mentees[view.pos]
            view.setName(mentee.contactInfo.name)
//            view.loadLogo(mentee.logoUrl)
        }

        override fun getCount() = mentees.size

    }


    val menteesListPresenter = MenteesListPresenter()

    override fun onFirstViewAttach() {
        debugMessage(DEBUG_MenteesPresenter, "MenteesPresenter(): onFirstViewAttach()")
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        menteesListPresenter.itemClickListener = { itemView ->
            debugMessage(
                DEBUG_MenteesPresenter,
                "MenteesPresenter(): onFirstViewAttach() - menteesListPresenter.itemClickListener"
            )
            val mentee = menteesListPresenter.mentees[itemView.pos]
            router.navigateTo(screens.mentee(mentee))
        }
    }

    private fun loadData() {
        debugMessage(DEBUG_MenteesPresenter, "MenteesPresenter(): loadData()")
        menteesListPresenter.mentees.clear()
        interactor.getMentees()
            .observeOn(uiScheduler)
            .subscribe(
                { mentee ->
                    debugMessage(
                        DEBUG_MenteesPresenter,
                        "MenteesPresenter(): loadData() - subscribe success"
                    )
                    menteesListPresenter.mentees.addAll(mentee)
                    viewState.updateList()
                },
                { error ->
                    debugMessage(
                        DEBUG_MenteesPresenter,
                        "MenteesPresenter(): loadData() - subscribe error"
                    )
                    error.printStackTrace()
                }
            )
    }

    override fun onDestroy() {
        menteesScopeContainer.releaseMenteesScope()
        super.onDestroy()
    }

}