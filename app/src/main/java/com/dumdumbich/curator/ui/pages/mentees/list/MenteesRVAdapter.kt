package com.dumdumbich.curator.ui.pages.mentees.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dumdumbich.curator.databinding.FragmentMenteesItemBinding

class MenteesRVAdapter(
    private val presenter: IMenteesListPresenter,
//    val imageLoader: IImageLoader<ImageView>
) :
    RecyclerView.Adapter<MenteesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            FragmentMenteesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()


    inner class ViewHolder(private val ui: FragmentMenteesItemBinding) :
        RecyclerView.ViewHolder(ui.root),
        IMenteeItemView {

        override var pos = -1

        override fun setName(text: String) = with(ui) {
            tvMenteeName.text = text
        }

//        override fun loadLogo(url: String)  = with(ui) {
//            imageLoader.load(url, ivLogo)
//        }
    }

}