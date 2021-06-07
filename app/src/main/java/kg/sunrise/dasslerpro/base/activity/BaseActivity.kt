package kg.sunrise.dasslerpro.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import kg.sunrise.dasslerpro.utils.extensions.hideKeyboard


abstract class BaseActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    protected abstract val navContainerId: Int

    override fun onStart() {
        super.onStart()
        val navHostFragment =
                supportFragmentManager.findFragmentById(navContainerId) as? NavHostFragment
        val navController = navHostFragment?.navController
        navController?.addOnDestinationChangedListener(this)
    }

    override fun onStop() {
        super.onStop()
        val navHostFragment =
                supportFragmentManager.findFragmentById(navContainerId) as? NavHostFragment
        val navController = navHostFragment?.navController
        navController?.removeOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        currentFocus?.hideKeyboard()
    }
}