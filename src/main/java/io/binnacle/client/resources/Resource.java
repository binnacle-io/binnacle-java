package io.binnacle.client.resources;

import com.mashape.unirest.http.*;
/*
import groovyx.net.http.*
import static groovyx.net.http.Method.POST
import static groovyx.net.http.ContentType.XML
import static groovyx.net.http.ContentType.TEXT
import groovyx.net.http.HTTPBuilder
*/

/**
 * This will be for post and async posting.
 */
public abstract class Resource {

    protected String baseUrl = null;
    protected String apiKey = null;
    protected String apiSecret = null;

    public void post() {
        process();
    }

    public void postAsync() {
        //Thread.start {
            process();
        //}
    }

    /*

    private def process() {
        def success = true
        def returnValue
println "baseUrl :: $baseUrl"
        def http = new HTTPBuilder(baseUrl)
println "JOE >> $apiKey / $apiSecret"
        http.auth.basic apiKey, apiSecret
println "JOSEPH >>> " + getUrl()
        try {
            //log.debug "Data :: $data"
            http.request( POST ) { req ->
                uri.path = getUrl()

                requestContentType = groovyx.net.http.ContentType.JSON
                body = getBody()

                response.success = { resp, json ->
                    returnValue = json
                }
                response.'401' = { resp, json ->
                    success = false
                    println "WE HAD AN ERROR :: $resp / $json"
                }
                response.failure = { resp ->
                    success = false
                    println "WE HAD AN ERROR :: ${resp.data}"
                }
            }
        }
        catch ( HttpResponseException ex ) {
            success = false
            // default failure handler throws an exception:
            println "Unexpected response error: ${ex.statusCode} / ${ex.getMessage()}"
        }
        returnValue
    }*/

    private String process() {
        // Object to Json response
        try {
            HttpResponse<JsonNode> postResponse = Unirest.post(baseUrl + getUrl())
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .basicAuth(apiKey, apiSecret)
                    .body(getBody())
                    .asJson();
        } catch (Exception e) {

        }

        return "";
/*
        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
          .header("accept", "application/json")
          .queryString("apiKey", "123")
          .field("parameter", "value")
          .field("foo", "bar")
          .asJson();


        Unirest.post("http://httpbin.org/post")
              .queryString("name", "Mark")
              .field("last", "Polo")
              .asJson()
*/
    }

    public abstract String getUrl();
    public abstract String getBody();
}