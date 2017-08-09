package counterexample.sample.counterexample.reducers

import counterexample.sample.counterexample.actions.CounterActionDecrease
import counterexample.sample.counterexample.actions.CounterActionIncrease
import counterexample.sample.counterexample.state.AppState
import tw.geothings.rekotlin.Action

/**
 * Created by hurden on 10/08/2017.
 * Copyright © 2016 GeoThings. All rights reserved.
 */

// the reducer is responsible for evolving the application state based
// on the actions it receives
fun counterReducer(action: Action, state: AppState?): AppState {
    // if no state has been provided, create the default state
    var state = state ?: AppState()

    when(action){
        is CounterActionIncrease -> {
            state = state.copy(counter = state.counter + 1)
        }
        is CounterActionDecrease -> {
            state = state.copy(counter = state.counter - 1)
        }
    }

    return state
}