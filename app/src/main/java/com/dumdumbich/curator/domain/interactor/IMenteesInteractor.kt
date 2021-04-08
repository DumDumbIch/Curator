package com.dumdumbich.curator.domain.interactor

import com.dumdumbich.curator.domain.entity.Mentee
import io.reactivex.rxjava3.core.Single

interface IMenteesInteractor {
    fun getMentees(): Single<List<Mentee>>
}