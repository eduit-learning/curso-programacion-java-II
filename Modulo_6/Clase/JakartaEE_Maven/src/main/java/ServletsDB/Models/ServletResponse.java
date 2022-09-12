package ServletsDB.Models;

import java.util.ArrayList;
import java.util.List;

public class ServletResponse<T> {
    private String message;
    private T content;

    private int statusCode;

    private List<ErrorKeyValuePair> errors;

    public ServletResponse() {
        this.errors = new ArrayList<>();
    }

    public ServletResponse(String message, T content, int statusCode) {
        this.setMessage(message);
        this.setContent(content);
        this.setStatusCode(statusCode);
        this.errors = new ArrayList<>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<ErrorKeyValuePair> getErrors() {
        return errors;
    }
}