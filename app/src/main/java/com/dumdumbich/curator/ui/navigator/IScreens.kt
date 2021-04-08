package com.dumdumbich.curator.ui.navigator

import com.dumdumbich.curator.domain.entity.Mentee
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun mentees(): Screen
    fun mentee(mentee: Mentee): Screen
}