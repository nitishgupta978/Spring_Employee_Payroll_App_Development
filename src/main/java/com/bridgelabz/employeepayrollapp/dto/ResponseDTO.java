package com.bridgelabz.employeepayrollapp.dto;

/**
 * @author :John,
 * date :03:06:2022
 */
public class ResponseDTO {
    private String message;
    private Object data;

    /**
     *
     * @param message ,Create one ResponseDTO class for display only message and data on your user
     * @param data
     */
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    /**
     * create one constructor methode
     * @return message
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    /**
     * create getter setter methode
     */
}
