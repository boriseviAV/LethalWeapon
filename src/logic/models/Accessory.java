package logic.models;

public class Accessory {
    private int accessoryId;
    private String name;
    private String description;
    private String pictureURL;

    public Accessory(int accessoryId, String name, String description, String pictureURL) {
        this(name, description, pictureURL);
        this.accessoryId = accessoryId;
    }

    public Accessory(String name, String description, String pictureURL) {
        this.name = name;
        this.description = description;
        this.pictureURL = pictureURL;
    }

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
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

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
