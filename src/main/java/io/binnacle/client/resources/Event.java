package io.binnacle.client.resources;

import org.json.JSONObject;
import java.util.Map;
import java.util.HashMap;

public class Event extends Resource {
    protected String accountId = "";
    protected String appId = "";
    protected String contextId = "";
    protected String eventName = "";
    protected String clientId = "";
    protected String sessionId = "";
    protected String clientEventTime = "";
    protected String ipAddress = "";
    protected String logLevel = "";
    protected Object[] tags = null;
    protected Map json = new HashMap();
    protected String eventTime = "";

    public Event() {}

    public Event(String accountId, String appId, String contextId, String eventName, String clientId, String sessionId,
        String logLevel, Object[] tags, Map json, String apiKey, String apiSecret, String baseUrl) {

        this.accountId = accountId;
        this.appId = appId;
        this.contextId = contextId;
        this.eventName = eventName;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.logLevel = logLevel;
        this.tags = tags;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return "/api/events/"+ accountId + "/" + appId + "/" + contextId;
    }

    public String getBody() {
        Map body = new HashMap();
        body.put("accountId", accountId);
        body.put("appId", appId);
        body.put("contextId", contextId);
        body.put("sessionId", sessionId);
        body.put("clientEventTime", clientEventTime);
        body.put("eventName", eventName);
        body.put("clientId", clientId);
        body.put("logLevel", logLevel);
        body.put("tags", tags);
        body.put("json", json);

        JSONObject j = new JSONObject(body);
        return j.toString();
    }
}
