package vip.mystery0.logs

import vip.mystery0.logs.languageConstants.StringInterfaceContext

class LogsConfig {
	var isShowLog = true//是否显示日志
	var isShowDate = true//是否显示日期
	var isShowHead = true//是否显示头部信息
	var isShowBorder = true//是否显示边框
	var isShowThread = true//是否显示当前的所在线程
	var isShowInfoTag = true//是否显示信息的tag
	var commonTag = ""//全局的tag

	enum class NumberGravity { NONE, LEFT, RIGHT }

	var showNumber = NumberGravity.RIGHT//是否显示编号
	var indexWidth = 3//多条信息输出时，编号所占的宽度
	var stackOffset = -1//需要输出的栈深度，-1表示自动计算
	var dividerLength = 60//分割线的宽度

	var language = StringInterfaceContext.Language.EN//提示信息的语言

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

	fun setShowThread(isShowThread: Boolean): LogsConfig {
		this.isShowThread = isShowThread
		return this
	}

	fun setShowInfoTag(isShowInfoTag: Boolean): LogsConfig {
		this.isShowInfoTag = isShowInfoTag
		return this
	}

	fun setShowNumber(gravity: NumberGravity): LogsConfig {
		this.showNumber = gravity
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

	fun setDividerLength(dividerLength: Int): LogsConfig {
		this.dividerLength = dividerLength
		return this
	}

	fun setCommonTag(commonTag: String): LogsConfig {
		this.commonTag = commonTag
		return this
	}
}