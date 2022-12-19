package az.khayalsharifli.noteapp.presentation.content.noteList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import az.khayalsharifli.noteapp.R
import az.khayalsharifli.noteapp.base.BaseFragment
import az.khayalsharifli.noteapp.databinding.FragmentNoteListBinding
import az.khayalsharifli.noteapp.presentation.adapter.NoteAdapter
import az.khayalsharifli.noteapp.tools.gone
import az.khayalsharifli.noteapp.tools.visible
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class NoteListFragment : BaseFragment<FragmentNoteListBinding, NoteListViewModel>() {

    override val bindingCallBack: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNoteListBinding
        get() = FragmentNoteListBinding::inflate
    override val kClass: KClass<NoteListViewModel>
        get() = NoteListViewModel::class

    private val noteAdapter by lazy { NoteAdapter() }

    override val bindViews: FragmentNoteListBinding.() -> Unit = {
        integrationRcView()

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_addNoteFragment)
        }

        lifecycleScope.launch {
            viewModel.notes.collect {
                if (it.isEmpty()) {
                    layoutEmptyFolder.visible()
                } else {
                    layoutEmptyFolder.gone()
                    noteAdapter.setData(it)
                }
            }
        }
    }

    private fun integrationRcView() {
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = noteAdapter
    }

}