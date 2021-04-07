package com.dumdumbich.curator.ui.pages.mentees

import com.dumdumbich.curator.domain.entity.Mentee
import com.dumdumbich.curator.ui.navigator.IScreens
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteeItemView
import com.dumdumbich.curator.ui.pages.mentees.list.IMenteesListPresenter
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class MenteesPresenter(
    private val router: Router,
    private val screens: IScreens,
    private val uiScheduler: Scheduler
) : MvpPresenter<IMenteesView>() {

    class MenteesListPresenter : IMenteesListPresenter {

        val mentees = mutableListOf<Mentee>()

        override var itemClickListener: ((IMenteeItemView) -> Unit)? = null

        override fun bindView(view: IMenteeItemView) {
            val mentee = mentees[view.pos]
            view.setName(mentee.name)
//            view.loadLogo(mentee.logoUrl)
        }

        override fun getCount() = mentees.size

    }

    private val compositeDisposable = CompositeDisposable()
    val menteesListPresenter = MenteesListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}