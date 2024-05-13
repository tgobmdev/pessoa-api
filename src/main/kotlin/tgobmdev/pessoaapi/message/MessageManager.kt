package tgobmdev.pessoaapi.message

import java.text.MessageFormat
import java.util.*

class MessageManager {
    companion object {
        private const val BASE_NAME: String = "i18n/messages"
        private val defaultBundle: ResourceBundle = ResourceBundle.getBundle(
            BASE_NAME, Locale.getDefault()
        )

        @JvmStatic
        fun getMessage(key: String): String {
            return defaultBundle.getString(key)
        }

        @JvmStatic
        fun getMessage(key: String, vararg args: Any): String {
            return MessageFormat.format(getMessage(key), args)
        }
    }
}