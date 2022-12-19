package az.khayalsharifli.noteapp.di

import androidx.room.Room
import az.khayalsharifli.noteapp.data.local.LocalDataSource
import az.khayalsharifli.noteapp.data.local.LocalDataSourceImpl
import az.khayalsharifli.noteapp.data.local.NoteDataBase
import az.khayalsharifli.noteapp.data.repository.addNote.AddNoteRepository
import az.khayalsharifli.noteapp.data.repository.addNote.AddNoteRepositoryImpl
import az.khayalsharifli.noteapp.data.repository.noteList.NoteListRepository
import az.khayalsharifli.noteapp.data.repository.noteList.NoteListRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    ////////////////////////////////////////////////////// LOCAL //////////////////////////////////////////////////////////////

    single { get<NoteDataBase>().noteDao() }

    single<LocalDataSource> { LocalDataSourceImpl(dao = get()) }

    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDataBase::class.java, "note"
        ).fallbackToDestructiveMigration().build()
    }

    /////////////////////////////////////////////////// REPOSITORY ///////////////////////////////////////////////////////////

    factory<AddNoteRepository> { AddNoteRepositoryImpl(dataSource = get()) }
    factory<NoteListRepository> { NoteListRepositoryImpl(dataSource = get()) }

}