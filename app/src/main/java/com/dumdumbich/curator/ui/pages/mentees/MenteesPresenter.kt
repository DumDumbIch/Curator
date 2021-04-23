package com.dumdumbich.curator.ui.pages.mentees

import com.dumdumbich.curator.di.scope.mentees.IMenteesScopeContainer
import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.domain.interactor.IMenteesInteractor
import com.dumdumbich.curator.ui.navigator.IScreens
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteeItemView
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteesListPresenter
import com.dumdumbich.curator.utils.debug.DEBUG_MenteesPresenter
import com.dumdumbich.curator.utils.debug.IDebug
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class MenteesPresenter : MvpPresenter<IMenteesView>(), IDebug {

    @Inject
    lateinit var menteesScopeContainer: IMenteesScopeContainer

    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

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

    fun closeScreen(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        menteesScopeContainer.releaseMenteesScope()
        super.onDestroy()
    }

}