package com.quiz.Quiz_App;

import org.springframework.http.HttpStatus;

public class ResponseDTO<T> {
    private T body;
    private String message;
    private HttpStatus httpStatus;

    public ResponseDTO(T body, String message, HttpStatus httpStatus) {
        this.body = body;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResponseDTO() {
    }

    public ResponseDTO(T body, HttpStatus httpStatus) {
        this.body = body;
        this.httpStatus = httpStatus;
    }

    public ResponseDTO(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
