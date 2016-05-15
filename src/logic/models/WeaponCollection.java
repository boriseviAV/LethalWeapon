package logic.models;

import java.util.List;

public class WeaponCollection {
    private int collectionId;
    private String name;
    private String pictureURL;

    private List<WeaponsAndCollections> weaponsAndCollectionsList;

    public WeaponCollection(int collectionId, String name, String pictureURL) {
        this(name, pictureURL);
        this.collectionId = collectionId;
    }

    public WeaponCollection(String name, String pictureURL) {
        this.name = name;
        this.pictureURL = pictureURL;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
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

    public List<WeaponsAndCollections> getWeaponsAndCollectionsList() {
        return weaponsAndCollectionsList;
    }

    public void setWeaponsAndCollectionsList(List<WeaponsAndCollections> weaponsAndCollectionsList) {
        this.weaponsAndCollectionsList = weaponsAndCollectionsList;
    }
}
