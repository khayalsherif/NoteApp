package az.khayalsharifli.noteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import az.khayalsharifli.noteapp.data.local.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}