package az.khayalsharifli.noteapp.data.repository.noteList

import az.khayalsharifli.noteapp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteListRepository {
    fun observeNoteList(): Flow<List<Note>>
    suspend fun deleteNote()
    suspend fun deleteAllNote()
}