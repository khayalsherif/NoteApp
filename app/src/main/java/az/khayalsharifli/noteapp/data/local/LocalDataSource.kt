package az.khayalsharifli.noteapp.data.local

import az.khayalsharifli.noteapp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun observeNoteList(): Flow<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun deleteNote()
    suspend fun deleteAllNote()
}