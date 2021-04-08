package com.dumdumbich.curator.data.interactor

import android.util.Log
import com.dumdumbich.curator.domain.entity.CompanyContactInfo
import com.dumdumbich.curator.domain.entity.Mentee
import com.dumdumbich.curator.domain.interactor.IMenteesInteractor
import com.dumdumbich.curator.ui.LOG_D_TAG
import io.reactivex.rxjava3.core.Single

class MenteesInteractor : IMenteesInteractor {

    override fun getMentees(): Single<List<Mentee>> = Single.fromCallable {
        Log.d(LOG_D_TAG, "MenteesInteractor(): getMentees()")
        listOf(
            Mentee(CompanyContactInfo("Umbrella")),
            Mentee(CompanyContactInfo("Рога и копыта")),
            Mentee(CompanyContactInfo("Шарашкина контора")),
        )
    }

}