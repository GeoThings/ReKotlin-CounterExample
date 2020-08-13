package counterexample.sample.counterexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import counterexample.sample.counterexample.actions.CounterActionDecrease
import counterexample.sample.counterexample.actions.CounterActionIncrease
import counterexample.sample.counterexample.reducers.counterReducer
import counterexample.sample.counterexample.state.AppState
import tw.geothings.rekotlin.Store
import tw.geothings.rekotlin.StoreSubscriber

/**
 * Created by hurden on 10/08/2017.
 * Copyright © 2016 GeoThings. All rights reserved.
 */

// The global application store, which is responsible for managing the application state.
val mainStore = Store(
        reducer = ::counterReducer,
        state = null
)

class MainActivity : AppCompatActivity(), StoreSubscriber<AppState> {

    private val counterLabel: TextView by lazy {
        this.findViewById(R.id.counter_label) as TextView
    }

    private val buttonUp: Button by lazy {
        this.findViewById(R.id.button) as Button
    }

    private val buttonDown: Button by lazy {
        this.findViewById(R.id.button2) as Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when either button is tapped, an action is dispatched to the store
        // in order to update the application state
        this.buttonUp.setOnClickListener {
            mainStore.dispatch(CounterActionIncrease())
        }
        this.buttonDown.setOnClickListener {
            mainStore.dispatch(CounterActionDecrease())
        }

        // subscribe to state changes
        mainStore.subscribe(this)
    }

    override fun newState(state: AppState) {
        // when the state changes, the UI is updated to reflect the current state
        this.counterLabel.text = "${state.counter}"
    }
}
