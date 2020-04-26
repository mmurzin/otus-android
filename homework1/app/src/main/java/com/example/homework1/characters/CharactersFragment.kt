package com.example.homework1.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework1.R
import com.example.homework1.network.models.Character
import kotlinx.android.synthetic.main.characters_fragment.*

class CharactersFragment : Fragment() {

    private lateinit var viewModel: CharactersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.characters_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        viewModel.loadCharacters()
        viewModel.charactersItems.observe(viewLifecycleOwner,
            Observer { items ->
                setupList(items)
            })
        viewModel.charactersLoadingError.observe(viewLifecycleOwner,
            Observer { hasError ->

            })
        viewModel.charactersIsLoading.observe(viewLifecycleOwner,
            Observer { isLoading ->
                setLoadingState(isLoading)
            })
    }

    private fun setLoadingState(isLoading: Boolean) {
        if (isLoading) {
            loadingBar.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            loadingBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }

    private fun setupList(items: List<Character>?) {
        if (items != null) {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = CharactersAdapter(items)
            }
        }

    }


}
