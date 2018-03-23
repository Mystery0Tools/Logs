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

object Logs {

	private const val VERBOSE = 2
	private const val DEBUG = 3
	private const val INFO = 4
	private const val WARN = 5
	private const val ERROR = 6
	private const val ASSERT = 7

	private var level = 0

	enum class Level {
		RELEASE, DEBUG
	}

	@JvmStatic
	fun setLevel(level: Level) {
		Logs.level = when (level) {
			Level.RELEASE -> 5
			Level.DEBUG -> 0
		}
	}

	/**
	 * Send a [.VERBOSE] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun v(tag: String, msg: String) {
		if (level < VERBOSE) Log.v(tag, msg)
	}

	/**
	 * Send a [.VERBOSE] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun v(tag: String, msg: String, tr: Throwable) {
		if (level < VERBOSE) Log.v(tag, msg, tr)
	}

	/**
	 * Send a [.DEBUG] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun d(tag: String, msg: String) {
		if (level < DEBUG) Log.d(tag, msg)
	}

	/**
	 * Send a [.DEBUG] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun d(tag: String, msg: String, tr: Throwable) {
		if (level < DEBUG) Log.d(tag, msg, tr)
	}

	/**
	 * Send an [.INFO] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun i(tag: String, msg: String) {
		if (level < INFO) Log.i(tag, msg)
	}

	/**
	 * Send a [.INFO] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun i(tag: String, msg: String, tr: Throwable) {
		if (level < INFO) Log.i(tag, msg, tr)
	}

	/**
	 * Send a [.WARN] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun w(tag: String, msg: String) {
		if (level < WARN) Log.w(tag, msg)
	}

	/**
	 * Send a [.WARN] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun w(tag: String, msg: String, tr: Throwable) {
		if (level < WARN) Log.w(tag, msg, tr)
	}

	/*
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
	@JvmStatic
	fun w(tag: String, tr: Throwable) {
		if (level < WARN) Log.w(tag, tr)
	}

	/**
	 * Send an [.ERROR] log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	@JvmStatic
	fun e(tag: String, msg: String) {
		if (level < ERROR) Log.e(tag, msg)
	}

	/**
	 * Send a [.ERROR] log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 * the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	@JvmStatic
	fun e(tag: String, msg: String, tr: Throwable) {
		if (level < ERROR) Log.w(tag, msg, tr)
	}

	@JvmStatic
	fun wtf(tag: String, msg: String) {
		Log.wtf(tag, msg)
	}

	@JvmStatic
	fun wtf(tag: String, tr: Throwable) {
		Log.wtf(tag, tr)
	}

	@JvmStatic
	fun wtf(tag: String, msg: String, tr: Throwable) {
		Log.wtf(tag, msg, tr)
	}
}