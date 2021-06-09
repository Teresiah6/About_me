package example.google.com.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import example.google.com.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Teresia Karanja")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // databinding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //it refers to done button
        binding.myName =myName
        binding.doneButton.setOnClickListener { addNickname(it) }
        //findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }

        binding.nicknameText.setOnClickListener { updateNickname(it) }
     //   findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            //updateNickname(it)
        }



  private fun addNickname(view: View) {
      binding.apply {


          myName?.nickname = nicknameEdit.text.toString()
          // invalidate all binding expressions so that they are recreated with correct dayta
          invalidateAll()
          binding.nicknameEdit.visibility = View.GONE
          binding.doneButton.visibility = View.GONE
          binding.nicknameText.visibility = View.VISIBLE
      }
      //hide keyboard after inputting
      val inputMethodManager = getSystemService (Context.INPUT_METHOD_SERVICE) as InputMethodManager
      inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)

    }
    private fun updateNickname (view: View){

        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton. visibility = View.VISIBLE
        view.visibility = View.GONE
        //set focus for textview -> makes it look like a button
       binding.nicknameEdit.requestFocus()
        //show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit,0)

    }
}