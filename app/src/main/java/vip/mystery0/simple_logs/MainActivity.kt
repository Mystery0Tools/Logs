package vip.mystery0.simple_logs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vip.mystery0.logs.Logs

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		Logs.im("test1", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4")
		Logs.d("tag", "test2")
		Logs.i("test3")
		Logs.w("tag", "test4", Exception("this is a test exception"))
		Logs.e("tag", "test5", Exception("this is a test exception"))
		Logs.im("onCreate: ", "qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiop\nasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789q\nwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789", "test", "qwertyuiopasdfghjklzxcvbnm0123456789", "qwertyuiopasdfghjklzxcvbnm0123456789qwertyuiopasdfghjklzxcvbnm0123456789")
	}
}
