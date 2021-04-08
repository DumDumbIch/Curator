package com.dumdumbich.curator.ui.pages.mentee

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IMenteeView : MvpView {
    fun setMenteeName(text: String)
}