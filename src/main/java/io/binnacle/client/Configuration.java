package io.binnacle.client;

import org.apache.commons.lang3.StringUtils;

public class Configuration {
    /*
    public static DEFAULT_IGNORED_EXCEPTIONS = [
        "ActiveRecord::RecordNotFound",
        "ActionController::RoutingError",
        "ActionController::InvalidAuthenticityToken",
        "CGI::Session::CookieStore::TamperedWithCookie",
        "ActionController::UnknownHttpMethod",
        "ActionController::UnknownAction",
        "AbstractController::ActionNotFound",
        "Mongoid::Errors::DocumentNotFound",
        "ActionController::UnknownFormat",
        "Sinatra::NotFound"
    ];*/

    public Configuration() {}

    public Configuration(String account, String app, String apiKey, String apiSecret, String url) {
        this.account = account;
        this.app = app;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.url = url;
    }

    private String url;
    private String account;
    private String app;
    private String ctx;
    private String loggingCtx;
    private String errorCtx;
    private String apiKey;
    private String apiSecret;
    private Boolean log;
    private Boolean reportExceptions;
    private Boolean ignoredExceptions;
    private Boolean ignoreCascadePass;

    public void setUrl(String s) {
        url = s;
    }

    public String getUrl() {
        return StringUtils.isNotBlank(url) ? url : System.getenv("BINNACLE_URL");
    }

    public void setAccount(String s) {
        account = s;
    }

    public String getAccount() {
        return StringUtils.isNotBlank(account) ? account : System.getenv("BINNACLE_ACCOUNT");
    }

    public void setApp(String s) {
        app = s;
    }

    public String getApp() {
        return StringUtils.isNotBlank(app) ? app : System.getenv("BINNACLE_APP");
    }

    public void setCtx(String s) {
        ctx = s;
    }

    public String getCtx() {
        return StringUtils.isNotBlank(ctx) ? ctx : System.getenv("BINNACLE_CTX");
    }

    public void setLoggingCtx(String s) {
        loggingCtx = s;
    }

    public String getLoggingCtx() {
        return StringUtils.isNotBlank(loggingCtx) ? loggingCtx : System.getenv("BINNACLE_APP_LOG_CTX");
    }

    public void setErrorCtx(String s) {
        errorCtx = s;
    }

    public String getErrorCtx() {
        return StringUtils.isNotBlank(errorCtx) ? errorCtx : System.getenv("BINNACLE_APP_ERR_CTX");
    }

    public void setApiKey(String s) {
        apiKey = s;
    }

    public String getApiKey() {
        return StringUtils.isNotBlank(apiKey) ? apiKey : System.getenv("BINNACLE_API_KEY");
    }

    public void setApiSecret(String s) {
        apiSecret = s;
    }

    public String getApiSecret() {
        return StringUtils.isNotBlank(apiSecret) ? apiSecret : System.getenv("BINNACLE_API_SECRET");
    }

    public void setLog(Boolean s) {
        log = s;
    }

    public Boolean getLog() {
        String val = System.getenv("BINNACLE_JAVA_LOG");
        if (val != null) {
            return Boolean.valueOf(val);
        }
        else {
            return log;
        }
    }

    public void setReportExpectations(Boolean s) {
        reportExceptions = s;
    }

    public Boolean getReportExceptions() {
        String val = System.getenv("BINNACLE_REPORT_EXCEPTIONS");
        if (val != null) {
            return Boolean.valueOf(val);
        }
        else {
            return reportExceptions;
        }
    }

    public void setIgnoredExpectations(Boolean s) {
        ignoredExceptions = s;
    }

    public Boolean getIgnoredExceptions() {
        String val = System.getenv("BINNACLE_IGNORED_EXCEPTIONS");
        if (val != null) {
            return Boolean.valueOf(val);
        }
        else {
            return ignoredExceptions;
        }
    }

    public void setIgnoreCascadePass(Boolean s) {
        ignoreCascadePass = s;
    }

    public Boolean getIgnoreCascadePass() {
        if (ignoreCascadePass != null) {
            return ignoreCascadePass;
        }
        else {
            return Boolean.TRUE;
        }
    }
}