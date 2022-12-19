package az.khayalsharifli.noteapp.domain.usecase.noteList

import az.khayalsharifli.noteapp.data.local.model.Note
import az.khayalsharifli.noteapp.data.repository.noteList.NoteListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class NoteListUseCase(
    private val repository: NoteListRepository,
    private val context: CoroutineContext
) {
    suspend fun deleteNote() {
        withContext(context = context) {
            repository.deleteNote()
        }
    }

    suspend fun deleteAllNote() {
        withContext(context = context) {
            repository.deleteAllNote()
        }
    }

    fun observeAllNote(): Flow<List<Note>> {
        return repository.observeNoteList()
    }
}