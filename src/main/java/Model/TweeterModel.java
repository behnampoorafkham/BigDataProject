package Model;

import io.netty.handler.codec.Headers;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

public class TweeterModel extends Object{
    private UUID id;
    private String text;
    private Double tweeterId;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public TweeterModel() {
    }

    private Timestamp date;

    public Double getTweeterId() {
        return tweeterId;
    }

    public void setTweeterId(Double tweeterId) {
        this.tweeterId = tweeterId;
    }

    public TweeterModel(UUID id, String text, Timestamp date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }
}
