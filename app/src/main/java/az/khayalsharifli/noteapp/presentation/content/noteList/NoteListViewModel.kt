package az.khayalsharifli.noteapp.presentation.content.noteList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.domain.usecase.noteList.NoteListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NoteListViewModel(val useCase: NoteListUseCase) : ViewModel() {

    private var _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>>
        get() = _notes.asStateFlow()

    init {
        getAllNotes()
    }

    private fun getAllNotes() =
        viewModelScope.launch {
            useCase.observeAllNote().collect {
                _notes.emit(it)
            }
        }

    fun deleteAllNotes() = viewModelScope.launch {
        useCase.deleteAllNote()
    }

    fun deleteNote() = viewModelScope.launch {
        useCase.deleteNote()
    }
}