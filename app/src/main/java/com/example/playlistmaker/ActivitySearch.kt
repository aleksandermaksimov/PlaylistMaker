package com.example.playlistmaker

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import trackList

class ActivitySearch : AppCompatActivity() {
    private lateinit var searchEditText: EditText
    private lateinit var clearImageView: ImageView
    private var searchText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchEditText = findViewById(R.id.search_edit_text)
        clearImageView = findViewById(R.id.clear_image_view)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchText = s.toString()
                clearImageView.isVisible = !searchText.isNullOrEmpty()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        clearImageView.setOnClickListener {
            searchEditText.setText("")
            hideKeyboard()
        }

        searchEditText.hint = getString(R.string.enter_a_request)
        searchEditText.maxLines = 1
        searchEditText.setText(searchText)

        val backImage: ImageView = findViewById(R.id.back_image)
        backImage.setOnClickListener {
            onBackPressed()
        }

        val recyclerView: RecyclerView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val trackAdapter = TrackAdapter(trackList)
        recyclerView.adapter = trackAdapter
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(searchEditText.windowToken, 0)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("searchText", searchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchText = savedInstanceState.getString("searchText", "") ?: ""
        searchEditText.setText(searchText)
    }
}
