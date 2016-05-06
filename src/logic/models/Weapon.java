package logic.models;

public class Weapon {
    private int weapon_id;
    private String model_name;
    private String holding_way;
    private String country;
    private String range;
    private String caliber;
    private int ammo_number;
    private String holder_kind;
    private boolean optics;
    private String stuff;
    private int collection_id;
    private String picture_url;

    public Weapon(){

    }

    public Weapon(int weapon_id, String model_name, String holding_way, String country, String range, String caliber, int ammo_number, String holder_kind, boolean optics, String stuff, int collection_id, String picture_url) {
        this.weapon_id = weapon_id;
        this.model_name = model_name;
        this.holding_way = holding_way;
        this.country = country;
        this.range = range;
        this.caliber = caliber;
        this.ammo_number = ammo_number;
        this.holder_kind = holder_kind;
        this.optics = optics;
        this.stuff = stuff;
        this.collection_id = collection_id;
        this.picture_url = picture_url;
    }

    public int getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(int weapon_id) {
        this.weapon_id = weapon_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getHolding_way() {
        return holding_way;
    }

    public void setHolding_way(String holding_way) {
        this.holding_way = holding_way;
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

    public int getAmmo_number() {
        return ammo_number;
    }

    public void setAmmo_number(int ammo_number) {
        this.ammo_number = ammo_number;
    }

    public String getHolder_kind() {
        return holder_kind;
    }

    public void setHolder_kind(String holder_kind) {
        this.holder_kind = holder_kind;
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

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
