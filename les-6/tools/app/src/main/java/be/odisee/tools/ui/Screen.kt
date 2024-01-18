package be.odisee.tools.ui

import androidx.annotation.StringRes
import be.odisee.tools.R

enum class Screen(@StringRes val stringId: Int) {
    Main(R.string.app_name),
    SharedPrefs(R.string.shared_preferences),
    SnackBar(R.string.snackbar),
    Menu(R.string.menu),
    Dialog(R.string.dialog)
}