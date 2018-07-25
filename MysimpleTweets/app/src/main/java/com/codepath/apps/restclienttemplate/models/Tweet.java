package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {
    public String body;
    public long uid;
    public String createdAt;
    public User user;

    //deserialize the json

    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException{
        Tweet tweet = new Tweet();
        ParseRelativeDate parseRelativeDate = new ParseRelativeDate();

        //extract the values from Json

        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = parseRelativeDate.getRelativeTimeAgo(jsonObject.getString("created_at"));
       // tweet.createdAt = jsonObject.getString("created_at");

        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
         return tweet;
    }
}
