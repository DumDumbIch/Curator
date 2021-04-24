package com.dumdumbich.curator.ui.pages.tables

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface ITablesView : MvpView {
    fun init()
    fun updateList()
}