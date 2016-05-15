package logic.models;

public class WeaponsAndCollections {
    private int weaponId;
    private int collectionId;

    public WeaponsAndCollections(int weaponId, int collectionId) {
        this.weaponId = weaponId;
        this.collectionId = collectionId;
    }

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }
}
