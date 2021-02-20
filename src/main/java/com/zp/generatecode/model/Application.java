package com.zp.generatecode.model;

/**
 * @Author zp
 * @create 2021/2/20 16:06
 */
public class Application {
    private String packageName;
    private DB db;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
}
