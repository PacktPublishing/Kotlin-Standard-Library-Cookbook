package samuel.urbanowicz

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.GenericLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.example.unclesam.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class MainActivity: AppCompatActivity() {

    val sampleContextAwareViewProperty: View by LifecycleAwareLazy(lifecycle) {
        View(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_field.text = "Bonjour!"

        val job = launch {
            var counter = 1
            while (true) {
                delay(1000)
                counter++
                withContext(UI) {
                    text_field.text = counter.toString()
                }
            }
        }

        cancel_btn.setOnClickListener {
            job.cancel()
        }


    }
}

class LifecycleAwareLazy<T>(lifecycle: Lifecycle, val initializer: () -> T): Lazy<T>, GenericLifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    private object UNINITIALIZED_VALUE
    private var _value: Any? = UNINITIALIZED_VALUE

    override val value: T
        get() {
            if (_value === UNINITIALIZED_VALUE) {
                _value = initializer.invoke()
            }
            return _value as T
        }

    override fun isInitialized(): Boolean = _value != UNINITIALIZED_VALUE

    // GenericLifecycleObserver
    override fun onStateChanged(source: LifecycleOwner?, event: Lifecycle.Event?) {
        when (event) {
            Lifecycle.Event.ON_STOP -> {
                _value = UNINITIALIZED_VALUE
            }
            Lifecycle.Event.ON_DESTROY -> {
            }
            else -> return
        }
    }

}