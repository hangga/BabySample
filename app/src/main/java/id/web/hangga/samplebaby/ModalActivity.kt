package id.web.hangga.samplebaby

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ModalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modal)
        val txtTitle = findViewById<TextView?>(R.id.txtTitle)
        val callType = intent.getStringExtra("call_type")
        txtTitle.text = callType
        val edtNama = findViewById<EditText?>(R.id.edtNama)
        val edtAlamat = findViewById<EditText?>(R.id.edtAlamat)
        val edtTelp = findViewById<EditText?>(R.id.edtTelp)
        findViewById<View?>(R.id.btnSubmit).setOnClickListener { view: View? ->
            val intent = intent
            intent.putExtra("nama", edtNama.text.toString())
            intent.putExtra("alamat", edtAlamat.text.toString())
            intent.putExtra("phone", edtTelp.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}