package com.jocivaldias

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.orange.foundation.jvm", "com.jocivaldias")
		.start()
}

