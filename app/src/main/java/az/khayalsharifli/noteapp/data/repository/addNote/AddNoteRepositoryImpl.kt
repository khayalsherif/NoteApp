package az.khayalsharifli.noteapp.data.repository.addNote

import az.khayalsharifli.noteapp.data.local.LocalDataSource
import az.khayalsharifli.noteapp.data.local.model.Note

class AddNoteRepositoryImpl(private val dataSource: LocalDataSource) : AddNoteRepository {
    override suspend fun insertNote(note: Note) {
        dataSource.insertNote(note)
    }
}