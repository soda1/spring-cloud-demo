package com.soda.cloud.pojo;


public class Book {

    private Integer id;

    private String name;

    private Integer cardId;




    public void setName(String name) {
        this.name = name;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
