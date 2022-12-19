package az.khayalsharifli.noteapp.presentation.content.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.domain.usecase.addNote.AddNoteUseCase
import kotlinx.coroutines.launch

class AddNoteViewModel(private val useCase: AddNoteUseCase) : ViewModel() {

    fun insertNote(note: Note) = viewModelScope.launch {
        useCase.insertNote(note)
    }
}