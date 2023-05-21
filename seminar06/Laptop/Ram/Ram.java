package seminar06.Laptop.Ram;

//#region imports
import java.util.ArrayList;
import java.util.List;
//#endregion

/**
 * Оперативная память
 */
public class Ram {
    //#region fields
    private Integer volume;
    private RamStandard standard;
    private int countOfMemoryModules;
    //#endregion

    //#region getters
    /**
     * Память одного модуля
     */
    public int getMemoryOfModule() {
        return volume;
    }

    /**
     * Стандарт оперативной памяти
     */
    public RamStandard getStandard() {
        return standard;
    }

    /**
     * количество модулей памяти
     */
    public int getCountOfMemoryModules() {
        return countOfMemoryModules;
    }

    /**
     * общий объем памяти
     */
    public int getVolumeTotal() {
        return volume * countOfMemoryModules;
    }
    //#endregion

    //#region constructors
    /**
     * создать RAM
     */
    public Ram(Integer memory, RamStandard mode, Integer countOfMemoryModules) {
        this.volume = memory;
        this.standard = mode;
        this.countOfMemoryModules = countOfMemoryModules;
    }
    //#endregion

    //#region overrides
    @Override
    public String toString() {
        return getVolumeTotal() + "Gb: " + volume + "Gb " + standard + " x " + countOfMemoryModules;
    }
    //#endregion
    
    //#region static members
    /** перечень объемов модулей памяти */
    public static final int[] volumes = { 1, 2, 4, 8, 16, 32 };
    
    /** перечень количества модулей памяти */
    public static final int[] counts = { 1, 2, 4 };
    
    /** список комбинаций плашек памяти */
    public static List<Ram> getList() {
        int[] volumes = { 1, 2, 4, 8, 16, 32 };
        int[] counts = { 1, 2, 4 };
        List<Ram> rams = new ArrayList<>();
        for (Integer volume : volumes) {
            for (RamStandard standard : RamStandard.values()) {
                for (Integer count : counts) {
                    rams.add(new Ram(volume, standard, count));
                }
            }
        }
        return rams;
    }
    //#endregion
}
