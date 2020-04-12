package vip.mystery0.logs

import org.koin.core.KoinApplication
import org.koin.core.logger.KOIN_TAG
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

/**
 * Setup Android Logger for Koin
 * @param level
 */
fun KoinApplication.logsLogger(
		level: Level = Level.INFO
): KoinApplication {
	koin._logger = LogsLogger(level)
	return this
}

/**
 * Logger that uses the native Android Logger
 *
 * @author - Arnaud GIULIANI
 */
class LogsLogger(level: Level = Level.INFO) : Logger(level) {

	override fun log(level: Level, msg: MESSAGE) {
		if (this.level <= level) {
			logOnLevel(msg, level)
		}
	}

	private fun logOnLevel(msg: MESSAGE, level: Level) {
		when (level) {
			Level.DEBUG -> Logs.d(KOIN_TAG, msg)
			Level.INFO -> Logs.i(KOIN_TAG, msg)
			Level.ERROR -> Logs.e(KOIN_TAG, msg)
			else -> Logs.e(KOIN_TAG, msg)
		}
	}
}