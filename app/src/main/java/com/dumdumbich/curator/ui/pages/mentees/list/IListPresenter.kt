package com.dumdumbich.curator.ui.pages.mentees.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}