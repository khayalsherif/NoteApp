package az.khayalsharifli.noteapp.data.repository.addNote

import az.khayalsharifli.noteapp.data.local.model.Note

interface AddNoteRepository {
    suspend fun insertNote(note: Note)
}