package com.dumdumbich.curator.ui.pages.tables.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    var itemLongClickListener: ((V) -> Boolean)?
    fun bindView(view: V)
    fun getCount(): Int
}