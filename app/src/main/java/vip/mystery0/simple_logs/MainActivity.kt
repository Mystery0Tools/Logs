package vip.mystery0.simple_logs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.blankj.utilcode.util.LogUtils
import vip.mystery0.logs.Logs

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		LogUtils.i("onCreate: ","test2","test3","test4","test1", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4")
		Logs.im("test1", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4", "test2", "test3", "test4")
		Logs.i("test2")
	}
}
