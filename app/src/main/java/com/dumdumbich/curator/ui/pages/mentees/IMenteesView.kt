package com.dumdumbich.curator.ui.pages.mentees

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IMenteesView : MvpView {
    fun init()
    fun updateList()
}