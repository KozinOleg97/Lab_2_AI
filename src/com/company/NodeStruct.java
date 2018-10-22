package com.company;

import java.util.HashMap;
import java.util.Map;

public class NodeStruct {
    String name;
    Map<String, String> atrs = new HashMap<String, String>();

    public NodeStruct() {
        name = "-";
    }

    public NodeStruct(String name) {
        this.name = name;
    }

    public void addAtr(String key, String value) {
        atrs.put(key, value);
    }

    public Map<String, String> getAtrs(){
       return atrs;
    }

    public void clear() {
        name = "-";
        atrs.clear();
    }
}
