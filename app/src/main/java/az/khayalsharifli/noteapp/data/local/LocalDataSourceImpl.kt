package az.khayalsharifli.noteapp.data.local

import az.khayalsharifli.noteapp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val dao: NoteDao) : LocalDataSource {
    override fun observeNoteList(): Flow<List<Note>> {
        return dao.getAllNote()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(id: Int) {
        dao.clearNote(id)
    }

    override suspend fun deleteAllNote() {
        dao.clearAllNote()
    }
}