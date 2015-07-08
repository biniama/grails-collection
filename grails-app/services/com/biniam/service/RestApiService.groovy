package com.biniam.service

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class RestApiService {

    def serviceMethod() {

        String url = "https://foo.com/batch/$id"

        def response = new RestBuilder().get(url) {

            header 'Authorization', 'Basic base64EncodeUsername&Password'
        }

    }
}
