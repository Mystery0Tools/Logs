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
import vip.mystery0.logs.languageConstants.StringInterfaceContext
import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object Logs {
	private const val VERBOSE = Log.VERBOSE
	private const val DEBUG = Log.DEBUG
	private const val INFO = Log.INFO
	private const val WARN = Log.WARN
	private const val ERROR = Log.ERROR
	private const val WTF = 99

	private const val BORDER = "═"
	private const val DIVIDER = "─"
	private const val TOP_CORNER = "╔"
	private const val MIDDLE_CORNER = "╟"
	private const val LEFT_BORDER = "║"
	private const val BOTTOM_CORNER = "╚"

	private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA)

	private var config = LogsConfig()

	@JvmStatic
	fun setConfig(config: LogsConfig) {
		this.config = config
	}

	@JvmStatic
	fun setConfig(listener: (LogsConfig) -> Unit) = listener.invoke(config)

	@JvmStatic
	fun v(msg: String?) = v(null, msg)

	@JvmStatic
	fun v(msg: String?, tr: Throwable) = v(null, msg, tr)

	/**
	 * Send a [.VERBOSE] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun v(tag: String?, msg: String?) = v(tag, msg, null)

	/**
	 * Send a [.VERBOSE] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun v(tag: String?, msg: String?, tr: Throwable?) {
		if (config.isShowLog) println(VERBOSE, tag, if (msg == null) emptyArray() else arrayOf(msg), tr)
	}

	@JvmStatic
	fun vm(vararg contents: Any?) {
		if (config.isShowLog) println(VERBOSE, null, Array(contents.size) { i -> contents[i].toString() }, null)
	}

	@JvmStatic
	fun d(msg: String?) = d(null, msg)

	/**
	 * Send a [.DEBUG] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun d(tag: String?, msg: String?) = d(tag, msg, null)

	/**
	 * Send a [.DEBUG] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun d(tag: String?, msg: String?, tr: Throwable?) {
		if (config.isShowLog) println(DEBUG, tag, if (msg == null) emptyArray() else arrayOf(msg), tr)
	}

	@JvmStatic
	fun dm(vararg contents: Any?) {
		if (config.isShowLog) println(DEBUG, null, Array(contents.size) { i -> contents[i].toString() }, null)
	}

	@JvmStatic
	fun i(msg: String?) = i(null, msg)

	/**
	 * Send an [.INFO] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun i(tag: String?, msg: String?) = i(tag, msg, null)

	/**
	 * Send a [.INFO] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun i(tag: String?, msg: String?, tr: Throwable?) {
		if (config.isShowLog) println(INFO, tag, if (msg == null) emptyArray() else arrayOf(msg), tr)
	}

	@JvmStatic
	fun im(vararg contents: Any?) {
		if (config.isShowLog) println(INFO, null, Array(contents.size) { i -> contents[i].toString() }, null)
	}

	@JvmStatic
	fun w(msg: String?) = w(null, msg)

	/**
	 * Send a [.WARN] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun w(tag: String?, msg: String?) = w(tag, msg, null)

	/**
	 * Send a {@link #WARN} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun w(tag: String?, tr: Throwable?) = w(tag, null, tr)

	/**
	 * Send a [.WARN] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun w(tag: String?, msg: String?, tr: Throwable?) = println(WARN, tag, if (msg == null) emptyArray() else arrayOf(msg), tr)

	@JvmStatic
	fun wm(vararg contents: Any?) = println(WARN, null, Array(contents.size) { i -> contents[i].toString() }, null)

	@JvmStatic
	fun e(msg: String?) = e(null, msg)

	@JvmStatic
	fun e(tag: String?, tr: Throwable?) = e(tag, null, tr)

	/**
	 * Send an [.ERROR] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun e(tag: String?, msg: String?) = e(tag, msg, null)

	/**
	 * Send a [.ERROR] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun e(tag: String?, msg: String?, tr: Throwable?) = println(ERROR, tag, if (msg == null) emptyArray() else arrayOf(msg), tr)

	@JvmStatic
	fun em(vararg contents: Any?) = println(ERROR, null, Array(contents.size) { i -> contents[i].toString() }, null)

	@JvmStatic
	fun wtf(msg: String?) = wtf(null, msg)

	@JvmStatic
	fun wtf(tag: String?, msg: String?) = wtf(tag, msg, null)

	@JvmStatic
	fun wtf(tag: String?, tr: Throwable?) = wtf(tag, null, tr)

	@JvmStatic
	fun wtf(tag: String?, msg: String?, tr: Throwable?) = println(WTF, tag, if (msg == null) emptyArray() else arrayOf(msg), tr)

	@JvmStatic
	fun wtfm(vararg contents: Any?) = println(WTF, null, Array(contents.size) { i -> contents[i].toString() }, null)

	private fun originPrintln(priority: Int, tag: String, msgList: ArrayList<ArrayList<String>>) {
		val stringBuilder = StringBuilder()
		stringBuilder.appendln(" ")
		if (config.isShowBorder && config.isShowLog) {//显示边框
			stringBuilder.appendln(printBorder(true))
			msgList.forEachIndexed { index, arrayList ->
				if (index != 0)
					stringBuilder.appendln(printDivider())
				stringBuilder.append(printMsg(arrayList.toTypedArray()))
			}
			stringBuilder.appendln(printBorder(false))
		} else {
			if (msgList.size == 1) {
				msgList[0].forEach {
					stringBuilder.appendln(it)
				}
			} else {
				msgList.forEach { list ->
					list.forEach {
						stringBuilder.appendln(it)
					}
				}
			}
		}
		if (priority == WTF)
			Log.wtf(tag, stringBuilder.toString())
		else
			Log.println(priority, tag, stringBuilder.toString())
	}

	private fun println(priority: Int, tag: String?, msg: Array<String>, tr: Throwable?) {
		val list = ArrayList<ArrayList<String>>()
		val stackTraceElement = parseStackTraceElement(config.stackOffset)
		val tagString = if (config.commonTag == "") tag
				?: stackTraceElement.fileName.substring(0, stackTraceElement.fileName.lastIndexOf('.'))
		else
			config.commonTag
		if (config.isShowLog) {
			val date = Calendar.getInstance().time
			if (config.isShowThread) {
				val threadTag = StringInterfaceContext.getString(config.language) { if (config.isShowInfoTag) it.getThreadTag() else "" }
				list.add(arrayListOf("$threadTag${Thread.currentThread()}"))
			}

			if (config.isShowHead) {
				val dateString = DATE_FORMAT.format(date)
				val headString = "${stackTraceElement.className}.${stackTraceElement.methodName}(${stackTraceElement.fileName}:${stackTraceElement.lineNumber})"
				val headStringList = ArrayList<String>()
				if (config.isShowDate) {
					val dateTag = StringInterfaceContext.getString(config.language) { if (config.isShowInfoTag) it.getDateTag() else "" }
					headStringList.add("$dateTag$dateString")
				}
				val stackTag = StringInterfaceContext.getString(config.language) { if (config.isShowInfoTag) it.getStackTag() else "" }
				headStringList.add("$stackTag$headString")
				list.add(headStringList)
			}
		}
		val messageStringList = ArrayList<String>()
		messageStringList.addAll(msg)
		list.add(messageStringList)
		if (tr != null) {
			list.add(arrayListOf(convertExceptionToString(tr)))
		}
		originPrintln(priority, tagString, list)
	}

	private fun parseStackTraceElement(stackOffset: Int): StackTraceElement {
		val stackTraceArray = Throwable().stackTrace
		if (stackOffset != -1)
			return stackTraceArray[stackOffset]
		else {
			stackTraceArray.forEach {
				if (!it.className.contains(javaClass.name))
					return it
			}
		}
		return stackTraceArray[0]
	}

	private fun printBorder(isTop: Boolean): String {
		val stringBuilder = StringBuilder()
		for (i in 0 until config.dividerLength)
			stringBuilder.append(BORDER)
		val borderString = stringBuilder.toString()
		return if (isTop)
			"$TOP_CORNER$borderString$borderString"
		else
			"$BOTTOM_CORNER$borderString$borderString"
	}

	private fun printDivider(): String {
		val stringBuilder = StringBuilder()
		for (i in 0 until config.dividerLength)
			stringBuilder.append(DIVIDER)
		val dividerString = stringBuilder.toString()
		return "$MIDDLE_CORNER$dividerString$dividerString"
	}

	private fun printMsg(msg: Array<String>): String {
		val stringBuilder = StringBuilder()
		msg.forEachIndexed { index, s ->
			val messageList = convertMessageToString(s)
			if (config.showNumber != LogsConfig.NumberGravity.NONE) {
				messageList.forEachIndexed { messageIndex, message ->
					stringBuilder.appendln("$LEFT_BORDER${formatIndex(index + 1, messageIndex == 0)}$LEFT_BORDER $message")
				}
			} else {
				messageList.forEach { message ->
					stringBuilder.appendln("$LEFT_BORDER $message")
				}
			}
		}
		return stringBuilder.toString()
	}

	private fun formatIndex(index: Int, isShow: Boolean = true): String {
		val stringBuilder = StringBuilder()
		var num = 1
		var temp = index
		while (temp >= 10) {
			num++
			temp /= 10
		}
		if (config.showNumber == LogsConfig.NumberGravity.LEFT && isShow)
			stringBuilder.append(index)
		if (isShow)
			for (i in 1..config.indexWidth - num)
				stringBuilder.append(' ')
		else
			for (i in 0 until config.indexWidth)
				stringBuilder.append(' ')
		if (config.showNumber == LogsConfig.NumberGravity.RIGHT && isShow)
			stringBuilder.append(index)
		return if (isShow) "[$stringBuilder]" else " $stringBuilder "
	}

	private fun convertExceptionToString(tr: Throwable): String {
		val stringWriter = StringWriter()
		val printWriter = PrintWriter(stringWriter)
		tr.printStackTrace(printWriter)
		val exceptionString = stringWriter.toString()
		printWriter.close()
		return exceptionString
	}

	private fun convertMessageToString(message: String): ArrayList<String> {
		val stringList = message.split("\n")
		val resultList = ArrayList<String>()
		resultList.addAll(stringList)
		return resultList
	}
}