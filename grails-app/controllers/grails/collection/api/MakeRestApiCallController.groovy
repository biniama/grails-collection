package grails.collection.api

import grails.plugins.rest.client.RestBuilder

class MakeRestApiCallController {

    /**
     * Plugin:
     *      compile ":rest-client-builder:2.1.1"
     *
     *      https://grails.org/plugin/rest-client-builder
     *
     *
     * @return JSON
     */
    def index() {

        RestBuilder rest = new RestBuilder()

        /** WORKAROUND
         *
         * error:
         * "org.springframework.http.converter.HttpMessageNotReadableException: Could not read JSON: java.lang.IllegalStateException: Expected a string but was BEGIN_OBJECT at line 1 column 2;
         *
         * found from: https://jira.grails.org/browse/GPREST-13
         * */
        rest.restTemplate.messageConverters.removeAll {
            it.class.name == 'org.springframework.http.converter.json.GsonHttpMessageConverter'
        }

        String url = "http://api.bigoven.com/recipes"
        String apiKey = "T117Gs07Yw6aZnnzi9Rhu5j371p8YIyE"
        String keyword = "lasagna"
        String requestPerPage = "25"
        String page = "1"

        def resp = rest.get('http://api.bigoven.com/recipes?pg=1&rpp=25&title_kw=lasagna&api_key=T117Gs07Yw6aZnnzi9Rhu5j371p8YIyE') {
            accept 'application/json'
        }

        render resp.json
    }
}