package io.binnacle.client.resources;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * HttpRunner on the app.
 */
public class HttpRunner implements Runnable {

    private String baseUrl;
    private String url;
    private String body;
    private String apiKey;
    private String apiSecret;

    public HttpRunner(String baseUrl, String url, String body, String apiKey, String apiSecret) {
        this.baseUrl = baseUrl;
        this.url = url;
        this.body = body;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    @Override
    public void run() {
        execute();
    }

    public JsonNode execute() {
        JsonNode node = null;

        // Object to Json response
        try {
            HttpResponse<JsonNode> postResponse = Unirest.post(baseUrl + url)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .basicAuth(apiKey, apiSecret)
                    .body(body)
                    .asJson();

            node = postResponse.getBody();
        } catch (UnirestException e) {
            node = new JsonNode("{success : false, message: \"" + e.getMessage() + "\"}");
        }

        return node;
    }
}