package com.airhacks.controller.util;


import javax.json.bind.annotation.JsonbPropertyOrder;
import java.util.UUID;

@JsonbPropertyOrder({
        "code", "msg", "id", "cause", "rowNumber"
})
public class ResponseJson {
    private String code;
    private String msg;
    private Long id;
    private String cause;
    private String rowNumber;
    private UUID uuid;

    public ResponseJson() {

    }

    public ResponseJson(String code, Long id, UUID uuid) {
        this.code = code;
        this.id = id;
        this.uuid = uuid;
    }

    public ResponseJson(String code, String msg, Long id, String cause, String rowNumber, UUID uuid) {
        this.code = code;
        this.msg = msg;
        this.id = id;
        this.cause = cause;
        this.rowNumber = rowNumber;
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}