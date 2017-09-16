package com.example.mohamedabdelaziz.realm;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohamed Abd Elaziz on 9/16/2017.
 */

public class ModelItem extends RealmObject {

    @PrimaryKey
    private String name ;
    private String phone ;
    private String email ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
