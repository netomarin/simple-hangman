package dev.netomarin.simplehangman

import android.appwidget.AppWidgetManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import dev.netomarin.simplehangman.databinding.FragmentGameBinding

class GameFragment : Fragment() {

  private var _binding: FragmentGameBinding? = null
  private val binding get() = _binding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentGameBinding.inflate(inflater, container, false)

    val referencedIds = IntArray(Letters.values().size)
    binding.lettersFlow.requestLayout()
    Letters.values().forEachIndexed { index, letter ->
      val letterButton = ImageButton(requireContext())
      letterButton.setBackgroundColor(Color.TRANSPARENT)
      letterButton.setImageResource(letter.drawable)
      letterButton.setOnClickListener { letterSelected(letter.letter) }
      letterButton.id = View.generateViewId()
      binding.lettersLayout.addView(letterButton)
      referencedIds[index] = letterButton.id
    }
    binding.lettersFlow.referencedIds = referencedIds

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  private fun letterSelected(letter: String) {
    Log.d("SimpleHangman", "Letter Selected: ${letter}")
  }
}