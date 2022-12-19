package az.khayalsharifli.noteapp.di

import az.khayalsharifli.noteapp.presentation.content.addNote.AddNoteViewModel
import az.khayalsharifli.noteapp.presentation.content.noteList.NoteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { NoteListViewModel(useCase = get()) }
    viewModel { AddNoteViewModel(useCase = get()) }
}