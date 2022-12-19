package az.khayalsharifli.noteapp.data.repository.noteList

import az.khayalsharifli.noteapp.data.local.LocalDataSource
import az.khayalsharifli.noteapp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

class NoteListRepositoryImpl(private val dataSource: LocalDataSource) : NoteListRepository {
    override fun observeNoteList(): Flow<List<Note>> {
        return dataSource.observeNoteList()
    }

    override suspend fun deleteNote(id: Int) {
        dataSource.deleteNote(id)
    }

    override suspend fun deleteAllNote() {
        dataSource.deleteAllNote()
    }
}