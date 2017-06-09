package edu.mum.cs545.ws;

import javax.json.Json;
import javax.json.JsonObject;

public class Message {
    private Message() {
    }

    public static JsonObject error(String content) {
        return Json.createObjectBuilder().add("error", content).build();
    }

    public static JsonObject success(String content) {
        return Json.createObjectBuilder().add("success", content).build();
    }
}
