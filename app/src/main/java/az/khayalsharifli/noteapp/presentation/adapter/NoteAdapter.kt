package az.khayalsharifli.noteapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import az.khayalsharifli.noteapp.base.BaseDiffUtil
import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.databinding.ItemNoteBinding
import az.khayalsharifli.noteapp.tools.ClickListener
import az.khayalsharifli.noteapp.tools.SwipeListener

class NoteAdapter(private val clickListener: ClickListener, val onSwipeListener: SwipeListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var emptyList = emptyList<Note>()

    class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): NoteViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNoteBinding.inflate(layoutInflater, parent, false)
                return NoteViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder.from(parent = parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.textTitle.text = emptyList[position].title
        holder.binding.textBody.text = emptyList[position].body
        holder.binding.root.setOnClickListener {
            clickListener.onClick(it, position)
        }
    }

    override fun getItemCount() = emptyList.size

    fun setData(newList: List<Note>) {
        val diffUtil = BaseDiffUtil(emptyList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        emptyList = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }
}