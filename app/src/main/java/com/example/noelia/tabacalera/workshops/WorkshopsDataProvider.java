package com.example.noelia.tabacalera.workshops;

/**
 * Created by Noelia on 13/08/2016.
 */
public class WorkshopsDataProvider {

    private String iconUrl, imageUrl;
    private String name, schedule, description;

    public WorkshopsDataProvider(String iconUrl, String name, String schedule, String description, String imageUrl) {
        this.iconUrl = iconUrl;
        this.schedule = schedule;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
