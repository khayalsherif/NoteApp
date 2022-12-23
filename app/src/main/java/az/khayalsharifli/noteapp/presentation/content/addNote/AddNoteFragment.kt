package az.khayalsharifli.noteapp.presentation.content.addNote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import az.khayalsharifli.noteapp.R
import az.khayalsharifli.noteapp.base.BaseFragment
import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.databinding.FragmentAddNoteBinding
import az.khayalsharifli.noteapp.presentation.enum.From
import az.khayalsharifli.noteapp.tools.gone
import az.khayalsharifli.noteapp.tools.hideKeyboard
import az.khayalsharifli.noteapp.tools.showKeyboard
import kotlin.reflect.KClass

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>() {

    override val bindingCallBack: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAddNoteBinding
        get() = FragmentAddNoteBinding::inflate
    override val kClass: KClass<AddNoteViewModel>
        get() = AddNoteViewModel::class

    private val args: AddNoteFragmentArgs by navArgs()

    override val bindViews: FragmentAddNoteBinding.() -> Unit = {
        navBack.setOnClickListener {
            findNavController().popBackStack()
        }

        when (args.from) {
            From.ADD -> addNoteMode()
            From.DETAIL -> viewDetailMode()
        }
    }

    private fun addNoteMode() {
        // Open keyboard and focus header text
        binding.textTitle.requestFocus()
        showKeyboard()

        binding.button.setOnClickListener {
            val header = binding.textTitle.text.toString()
            val body = binding.textBody.text.toString()
            if (header == "" || body == "") {
                showToast(getString(R.string.complete_error_message))
            } else {
                hideKeyboard()
                viewModel.insertNote(Note(title = header, body = body))
                showToast(getString(R.string.note_saved))
                it.isEnabled = false
            }
        }
    }

    private fun viewDetailMode() {
        binding.textTitle.setText(args.note?.title!!)
        binding.textBody.setText(args.note?.body!!)
        binding.textTitle.isEnabled = false
        binding.textBody.isEnabled = false
        binding.button.gone()
    }
}