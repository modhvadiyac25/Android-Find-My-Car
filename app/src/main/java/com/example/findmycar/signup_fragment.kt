package com.example.findmycar


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import kotlinx.android.synthetic.main.fragment_login_fragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class signup_fragment : Fragment() {

    private lateinit var navigationController : NavController
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var  drawerLayout : DrawerLayout
    private lateinit var listener : NavController.OnDestinationChangedListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup_fragment, container, false)
       /* view.btn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.login_fragment)

        }
        */
     //   navigationController = findNavController(R.id.fragment)
     //   drawerLayout = findViewById(R.id.drawerlayout)
       // navigation_view.setupWithNavController(navigationController)

        appBarConfiguration = AppBarConfiguration(navigationController.graph , drawerLayout)

      //  setupActionBarWithNavController(navigationController,appBarConfiguration)
        return view
    }


}
