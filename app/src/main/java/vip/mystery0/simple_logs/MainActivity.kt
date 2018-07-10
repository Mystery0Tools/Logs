package vip.mystery0.simple_logs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vip.mystery0.logs.Logs

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		Logs.im("test1", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4")
		Logs.i("test2")
	}
}
