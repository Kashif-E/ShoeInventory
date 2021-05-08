package io.intelligible.shoeinventory.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.intelligible.shoeinventory.R
import io.intelligible.shoeinventory.databinding.HolderShoeDetailsBinding
import io.intelligible.shoeinventory.model.ShoeModel


class ShoeRecyclerViewAdapter : RecyclerView.Adapter<ShoeRecyclerViewAdapter.ShoeViewHolder> (){





    inner class ShoeViewHolder(private val itemViewBinding: HolderShoeDetailsBinding): RecyclerView.ViewHolder(
        itemViewBinding.root
    ) {

        fun bindView(shoeItem: ShoeModel) {
            itemViewBinding.apply {
              shoe = shoeItem
            }

            itemViewBinding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(shoeItem)

                }
            }
        }
    }

    private val differCallBack  = object : DiffUtil.ItemCallback<ShoeModel>()
    {

        override fun areItemsTheSame(oldItem: ShoeModel, newItem:ShoeModel): Boolean {
            return  oldItem.shoeId == newItem.shoeId
        }

        override fun areContentsTheSame(oldItem: ShoeModel, newItem: ShoeModel): Boolean {
            return  oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder{
        return ShoeViewHolder(

            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.holder_shoe_details, parent, false
            )
        )
    }

    private var onItemClickListener: ((ShoeModel) -> Unit)? = null
    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {

        val movieItem= differ.currentList[position]
        holder.bindView(movieItem)
    }




    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    fun setOnItemClickListener(listener: (ShoeModel) -> Unit) {
        onItemClickListener = listener

    }
}