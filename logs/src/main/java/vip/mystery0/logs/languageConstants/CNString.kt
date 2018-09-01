package vip.mystery0.logs.languageConstants

class CNString : StringInterface() {
	override fun getThreadTag(): String = "线程："

	override fun getDateTag(): String = "日期："

	override fun getStackTag(): String = "堆栈位置："
}