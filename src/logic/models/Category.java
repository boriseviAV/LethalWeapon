package logic.models;

public class Category {
    private int categoryId;
    private String name;
    private String pictureURL;

    public Category(int categoryId, String name, String pictureURL) {
        this(name, pictureURL);
        this.categoryId = categoryId;
    }

    public Category(String name, String pictureURL) {
        this.name = name;
        this.pictureURL = pictureURL;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
