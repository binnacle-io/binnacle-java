package io.binnacle.client.resources;

import org.json.JSONObject;

import java.util.Map;
import java.util.HashMap;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Used to show recent lines from the item.
 */
public class Recents extends Event {

    private int lines = 10;
    private String since = "";

    public Recents(String contextId, int lines, String since) {
      this.lines = lines;
      this.since = since;
      this.contextId = contextId;
    }

    public Recents(String contextId, int lines, String since, String baseUrl, String apiKey, String apiSecret, String accountId, String appId) {
      this.lines = lines;
      this.since = since;
      this.baseUrl = baseUrl;
      this.apiKey = apiKey;
      this.apiSecret = apiSecret;
      this.accountId = accountId;
      this.appId = appId;
      this.contextId = contextId;
    }

    public String getBody() {
        Map body = new HashMap();
        body.put("limit", lines);
        body.put("since", since);

        JSONObject j = new JSONObject(body);
        return j.toString();
    }

    public String getUrl() {
        return "/api/events/" + accountId + "/" + appId + "/" + contextId + "/recents";
    }

    // TODO : Might need to mvoe this.
    public JsonNode get() {
        JsonNode node = null;
        // Object to Json response
        try {
            HttpResponse<JsonNode> postResponse = Unirest.get(baseUrl + getUrl())
                  .basicAuth(apiKey, apiSecret)
                  .queryString("limit", lines)
                  .queryString("since", since)
                  .asJson();

            node = postResponse.getBody();
        } catch (UnirestException e) {
            node = new JsonNode("{success : false, message: \"" + e.getMessage() + "\"}");
        }

        return node;
    }
}