package com.biniam.service

import grails.test.mixin.TestFor
import org.apache.http.HttpStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(RestApiService)
class RestApiServiceSpec extends Specification {

    void "test get batch"() {

        when:
        def response = service.restart('BI1234')

        then:
        response.status == HttpStatus.SC_OK
    }
}
