import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.WRITE_CONTACTS
import android.database.Cursor
import android.provider.ContactsContract
import androidx.test.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test


class CoursorIterationTest {
    @Rule
    @JvmField
    val contactsPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(READ_CONTACTS)

    @Test
    fun iterateContacts() {
        val NOT_SPECIFIED = ""
        val content = InstrumentationRegistry.getContext().contentResolver
        val projection = arrayOf(ContactsContract.Data.DISPLAY_NAME)
        val cursor =
                content.query(ContactsContract.Contacts.CONTENT_URI,
                        projection,
                        NOT_SPECIFIED,
                        emptyArray(),
                        NOT_SPECIFIED)

        val contacts = cursor.use {
            val contactsList = mutableListOf<String?>()
            while (it.moveToNext()) {
                val contactName = it.getString(ContactsContract.Data.DISPLAY_NAME)
                contactsList.add(contactName)
            }
            contactsList
        }

        contacts.take(10).mapNotNull {
            println(it)
        }
    }
}

fun Cursor.getString(columnName: String): String? {
    return getString(getColumnIndex(columnName))
}