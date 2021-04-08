package com.dumdumbich.curator.ui.pages.mentees

import android.util.Log
import com.dumdumbich.curator.di.scope.mentees.IMenteesScopeContainer
import com.dumdumbich.curator.domain.entity.Mentee
import com.dumdumbich.curator.domain.interactor.IMenteesInteractor
import com.dumdumbich.curator.ui.LOG_D_TAG
import com.dumdumbich.curator.ui.navigator.IScreens
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteeItemView
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteesListPresenter
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class MenteesPresenter : MvpPresenter<IMenteesView>() {

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
        Log.d(LOG_D_TAG, "MenteesPresenter(): onFirstViewAttach()")
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        menteesListPresenter.itemClickListener = { itemView ->
            Log.d(
                LOG_D_TAG,
                "MenteesPresenter(): onFirstViewAttach() - menteesListPresenter.itemClickListener"
            )
            val mentee = menteesListPresenter.mentees[itemView.pos]
            router.navigateTo(screens.mentee(mentee))
        }
    }

    private fun loadData() {
        Log.d(LOG_D_TAG, "MenteesPresenter(): loadData()")
        menteesListPresenter.mentees.clear()
        interactor.getMentees()
            .observeOn(uiScheduler)
            .subscribe(
                { mentee ->
                    Log.d(LOG_D_TAG, "MenteesPresenter(): loadData() - subscribe success")
                    menteesListPresenter.mentees.addAll(mentee)
                    viewState.updateList()
                },
                { error ->
                    Log.d(LOG_D_TAG, "MenteesPresenter(): loadData() - subscribe error")
                    error.printStackTrace()
                }
            )
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        menteesScopeContainer.releaseMenteesScope()
        super.onDestroy()
    }

}