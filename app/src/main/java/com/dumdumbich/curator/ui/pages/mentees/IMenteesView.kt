package com.dumdumbich.curator.ui.pages.mentees

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IMenteesView : MvpView {
    fun init()
    fun updateList()
}