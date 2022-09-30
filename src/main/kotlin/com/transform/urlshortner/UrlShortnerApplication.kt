package com.transform.urlshortner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class UrlShortnerApplication

	fun main(args: Array<String>) {
		runApplication<UrlShortnerApplication>(*args)
	}

