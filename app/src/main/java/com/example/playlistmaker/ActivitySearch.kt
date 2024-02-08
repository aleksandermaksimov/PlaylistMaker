package com.example.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.content.Context
import android.view.inputmethod.InputMethodManager

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
                if (s?.isNotEmpty() == true) {
                    clearImageView.visibility = View.VISIBLE
                } else {
                    clearImageView.visibility = View.GONE
                }
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

        val backImage = findViewById<ImageView>(R.id.back_image)
        backImage.setOnClickListener {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(searchEditText.windowToken, 0)
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
