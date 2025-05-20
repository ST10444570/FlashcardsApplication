package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// Class defines the WelcomeScreen fragment, which displays the welcome layout to the user.
class WelcomeScreen : Fragment(R.layout.welcome_screen) {

    // Called when the view associated with this fragment is created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the "Start" button in the layout.
        val startButton: Button = view.findViewById(R.id.btnStart)

        // Set a click listener on the "Start" button.
        // When clicked, it navigates from the WelcomeScreen to the QuizScreen.
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_quizFragment)
        }
    }
}