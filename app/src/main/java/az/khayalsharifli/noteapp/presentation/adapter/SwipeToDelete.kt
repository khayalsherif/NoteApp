package az.khayalsharifli.noteapp.presentation.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeToDelete(val adapter: NoteAdapter) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onSwipeListener.onSwipe(viewHolder.itemView, viewHolder.adapterPosition)
        adapter.notifyItemRemoved(viewHolder.adapterPosition)
    }

}