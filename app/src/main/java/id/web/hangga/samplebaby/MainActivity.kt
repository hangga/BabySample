package id.web.hangga.samplebaby

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.github.hangga.babybus.BabyBus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val babyBus = BabyBus(this)
        val txtData = findViewById<TextView?>(R.id.txtData)
        findViewById<View?>(R.id.btnPick).setOnClickListener {
            babyBus.startActivityForResult(ModalActivity::class.java) { i, data ->
                if (i == RESULT_OK) {
                    val nama = data.getStringExtra("nama")
                    val alamat = data.getStringExtra("alamat")
                    val phone = data.getStringExtra("phone")
                    txtData.append("$nama | ")
                    txtData.append("$alamat | ")
                    txtData.append(phone)
                }
            }
        }
        findViewById<View?>(R.id.btnStart).setOnClickListener {
            val intent = Intent(this@MainActivity, ModalActivity::class.java)
            intent.putExtra("call_type", "startIntent")
            babyBus.startIntent(intent) { i, data ->
                if (i == RESULT_OK) {
                    val nama = data.getStringExtra("nama")
                    val alamat = data.getStringExtra("alamat")
                    val phone = data.getStringExtra("phone")
                    txtData.append("$nama | ")
                    txtData.append("$alamat | ")
                    txtData.append(phone)
                }
            }
        }
    }
}