package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ScoreScreen : Fragment(R.layout.score_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scoreText: TextView = view.findViewById(R.id.scoreText)
        val feedbackText: TextView = view.findViewById(R.id.reviewText)
        val reviewButton: Button = view.findViewById(R.id.btnReview)
        val exitButton: Button = view.findViewById(R.id.btnExit)

        val score = arguments?.getInt("score") ?: 0

        scoreText.text = "Your score is: $score / 5"
        feedbackText.visibility = View.GONE

        reviewButton.setOnClickListener {
            feedbackText.text = getFeedback(score)
            feedbackText.visibility = View.VISIBLE
        }

        exitButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }

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
