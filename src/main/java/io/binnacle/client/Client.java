package io.binnacle.client;

import io.binnacle.client.resources.Event;
import io.binnacle.client.resources.Recents;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Entry point into the application.
 */
public class Client {

    private Configuration configuration = null;

    public Client() {
        configuration = new Configuration();
    }

    public Client(String account, String appId, String apiKey, String apiSecret, String url) {
        configuration = new Configuration(account, appId, apiKey, apiSecret, url);
    }

    public JSONObject signal(String contextId, String eventName, String clientId, String sessionId, String logLevel) {
        return signal(contextId, eventName, clientId, sessionId, logLevel, null, null);
    }

    public JSONObject signal(String contextId, String eventName, String clientId, String sessionId, String logLevel, Object[] tags, Map json) {
        Event event = new Event(configuration.getAccount(), configuration.getApp(), contextId,
            eventName, clientId, sessionId, logLevel, tags, json,
            configuration.getApiKey(), configuration.getApiSecret(), configuration.getUrl());

        return event.post().getObject();
    }

    public void signalAsync(String contextId, String eventName, String clientId, String sessionId, String logLevel) {
        signalAsync(contextId, eventName, clientId, sessionId, logLevel, null, null);
    }

    public void signalAsync(String contextId, String eventName, String clientId, String sessionId, String logLevel, Object[] tags, Map json) {
        Event event = new Event(configuration.getAccount(), configuration.getApp(), contextId,
            eventName, clientId, sessionId, logLevel, tags, json,
            configuration.getApiKey(), configuration.getApiSecret(), configuration.getUrl());

        event.postAsync();
    }

    public JSONArray recents(String contextId, int lines) {
        return recents(contextId, lines, "");
    }

    public JSONArray recents(String contextId, int lines, String since) {
        Recents recents = new Recents(contextId, lines, since, configuration.getUrl(), configuration.getApiKey(), configuration.getApiSecret(),
            configuration.getAccount(), configuration.getApp());

        return recents.get().getArray();
    }

    public void reportException(Exception exception, Map env) {
      //Resource.postAsync()
    }
}