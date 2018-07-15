import android.preference.PreferenceManager
import androidx.core.content.edit
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SharedPreferencesTest {

    @Test
    fun testUserParcelization() {
        // given
        val sharedPrefs = getDefaultSharedPreferences()
        val userName: String = "Gonzo"

        // when
        sharedPrefs.edit {
            putString("user_name", userName)
        }

        // then
        val DEFAULT_VALUE = "empty"
        val fetchedUserName = sharedPrefs.getString("user_name", DEFAULT_VALUE)
        assertSame(userName, fetchedUserName)
    }

    private fun getDefaultSharedPreferences() =
            PreferenceManager.getDefaultSharedPreferences(InstrumentationRegistry.getContext())
}