package seminar06.Laptop.Cpu;

//#region imports
import java.util.ArrayList;
import java.util.List;
//#endregion

/**
 * Процессор
 */
public class Cpu{
    //#region fields
    private CpuManufacturer manufacturer;
    private Integer frequency;
    private Integer countOfCores;
    //#endregion

    //#region getters
    /**
     * Производитель процессоров
     * 
     * @return
     */
    public CpuManufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * частота процессора
     * 
     * @return
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * количество ядер
     * 
     * @return
     */
    public Integer getCountOfCores() {
        return countOfCores;
    }
    //#endregion

    //#region constructors
    public Cpu(CpuManufacturer manufacturer, Integer frequency, Integer countOfCores) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.countOfCores = countOfCores;
    }
    //#endregion 
    
    //#region overrides
    @Override
    public String toString() {
        return manufacturer + " " + frequency + "GHz " + countOfCores + " cores";
    }
    //#endregion

    //#region static members
    /** перечень тактовых частот процессоров */
    public static final int[] frequencies = { 2800, 3200, 3600, 4000, 4400 };
    
    /** количества ядер */
    public static final int[] counts = { 2, 4, 8, 12, 16 };
    
    /**
     * создает список процессоров
     * 
     * @return
     */
    public static List<Cpu> getList() { 
        int[] frequencies = { 2800, 3200, 3600, 4000, 4400 };
        int[] counts = { 2, 4, 8, 12, 16 };
        List<Cpu> cpuList = new ArrayList<>();
        for (CpuManufacturer manufacturer : CpuManufacturer.values()) {
            for (Integer frequency : frequencies) {
                for (Integer count : counts) {
                    cpuList.add(new Cpu(manufacturer, frequency, count));
                }
            }
        }
        return cpuList;
    }
    //#endregion
}
