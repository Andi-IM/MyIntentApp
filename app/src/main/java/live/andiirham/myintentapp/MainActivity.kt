package live.andiirham.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult : TextView
    companion object{
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val dialButton : Button = findViewById(R.id.btn_dial_number)
        dialButton.setOnClickListener(this)

        val btnMoveResult : Button = findViewById(R.id.btn_move_for_result)
        btnMoveResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity->{
                val moveintent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveintent)
            }
            R.id.btn_move_with_data -> {
                val moveDataWithIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveDataWithIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "PNP Students")
                moveDataWithIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,19)
                startActivity(moveDataWithIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Andi Irham",
                    5,
                    "andi.irhamm@gmail.com",
                    "Padang"
                )

                val moveDataWithObject = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveDataWithObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveDataWithObject)
            }
            R.id.btn_dial_number ->{
                val phoneNumber = "0823123456"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResult = Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}