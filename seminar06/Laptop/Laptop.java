package seminar06.Laptop;

//#region imports
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seminar06.Laptop.Cpu.Cpu;
import seminar06.Laptop.Os.Os;
import seminar06.Laptop.Ram.Ram;
import seminar06.Laptop.Storage.Storage;
//#endregion

/** ноутбук */
public class Laptop {

    // #region private fields
    private Ram ram;
    private Cpu cpu;
    private Storage storage;
    private Os os;
    private LaptopManufacturer manufacturer;
    private String color;
    private Double screenSize;
    // #endregion

    // #region getters
    /**
     * Оперативная память
     * 
     * @return
     */
    public Ram getRam() {
        return ram;
    }

    /**
     * Процессор
     * 
     * @return
     */
    public Cpu getCpu() {
        return cpu;
    }

    /**
     * Жесткий диск
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Система
     * 
     * @return
     */
    public Os getOs() {
        return os;
    }

    /**
     * Производитель
     * 
     * @return
     */
    public LaptopManufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Цвет
     * 
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Размер экрана
     * 
     * @return
     */
    public Double getSize() {
        return screenSize;
    }
    // #endregion

    //#region constructors
    public Laptop(LaptopManufacturer manufacturer, Cpu cpu, Ram ram, Storage storage, Os os, String color,
            Double size) {
        this.manufacturer = manufacturer;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.screenSize = size;
    }
    //#endregion

    //#region overrides
    @Override
    public String toString() {
        return "\nManufacturer: " + manufacturer + "\n" +
                "CPU:            " + cpu + "\n" +
                "RAM:            " + ram + "\n" +
                "Hard disk:      " + storage + "\n" +
                "System:         " + os + "\n" +
                "Color:          " + color + "\n" +
                "Screen Size:    " + screenSize + "\"\n";
    }
    //#endregion

    // #region static members
    /** перечень размеров дисплеев */
    public static final Double[] sizes = { 11.6D, 12.5D, 14D, 17.3D, 18.4D };

    /** перечень цветов ноутбуков */
    public static final String[] colors = { "White", "Gray", "Steel", "Black" };

    /** список ноутбуков */
    private static List<Laptop> list;

    /**
     * создает и возвращает список ноутбуков
     * 
     * @return
     */
    public static List<Laptop> getList() {
        if (list == null) {
            list = new ArrayList<>();
            LaptopManufacturer[] manufacturers = LaptopManufacturer.values();
            List<Cpu> cpuList = Cpu.getList();
            List<Ram> ramList = Ram.getList();
            List<Storage> storageList = Storage.getList();
            List<Os> osList = Os.getList();

            Random rand = new Random();

            int max = 10000;
            int min = 2000;
            int amount = rand.nextInt(max - min) + min;
            for (int i = 0; i < amount; i++) {
                list.add(new Laptop(
                        manufacturers[rand.nextInt(manufacturers.length)],
                        cpuList.get(rand.nextInt(cpuList.size())),
                        ramList.get(rand.nextInt(ramList.size())),
                        storageList.get(rand.nextInt(storageList.size())),
                        osList.get(rand.nextInt(osList.size())),
                        colors[rand.nextInt(colors.length)],
                        sizes[rand.nextInt(sizes.length)]));
            }
        }
        return list;
    }
    // #endregion
}
