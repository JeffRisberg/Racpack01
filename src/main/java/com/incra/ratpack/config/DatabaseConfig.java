package com.incra.ratpack.config;

/**
 * @author Jeff Risberg
 * @since 12/01/16
 */
public class DatabaseConfig {
    protected String host = "localhost";
    protected String user = "root";
    protected String password;
    protected String db = "myDB";

    public DatabaseConfig() {
    }

    public DatabaseConfig(String host, String user, String password, String db) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.db = db;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String toString() {
        return "Database " + this.host + " db " + this.db;
    }
}