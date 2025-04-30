package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class WelcomeScreen : Fragment(R.layout.welcome_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val startButton: Button = view.findViewById(R.id.btnStart)
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeScreen_to_quizScreen)
        }
    }
}

