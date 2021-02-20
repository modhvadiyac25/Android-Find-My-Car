package com.example.findmycar


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login_fragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class login_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*   view.btn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.signup_fragment)
        }

      */

        val view : View = inflater.inflate(R.layout.fragment_login_fragment, container, false)

      //  var email = view.email
        //var password = view.password



        return view
    }


}
