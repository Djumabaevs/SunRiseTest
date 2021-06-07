package kg.sunrise.dasslerpro.utils.extensions

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kg.sunrise.dasslerpro.ui.main.MainActivity

fun View.hideKeyboard() {
    val imm = context.getSystemService(
        Activity.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

infix fun ViewGroup.inflate(@LayoutRes id: Int): View {
    return LayoutInflater.from(context).inflate(id, this, false)
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_LONG): Toast =
    Toast.makeText(this, getString(id), duration).apply {
        show()
    }

fun Fragment.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_LONG): Toast =
    Toast.makeText(requireActivity(), getString(id), duration).apply {
        show()
    }

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG): Toast =
    Toast.makeText(this, message, duration).apply {
        show()
    }

fun Activity.setNoInternetLayoutVisibility(gone: Int) {
    (this as? MainActivity)?.let {

    }
}

fun ViewPager2.setOverScrollModeNever() {
    (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
}