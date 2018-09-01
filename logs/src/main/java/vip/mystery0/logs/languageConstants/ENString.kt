package vip.mystery0.logs.languageConstants

class ENString : StringInterface() {
	override fun getThreadTag(): String = "Thread: "

	override fun getDateTag(): String = "Date: "

	override fun getStackTag(): String = "Location: "
}