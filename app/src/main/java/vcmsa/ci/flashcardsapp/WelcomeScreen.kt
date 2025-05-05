package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// This class represents the welcome screen fragment.
class WelcomeScreen : Fragment(R.layout.welcome_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //The button which the user uses to navigate from the Welcome Screen to the Quiz Screen.
        val startButton: Button = view.findViewById(R.id.btnStart)
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_quizFragment)
        }
    }
}