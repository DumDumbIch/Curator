package com.dumdumbich.curator.ui.navigator

import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.domain.interactor.IFeedBack
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun mentees(): Screen
    fun mentee(mentee: Mentee): Screen
    fun about(): Screen
    fun tables(): Screen
    fun feedback(feedback: IFeedBack, message: String): Screen
}