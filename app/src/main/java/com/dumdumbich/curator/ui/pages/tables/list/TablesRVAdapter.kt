package com.dumdumbich.curator.ui.pages.tables.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dumdumbich.curator.databinding.FragmentTablesItemBinding


class TablesRVAdapter(
    private val presenter: ITablesListPresenter
) : RecyclerView.Adapter<TablesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            FragmentTablesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
            itemView.setOnLongClickListener { presenter.itemLongClickListener?.invoke(this) ?: false }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount(): Int = presenter.getCount()


    inner class ViewHolder(private val ui: FragmentTablesItemBinding) :
        RecyclerView.ViewHolder(ui.root), ITableItemView {

        override var pos: Int = -1

        override fun setTitle(text: String) = with(ui) {
            tvTablesName.text = text
        }

    }

}