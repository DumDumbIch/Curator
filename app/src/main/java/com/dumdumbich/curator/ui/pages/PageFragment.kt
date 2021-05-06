package com.dumdumbich.curator.ui.pages

import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.utils.debug.IDebug
import moxy.MvpAppCompatFragment

abstract class PageFragment : MvpAppCompatFragment(), IBackClickListener, IDebug {}