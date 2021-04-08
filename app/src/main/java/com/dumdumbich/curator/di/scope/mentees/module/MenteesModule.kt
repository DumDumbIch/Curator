package com.dumdumbich.curator.di.scope.mentees.module

import com.dumdumbich.curator.data.interactor.MenteesInteractor
import com.dumdumbich.curator.di.scope.mentees.IMenteesScopeContainer
import com.dumdumbich.curator.di.scope.mentees.MenteesScope
import com.dumdumbich.curator.domain.interactor.IMenteesInteractor
import com.dumdumbich.curator.ui.App
import dagger.Module
import dagger.Provides

@Module
class MenteesModule {

    @MenteesScope
    @Provides
    fun getMentees(): IMenteesInteractor = MenteesInteractor()

    @MenteesScope
    @Provides
    fun menteesScopeContainer(app: App): IMenteesScopeContainer = app

}