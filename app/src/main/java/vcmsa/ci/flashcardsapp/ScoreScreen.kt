package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ScoreScreen : Fragment(R.layout.score_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scoreText: TextView = view.findViewById(R.id.scoreText)
        val score = arguments?.getInt("score") ?: 0

        scoreText.text = "Your Score: $score / 5"
    }
}
