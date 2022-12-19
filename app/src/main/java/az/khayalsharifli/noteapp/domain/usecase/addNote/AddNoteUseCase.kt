package az.khayalsharifli.noteapp.domain.usecase.addNote

import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.data.repository.addNote.AddNoteRepository
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class AddNoteUseCase(
    private val repository: AddNoteRepository,
    private val context: CoroutineContext
) {

    suspend fun insertNote(note: Note) {
        withContext(context) {
            repository.insertNote(note = note)
        }
    }
}