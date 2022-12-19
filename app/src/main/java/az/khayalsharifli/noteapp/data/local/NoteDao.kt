package az.khayalsharifli.noteapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import az.khayalsharifli.noteapp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNote(): Flow<List<Note>>

    @Query("DELETE FROM note")
    fun clearAllNote()

    @Query("DELETE FROM note")
    fun clearNote()
}