package vip.mystery0.logs

class LogsConfig {
	var isShowLog = true//是否显示日志
	var isShowDate = false//是否显示日期
	var isShowHead = true//是否显示头部信息
	var isShowBorder = true//是否显示边框
	var indexWidth = 4//多条信息输出时，编号所占的宽度
	var stackOffset = 2//需要输出的栈深度

	fun setShowLog(isShowLog: Boolean): LogsConfig {
		this.isShowLog = isShowLog
		return this
	}

	fun setShowDate(isShowDate: Boolean): LogsConfig {
		this.isShowDate = isShowDate
		return this
	}

	fun setShowHead(isShowHead: Boolean): LogsConfig {
		this.isShowHead = isShowHead
		return this
	}

	fun setShowBorder(isShowBorder: Boolean): LogsConfig {
		this.isShowBorder = isShowBorder
		return this
	}

	fun setIndexWidth(indexWidth: Int): LogsConfig {
		this.indexWidth = indexWidth
		return this
	}

	fun setStackOffset(stackOffset: Int): LogsConfig {
		this.stackOffset = stackOffset
		return this
	}
}