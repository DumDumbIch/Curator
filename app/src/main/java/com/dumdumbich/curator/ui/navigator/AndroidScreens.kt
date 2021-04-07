package com.dumdumbich.curator.ui.navigator

import com.dumdumbich.curator.ui.pages.mentees.MenteesFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens  {
    override fun mentees(): Screen  = FragmentScreen { MenteesFragment.newInstance() }

}