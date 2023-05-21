package seminar06.Laptop.Storage;

//#region imports
import java.util.ArrayList;
import java.util.List;
//#endregion

/** жесткий диск */
public class Storage {
    //#region fields
    private StorageTechnology technology;
    private StorageManufacturer manufacturer;
    private Integer volume;
    //#endregion

    //#region getters
    /** стандарт ЖД */
    public StorageTechnology getTechnology() {
        return technology;
    }

    /** производитель ЖД */
    public StorageManufacturer getManufacturer() {
        return manufacturer;
    }

    /** объем ЖД */
    public Integer getVolume() {
        return volume;
    }
    //#endregion

    //#region constructors
    public Storage(StorageManufacturer manufacturer, StorageTechnology technology, Integer volume) {
        this.manufacturer = manufacturer;
        this.technology = technology;
        this.volume = volume;
    }
    //#endregion

    //#region overrides
    @Override
    public String toString() {
        return manufacturer + " " + technology + " " + volume + "Gb";
    }
    //#endregion

    //#region static members
    /** перечень объемов ЖД */
    public static final int[] volumes = { 512, 1024, 2048, 4096 };

    /** список ЖД */
    public static List<Storage> getList() {
        int[] volumes = { 512, 1024, 2048, 4096 };
        List<Storage> storages = new ArrayList<>();
        for (StorageManufacturer manufacturer : StorageManufacturer.values()) {
            for (StorageTechnology technology : StorageTechnology.values()) {
                for (Integer volume : volumes) {
                    storages.add(new Storage(manufacturer, technology, volume));
                }
            }
        }
        return storages;
    }
    //#endregion
}
