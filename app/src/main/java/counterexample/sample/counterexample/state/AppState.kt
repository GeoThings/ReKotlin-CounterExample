package counterexample.sample.counterexample.state

import tw.geothings.rekotlin.StateType

/**
 * Created by hurden on 10/08/2017.
 * Copyright © 2016 GeoThings. All rights reserved.
 */

data class AppState(
        val counter: Int = 0
): StateType