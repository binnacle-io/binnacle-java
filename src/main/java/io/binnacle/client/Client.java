package io.binnacle.client;

import io.binnacle.client.resources.Event;
import io.binnacle.client.resources.Recents;

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

    // def signal(String contextId, String eventName, String clientId, String sessionId, String logLevel, tags = [], json = [:]) {
    public void signal(String contextId, String eventName, String clientId, String sessionId, String logLevel) {
      Event event = new Event(configuration.getAccount(), configuration.getApp(), contextId,
        eventName, clientId, sessionId, logLevel, null, null,//tags, json,
        configuration.getApiKey(), configuration.getApiSecret(), configuration.getUrl());

      event.post();
    }
    /*
    def signalAsync(contextId, eventName, clientId, sessionId, logLevel, tags = [], json = [:]) {
      def event = new Event(accountId: configuration.account, appId: configuration.app, contextId: contextId,
        eventName: eventName, clientId: clientId, sessionId: sessionId, logLevel: logLevel, tags: tags, json: json,
        apiKey: configuration.apiKey, apiSecret: configuration.apiSecret, baseUrl: configuration.url)

      event.postAsync()
    }

    def recents(lines, since = null, context_id = null) {
      def recent = new Recents(lines : lines, since : since, baseUrl: configuration.url,
        apiKey: configuration.apiKey, apiSecret: configuration.apiSecret)

      recent.post()
    }

    def reportException(exception, env) {
      Resource.postAsync()
    }
    */
}