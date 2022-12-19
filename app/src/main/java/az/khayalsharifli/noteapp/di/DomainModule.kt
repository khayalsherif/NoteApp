package az.khayalsharifli.noteapp.di

import az.khayalsharifli.noteapp.domain.usecase.addNote.AddNoteUseCase
import az.khayalsharifli.noteapp.domain.usecase.noteList.NoteListUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

const val IO_CONTEXT = "IO_CONTEXT"

val domainModule = module {
    single<CoroutineContext>(named(IO_CONTEXT)) { Dispatchers.IO }

    factory { AddNoteUseCase(repository = get(), context = get(named(IO_CONTEXT))) }
    factory { NoteListUseCase(repository = get(), get(named(IO_CONTEXT))) }
}