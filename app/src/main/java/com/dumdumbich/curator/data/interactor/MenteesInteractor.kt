package com.dumdumbich.curator.data.interactor

import com.dumdumbich.curator.domain.entity.contact.CompanyContactInfo
import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.domain.interactor.IMenteesInteractor
import com.dumdumbich.curator.utils.debug.DEBUG_MenteesInteractor
import com.dumdumbich.curator.utils.debug.IDebug
import io.reactivex.rxjava3.core.Single

class MenteesInteractor : IMenteesInteractor, IDebug {

    override fun getMentees(): Single<List<Mentee>> = Single.fromCallable {
        debugMessage(DEBUG_MenteesInteractor, "MenteesInteractor(): getMentees()")
        listOf(
            Mentee(CompanyContactInfo("Umbrella")),
            Mentee(CompanyContactInfo("Рога и копыта")),
            Mentee(CompanyContactInfo("Шарашкина контора")),
        )
    }

}