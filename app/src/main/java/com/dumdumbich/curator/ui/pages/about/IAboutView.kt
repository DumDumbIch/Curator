package com.dumdumbich.curator.ui.pages.about

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IAboutView : MvpView {
    fun init()
}