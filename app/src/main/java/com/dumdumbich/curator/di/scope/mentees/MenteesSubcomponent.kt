package com.dumdumbich.curator.di.scope.mentees

import com.dumdumbich.curator.di.scope.mentees.module.MenteesModule
import com.dumdumbich.curator.ui.pages.mentee.MenteePresenter
import com.dumdumbich.curator.ui.pages.mentees.MenteesPresenter
import com.dumdumbich.curator.ui.pages.mentees.list.MenteesRVAdapter
import dagger.Subcomponent


@MenteesScope
@Subcomponent(
    modules = [
        MenteesModule::class
    ]
)
interface MenteesSubcomponent {

    fun inject(menteesPresenter: MenteesPresenter)
    fun inject(menteesRVAdapter: MenteesRVAdapter)
    fun inject(menteePresenter: MenteePresenter)
}