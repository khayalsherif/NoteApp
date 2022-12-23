package az.khayalsharifli.noteapp.presentation.content.noteList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import az.khayalsharifli.noteapp.base.BaseFragment
import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.databinding.FragmentNoteListBinding
import az.khayalsharifli.noteapp.presentation.adapter.NoteAdapter
import az.khayalsharifli.noteapp.presentation.adapter.SwipeToDelete
import az.khayalsharifli.noteapp.presentation.enum.From
import az.khayalsharifli.noteapp.tools.ClickListener
import az.khayalsharifli.noteapp.tools.SwipeListener
import az.khayalsharifli.noteapp.tools.gone
import az.khayalsharifli.noteapp.tools.visible
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class NoteListFragment : BaseFragment<FragmentNoteListBinding, NoteListViewModel>(), ClickListener,
    SwipeListener {

    override val bindingCallBack: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNoteListBinding
        get() = FragmentNoteListBinding::inflate
    override val kClass: KClass<NoteListViewModel>
        get() = NoteListViewModel::class

    private val noteAdapter by lazy { NoteAdapter(this, this) }
    private lateinit var noteList: List<Note>

    override val bindViews: FragmentNoteListBinding.() -> Unit = {
        integrationRcView()

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(
                NoteListFragmentDirections.actionNoteFragmentToAddNoteFragment(from = From.ADD)
            )
        }

        binding.buttonRemoveAllNote.setOnClickListener {
            viewModel.deleteAllNotes()
        }

        lifecycleScope.launch {
            viewModel.notes.collect {
                if (it.isEmpty()) {
                    layoutEmptyFolder.visible()
                } else {
                    layoutEmptyFolder.gone()
                    noteList = it
                    noteAdapter.setData(it)
                }
            }
        }
    }

    private fun integrationRcView() {
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = noteAdapter
        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(noteAdapter))
        itemTouchHelper.attachToRecyclerView(binding.rcView)
    }

    override fun onClick(view: View, position: Int) {
        findNavController().navigate(
            NoteListFragmentDirections.actionNoteFragmentToAddNoteFragment(
                from = From.DETAIL,
                note = noteList[position]
            )
        )
    }

    override fun onSwipe(view: View, position: Int) {
        viewModel.deleteNote(noteList[position].id)
    }

}