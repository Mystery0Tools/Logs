package vip.mystery0.logs.languageConstants

object StringInterfaceContext {
	private val cnImpl = CNString()
	private val enImpl = ENString()

	fun getString(language: Language, listener: (StringInterface) -> String): String {
		return when (language) {
			Language.EN -> listener.invoke(enImpl)
			Language.CN -> listener.invoke(cnImpl)
		}
	}

	enum class Language { EN, CN }
}