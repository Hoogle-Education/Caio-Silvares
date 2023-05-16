package models;

import models.annotations.JsonIgnore;
import models.annotations.JsonKey;
import models.annotations.JsonParser;
import models.annotations.Jsonable;

@Jsonable
public class Car {

    @JsonKey(value = "plate")
    private String Id;
    private String holder;
    @JsonKey(value = "releaseYear")
    private Integer year;
    @JsonIgnore
    private String holderDocumentId;

    public Car(String id, String holder, int year, String holderDocumentId) {
        Id = id;
        this.holder = holder;
        this.year = year;
        this.holderDocumentId = holderDocumentId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHolderDocumentId() {
        return holderDocumentId;
    }

    public void setHolderDocumentId(String holderDocumentId) {
        this.holderDocumentId = holderDocumentId;
    }

    @JsonParser
    private void nameParser() {
        this.holder = holder.substring(0, 1).toUpperCase()
                + holder.substring(1).toLowerCase();
    }
}
