package com.lsp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "人")
public class Person {
    @ApiModelProperty(name = "身份证",required = true)
    private String id;

    @ApiModelProperty(name = "姓")
    private String last_name;

    @ApiModelProperty(name = "名")
    private String first_name;

    @ApiModelProperty(name = "朋友")
    private List<Person> friends;

    @ApiModelProperty(name = "说话")
    private List<String> say;

    public List<String> getSay() {
        return say;
    }

    public void setSay(List<String> say) {
        this.say = say;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
