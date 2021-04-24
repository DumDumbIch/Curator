package com.dumdumbich.curator.ui.navigator

import com.dumdumbich.curator.domain.entity.hero.Mentee
import com.dumdumbich.curator.ui.pages.about.AboutFragment
import com.dumdumbich.curator.ui.pages.mentee.MenteeFragment
import com.dumdumbich.curator.ui.pages.mentees.MenteesFragment
import com.dumdumbich.curator.ui.pages.tables.TablesFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


class AndroidScreens : IScreens {

    override fun mentees(): Screen = FragmentScreen { MenteesFragment.newInstance() }
    override fun mentee(mentee: Mentee): Screen = FragmentScreen { MenteeFragment.newInstance(mentee) }
    override fun about(): Screen = FragmentScreen { AboutFragment.newInstance() }
    override fun tables(): Screen = FragmentScreen { TablesFragment.newInstance() }

}