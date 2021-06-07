package kg.sunrise.dasslerpro.ui.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.sunrise.dasslerpro.R
import kg.sunrise.dasslerpro.base.activity.BaseActivity
import kg.sunrise.dasslerpro.utils.extensions.gone
import kg.sunrise.dasslerpro.utils.extensions.setupWithNavController
import kg.sunrise.dasslerpro.utils.extensions.visible

class MainActivity : BaseActivity() {

    override val navContainerId: Int = R.id.nav_host_container

    private var currentNavController: LiveData<NavController>? = null

    private val navIdsForBottomNavShow = listOf(
        R.id.mainFragment,
        R.id.handbookFragment,
        R.id.infoFragment,
        R.id.profileFragment,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.main_nav_graph,
            R.navigation.handbook_nav_graph,
            R.navigation.info_nav_graph,
            R.navigation.profile_nav_graph
        )

        val controller = bottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        currentNavController = controller
    }

    override fun onNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onBackPressed() {
        if (currentNavController?.value?.popBackStack() != true) {
            super.onBackPressed()
        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        super.onDestinationChanged(controller, destination, arguments)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        if (destination.id in navIdsForBottomNavShow) {
            bottomNavigation.visible()
        } else {
            bottomNavigation.gone()
        }
    }
}