import android.os.Bundle
import android.os.Parcelable
import androidx.test.runner.AndroidJUnit4
import kotlinx.android.parcel.Parcelize
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParcelizeTest {

    @Test
    fun testUserParcelisation() {
        // given
        val originalUser = User("Bob", Address("Rue de Paris", "123", "Warsaw"))
        val bundle = Bundle()

        // when
        bundle.putParcelable("my_user", originalUser)

        // then
        val deserialisedUser = bundle.get("my_user") as User
        assertEquals(originalUser, deserialisedUser)
    }
}

@Parcelize
data class User(val name: String, val address: Address): Parcelable

@Parcelize
data class Address(val street: String, val number: String, val city: String): Parcelable