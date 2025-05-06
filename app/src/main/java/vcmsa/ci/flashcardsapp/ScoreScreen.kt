package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// This class represents the final screen where the user sees their score and feedback.
class ScoreScreen : Fragment(R.layout.score_screen) {

    // Called when the fragment's view has been created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get references to UI elements.
        val scoreText: TextView = view.findViewById(R.id.scoreText)
        val feedbackText: TextView = view.findViewById(R.id.reviewText)
        val reviewButton: Button = view.findViewById(R.id.btnReview)
        val exitButton: Button = view.findViewById(R.id.btnExit)

        // Retrieve the score passed from the quiz screen; default to 0 if not found.
        val score = arguments?.getInt("score") ?: 0

        // Display the user's score using a resource string.
        scoreText.text = getString(R.string.score_message, score)

        // Hide the feedback text initially.
        feedbackText.visibility = View.GONE

        // When the "Review" button is clicked, display the feedback message.
        reviewButton.setOnClickListener {
            feedbackText.text = getFeedback(score)       // Set feedback based on score.
            feedbackText.visibility = View.VISIBLE       // Make the feedback visible.
        }

        // When the "Exit" button is clicked, navigate back to the welcome screen.
        exitButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_welcomeFragment)
        }
    }

    // Function to return feedback text based on the user's score.
    private fun getFeedback(score: Int): String {
        return when {
            score == 5 -> "Perfect! You're a quiz master!"
            score >= 4 -> "Great job! You really know your stuff!"
            score >= 3 -> "Good effort! Keep practicing!"
            score >= 2 -> "Not bad, but there's room for improvement."
            else -> "Keep trying! You’ll get better with practice!"
        }
    }
}
