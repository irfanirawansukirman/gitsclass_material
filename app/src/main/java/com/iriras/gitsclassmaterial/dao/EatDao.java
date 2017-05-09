package com.iriras.gitsclassmaterial.dao;

/**
 * Created by irfan on 09/05/17.
 */

public class EatDao {
    private String name;
    private String description;
    private String image;
    private String like_count;
    private String comment_count;
    private String time_cooking;
    private String cheff;
    private String category;

    public EatDao(String name, String description, String image, String like_count, String comment_count, String time_cooking, String cheff, String category) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.time_cooking = time_cooking;
        this.cheff = cheff;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getTime_cooking() {
        return time_cooking;
    }

    public void setTime_cooking(String time_cooking) {
        this.time_cooking = time_cooking;
    }

    public String getCheff() {
        return cheff;
    }

    public void setCheff(String cheff) {
        this.cheff = cheff;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
