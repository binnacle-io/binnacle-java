package io.binnacle.client.resources;

/**
 * Used to show recent lines from the item.
 */
public class Recents extends Event {

    private String lines = "";
    private String since = "";

    public String getBody() {
      /*
        def body = ['limit': lines, 'since': since]

        JsonOutput.toJson(body)
        */
        return "";
    }

    public String getUrl() {
        return "/api/events/" + accountId + "/" + appId + "/recents";
    }
}