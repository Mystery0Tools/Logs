package vip.mystery0.logs

import org.koin.core.KoinApplication
import org.koin.core.logger.KOIN_TAG
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

/**
 * Setup Logs for Koin
 * @param level
 */
fun KoinApplication.logsLogger(
		level: Level = Level.INFO
): KoinApplication {
	KoinApplication.logger = LogsLogger(level)
	return this
}

class LogsLogger(level: Level = Level.INFO) : Logger(level) {
	override fun log(level: Level, msg: MESSAGE) {
		if (this.level <= level) {
			logOnLevel(msg)
		}
	}

	private fun logOnLevel(msg: MESSAGE) {
		when (this.level) {
			Level.DEBUG -> Logs.d(KOIN_TAG, msg)
			Level.INFO -> Logs.i(KOIN_TAG, msg)
			Level.ERROR -> Logs.e(KOIN_TAG, msg)
		}
	}
}