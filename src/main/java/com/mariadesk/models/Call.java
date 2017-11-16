package com.mariadesk.models;

import javax.persistence.*;

@Entity
@Table(name = "CALLS")
public class Call {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "CALL_FROM")
    private String from;
    @Column(name = "CALL_TO")
    private String to;
    private String externalCallId;
    private String accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getExternalCallId() {
        return externalCallId;
    }

    public void setExternalCallId(String externalCallId) {
        this.externalCallId = externalCallId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", externalCallId='" + externalCallId + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
