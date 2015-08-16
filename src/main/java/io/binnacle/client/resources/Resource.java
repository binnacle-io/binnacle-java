package io.binnacle.client.resources;

import com.mashape.unirest.http.*;

/**
 * This will be for post and async posting.
 */
public abstract class Resource {

    protected String baseUrl = null;
    protected String apiKey = null;
    protected String apiSecret = null;

    public JsonNode post() {
        HttpRunner runner = new HttpRunner(baseUrl, getUrl(), getBody(), apiKey, apiSecret);
        return runner.execute();
    }

    public void postAsync() {
        HttpRunner runner = new HttpRunner(baseUrl, getUrl(), getBody(), apiKey, apiSecret);

        Thread thread = new Thread(runner);

        thread.start();
    }

    public abstract String getUrl();
    public abstract String getBody();
}