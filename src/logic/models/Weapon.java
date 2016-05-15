package logic.models;

import java.util.List;

public class Weapon {
    private int weaponId;
    private String modelName;
    private String holdingWay;
    private String country;
    private String range;
    private String caliber;
    private int ammoNumber;
    private boolean optics;
    private String stuff;
    private int categoryId;
    private String pictureURL;

    private List<WeaponsAndCollections> weaponsAndCollectionsList;

    public Weapon(int weaponId, String modelName, String holdingWay, String country, String range, String caliber, int ammoNumber, boolean optics, String stuff, int categoryId, String pictureURL) {
        this(modelName, holdingWay, country, range, caliber, ammoNumber, optics, stuff, pictureURL);
        this.weaponId = weaponId;
        this.categoryId = categoryId;
    }

    public Weapon(String modelName, String holdingWay, String country, String range, String caliber, int ammoNumber, boolean optics, String stuff, String pictureURL) {
        this.modelName = modelName;
        this.holdingWay = holdingWay;
        this.country = country;
        this.range = range;
        this.caliber = caliber;
        this.ammoNumber = ammoNumber;
        this.optics = optics;
        this.stuff = stuff;
        this.pictureURL = pictureURL;
    }

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getHoldingWay() {
        return holdingWay;
    }

    public void setHoldingWay(String holdingWay) {
        this.holdingWay = holdingWay;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public int getAmmoNumber() {
        return ammoNumber;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }

    public boolean isOptics() {
        return optics;
    }

    public void setOptics(boolean optics) {
        this.optics = optics;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
