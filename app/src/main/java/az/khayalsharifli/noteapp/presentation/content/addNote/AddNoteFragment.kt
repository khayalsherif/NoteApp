package az.khayalsharifli.noteapp.presentation.content.addNote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import az.khayalsharifli.noteapp.R
import az.khayalsharifli.noteapp.base.BaseFragment
import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.databinding.FragmentAddNoteBinding
import az.khayalsharifli.noteapp.tools.hideKeyboard
import az.khayalsharifli.noteapp.tools.showKeyboard
import kotlin.reflect.KClass

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>() {

    override val bindingCallBack: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAddNoteBinding
        get() = FragmentAddNoteBinding::inflate
    override val kClass: KClass<AddNoteViewModel>
        get() = AddNoteViewModel::class

    override val bindViews: FragmentAddNoteBinding.() -> Unit = {

        // Open keyboard and focus header text
        binding.textTitle.requestFocus()
        showKeyboard()

        binding.button.setOnClickListener {
            val header = textTitle.text.toString()
            val body = textBody.text.toString()
            if (header == "" || body == "") {
                showToast(getString(R.string.complete_error_message))
            } else {
                hideKeyboard()
                viewModel.insertNote(Note(title = header, body = body))
                showToast(getString(R.string.note_saved))
            }
        }

        navBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}