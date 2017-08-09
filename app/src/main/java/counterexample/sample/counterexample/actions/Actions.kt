package counterexample.sample.counterexample.actions

import tw.geothings.rekotlin.Action

/**
 * Created by hurden on 10/08/2017.
 * Copyright © 2016 GeoThings. All rights reserved.
 */

// all of the actions that can be applied to the state
data class CounterActionIncrease(val unit: Unit = Unit): Action
data class CounterActionDecrease(val unit: Unit = Unit): Action