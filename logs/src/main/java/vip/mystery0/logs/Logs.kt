/*
 * Created by Mystery0 on 18-3-20 下午2:01.
 * Copyright (c) 2018. All Rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vip.mystery0.logs

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object Logs {
	private const val VERBOSE = Log.VERBOSE
	private const val DEBUG = Log.DEBUG
	private const val INFO = Log.INFO
	private const val WARN = Log.WARN
	private const val ERROR = Log.ERROR
	private const val WTF = 99

	private const val BORDER = "────────────────────────────────────────────────────────"
	private const val DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄"
	private const val TOP_CORNER = "┌"
	private const val MIDDLE_CORNER = "├"
	private const val LEFT_BORDER = "│ "
	private const val BOTTOM_CORNER = "└"

	private val DATE_FORMAT = SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.CHINA)

	private var config = LogsConfig()

	@JvmStatic
	fun setConfig(config: LogsConfig) {
		this.config = config
	}

	@JvmStatic
	fun v(msg: String?) {
		v(null, msg)
	}

	@JvmStatic
	fun v(msg: String?, tr: Throwable) {
		v(null, msg, tr)
	}

	/**
	 * Send a [.VERBOSE] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun v(tag: String?, msg: String?) {
		v(tag, msg, null)
	}

	/**
	 * Send a [.VERBOSE] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun v(tag: String?, msg: String?, tr: Throwable?) {
		if (config.isShowLog) Logs.println(VERBOSE, tag, if (msg == null) emptyArray() else arrayOf(msg))
		tr?.printStackTrace()
	}

	@JvmStatic
	fun vm(vararg contents: Any?) {
		Logs.println(VERBOSE, null, Array(contents.size, { i -> contents[i].toString() }))
	}

	@JvmStatic
	fun d(msg: String?) {
		d(null, msg)
	}

	/**
	 * Send a [.DEBUG] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun d(tag: String?, msg: String?) {
		d(tag, msg, null)
	}

	/**
	 * Send a [.DEBUG] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun d(tag: String?, msg: String?, tr: Throwable?) {
		if (config.isShowLog) Logs.println(DEBUG, tag, if (msg == null) emptyArray() else arrayOf(msg))
		tr?.printStackTrace()
	}

	@JvmStatic
	fun dm(vararg contents: Any?) {
		Logs.println(DEBUG, null, Array(contents.size, { i -> contents[i].toString() }))
	}

	@JvmStatic
	fun i(msg: String?) {
		i(null, msg)
	}

	/**
	 * Send an [.INFO] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun i(tag: String?, msg: String?) {
		i(tag, msg, null)
	}

	/**
	 * Send a [.INFO] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun i(tag: String?, msg: String?, tr: Throwable?) {
		if (config.isShowLog) Logs.println(INFO, tag, if (msg == null) emptyArray() else arrayOf(msg))
		tr?.printStackTrace()
	}

	@JvmStatic
	fun im(vararg contents: Any?) {
		Logs.println(INFO, null, Array(contents.size, { i -> contents[i].toString() }))
	}

	@JvmStatic
	fun w(msg: String?) {
		w(null, msg)
	}

	/**
	 * Send a [.WARN] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun w(tag: String?, msg: String?) {
		w(tag, msg, null)
	}

	/**
	 * Send a {@link #WARN} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun w(tag: String?, tr: Throwable?) {
		w(tag, null, tr)
	}

	/**
	 * Send a [.WARN] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun w(tag: String?, msg: String?, tr: Throwable?) {
		Logs.println(WARN, tag, if (msg == null) emptyArray() else arrayOf(msg))
		tr?.printStackTrace()
	}

	@JvmStatic
	fun wm(vararg contents: Any?) {
		Logs.println(WARN, null, Array(contents.size, { i -> contents[i].toString() }))
	}

	@JvmStatic
	fun e(msg: String?) {
		e(null, msg)
	}

	@JvmStatic
	fun e(tag: String?, tr: Throwable?) {
		e(tag, null, tr)
	}

	/**
	 * Send an [.ERROR] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun e(tag: String?, msg: String?) {
		Log.e(tag, msg)
	}

	/**
	 * Send a [.ERROR] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun e(tag: String?, msg: String?, tr: Throwable?) {
		Logs.println(ERROR, tag, if (msg == null) emptyArray() else arrayOf(msg))
		tr?.printStackTrace()
	}

	@JvmStatic
	fun em(vararg contents: Any?) {
		Logs.println(ERROR, null, Array(contents.size, { i -> contents[i].toString() }))
	}

	@JvmStatic
	fun wtf(msg: String?) {
		wtf(null, msg)
	}

	@JvmStatic
	fun wtf(tag: String?, msg: String?) {
		wtf(tag, msg, null)
	}

	@JvmStatic
	fun wtf(tag: String?, tr: Throwable?) {
		wtf(tag, null, tr)
	}

	@JvmStatic
	fun wtf(tag: String?, msg: String?, tr: Throwable?) {
		Logs.println(WTF, tag, if (msg == null) emptyArray() else arrayOf(msg))
		tr?.printStackTrace()
	}

	@JvmStatic
	fun wtfm(vararg contents: Any?) {
		Logs.println(WTF, null, Array(contents.size, { i -> contents[i].toString() }))
	}

	@JvmStatic
	private fun println(priority: Int, tag: String?, msg: Array<String>) {
		val date = Calendar.getInstance().time
		val stackTraceElement = Throwable().stackTrace[config.stackOffset]
		val tagString = tag
				?: stackTraceElement.fileName.substring(0, stackTraceElement.fileName.lastIndexOf('.'))
		val stringBuffer = if (config.isShowBorder) StringBuffer(" ").appendln() else StringBuffer(" ")
		if (config.isShowBorder) {
			stringBuffer.append(printBorder(true)).appendln()
			if (config.isShowHead)
				stringBuffer.append(printHead(date, stackTraceElement)).appendln()
						.append(printDivider()).appendln()
			stringBuffer.append(printMsg(msg))
					.append(printBorder(false))
		} else {
			if (msg.size == 1)
				stringBuffer.append(msg[0]).appendln()
			else {
				stringBuffer.appendln()
				msg.forEach { stringBuffer.append(it).appendln() }
			}
		}
		if (priority == WTF)
			Log.wtf(tagString, stringBuffer.toString())
		else
			Log.println(priority, tagString, stringBuffer.toString())
	}

	@JvmStatic
	private fun printBorder(isTop: Boolean): String {
		return if (isTop)
			"$TOP_CORNER$BORDER$BORDER"
		else
			"$BOTTOM_CORNER$BORDER$BORDER"
	}

	@JvmStatic
	private fun printHead(date: Date, stackTraceElement: StackTraceElement): String {
		val dateString = DATE_FORMAT.format(date)
		val headString = "${stackTraceElement.className}.${stackTraceElement.methodName}(${stackTraceElement.fileName}:${stackTraceElement.lineNumber})"
		val stringBuffer = StringBuffer(LEFT_BORDER)
		if (config.isShowDate)
			stringBuffer.append(" $dateString")
		stringBuffer.append(" $headString")
		return stringBuffer.toString()
	}

	@JvmStatic
	private fun printDivider(): String {
		return "$MIDDLE_CORNER$DIVIDER$DIVIDER"
	}

	@JvmStatic
	private fun printMsg(msg: Array<String>): String {
		if (msg.size == 1)
			return "$LEFT_BORDER ${msg[0]}\n"
		else {
			val stringBuffer = StringBuffer()
			msg.forEachIndexed { index, s -> stringBuffer.append("$LEFT_BORDER ${formatIndex(index)} $LEFT_BORDER $s").appendln() }
			return stringBuffer.toString()
		}
	}

	@JvmStatic
	private fun formatIndex(index: Int): String {
		val stringBuilder = StringBuilder()
		var num = 1
		var temp = index
		while (temp >= 10) {
			num++
			temp /= 10
		}
		for (i in 1..config.indexWidth - num)
			stringBuilder.append(' ')
		stringBuilder.append(index)
		return stringBuilder.toString()
	}
}