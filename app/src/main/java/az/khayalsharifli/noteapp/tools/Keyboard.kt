package az.khayalsharifli.noteapp.tools

import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    view?.let {
        WindowInsetsControllerCompat(
            requireActivity().window,
            it
        ).hide(WindowInsetsCompat.Type.ime())
    }
}

fun Fragment.showKeyboard() {
    view?.let {
        WindowInsetsControllerCompat(
            requireActivity().window,
            it
        ).show(WindowInsetsCompat.Type.ime())
    }
}