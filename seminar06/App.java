package seminar06;

//#region imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import seminar06.Laptop.Laptop;
import seminar06.Laptop.LaptopManufacturer;
import seminar06.Laptop.Cpu.Cpu;
import seminar06.Laptop.Cpu.CpuManufacturer;
import seminar06.Laptop.Os.Os;
import seminar06.Laptop.Os.OsLinuxDistrib;
import seminar06.Laptop.Os.OsWindowsVersion;
import seminar06.Laptop.Ram.Ram;
import seminar06.Laptop.Ram.RamStandard;
import seminar06.Laptop.Storage.Storage;
import seminar06.Laptop.Storage.StorageManufacturer;
import seminar06.Laptop.Storage.StorageTechnology;
//#endregion

public class App {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Boolean again = true;
        List<Laptop> list = Laptop.getList();
        do {
            int input = mainMenu(list.size());
            switch (input) {
                case 0: {
                    sc.close();
                    again = false;
                    break;
                }
                case 1: {
                    list = filter(list, manufactureMenu());
                    break;
                }
                case 2: {
                    list = filter(list, cpuMenu());
                    break;
                }
                case 3: {
                    list = filter(list, ramMenu());
                    break;
                }
                case 4: {
                    list = filter(list, storageMenu());
                    break;
                }
                case 5: {
                    list = filter(list, osMenu());
                    break;
                }
                case 6: {
                    list = filter(list, colorMenu());
                    break;
                }
                case 7:
                    list = filter(list, sizeMenu());
                    break;
                case 8: {
                    list = Laptop.getList();
                    break;
                }
                case 9: {
                    System.out.println(list);
                    break;
                }
                default:
                    break;
            }
        } while (again);
    }

    /** меню фильтрации по размеру дисплея */
    private static Expression sizeMenu() {
        for (int i = 0; i < Laptop.sizes.length; i++) {
            System.out.println((i + 1) + ". " + Laptop.sizes[i].toString());
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Laptop.sizes.length;
        System.out.println("filtered by [" + Laptop.sizes[input] + "\"]");
        return (laptop) -> laptop.getSize() == Laptop.sizes[input];
    }

    /** меню фильтрации по цвету */
    private static Expression colorMenu() {
        for (int i = 0; i < Laptop.colors.length; i++) {
            System.out.println((i + 1) + ". " + Laptop.colors[i].toString());
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Laptop.colors.length;
        System.out.println("filtered by [" + Laptop.colors[input] + "]");
        return (laptop) -> laptop.getColor() == Laptop.colors[input];
    }

    /** меню выбора системы */
    private static Expression osMenu() {
        System.out.println("1. Filter by OS name");
        System.out.println("2. Filter by OS version");
        System.out.print(">");

        switch (sc.nextInt()) {
            case 1: {
                return osNameMenu();
            }
            case 2: {
                return osVersionMenu();
            }
            default:
                return (laptop) -> true;
        }
    }

    /** меню выбора версии системы */
    private static Expression osVersionMenu() {
        List<String> versions = new ArrayList<>(OsLinuxDistrib.getVersions());
        versions.addAll(OsWindowsVersion.getVersions());
        for (int i = 0; i < versions.size(); i++) {
            System.out.println(((i + 1) + ". " + versions.get(i)));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % versions.size();
        System.out.println("filtered by [" + versions.get(input) + "]");
        return (laptop) -> laptop.getOs().getVersion().toString() == versions.get(input);
    }

    /** меню выбора имени системы */
    private static Expression osNameMenu() {
        for (int i = 0; i < Os.getNames().size(); i++) {
            System.out.println(((i + 1) + ". " + Os.getNames().get(i)));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Os.getNames().size();
        System.out.println("filtered by [" + Os.getNames().get(input) + "]");
        return (laptop) -> laptop.getOs().getName() == Os.getNames().get(input);
    }

    /** меню выбора жесткого диска */
    private static Expression storageMenu() {
        System.out.println("1. Filter by Storage technology");
        System.out.println("2. Filter by Storage manufacture");
        System.out.println("3. Filter by Storage volume");
        System.out.print(">");

        switch (sc.nextInt()) {
            case 1: {
                return storageTechnologyMenu();
            }
            case 2: {
                return storageManufactureMenu();
            }
            case 3: {
                return storageVolumeMenu();
            }
            default:
                return (laptop) -> true;
        }
    }

    /** меню выбора размера жесткого диска */
    private static Expression storageVolumeMenu() {
        for (int i = 0; i < Storage.volumes.length; i++) {
            System.out.println(((i + 1) + ". " + Storage.volumes[i]));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Storage.volumes.length;
        System.out.println("filtered by [" + Storage.volumes[input] + " GB]");
        return (laptop) -> laptop.getStorage().getVolume() >= Storage.volumes[input];
    }

    /** меню выбора производителя жестких дисков */
    private static Expression storageManufactureMenu() {
        for (int i = 0; i < StorageManufacturer.values().length; i++) {
            System.out.println(((i + 1) + ". " + StorageManufacturer.values()[i]));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % StorageManufacturer.values().length;
        System.out.println("filtered by [" + StorageManufacturer.values()[input] + "]");
        return (laptop) -> laptop.getStorage().getManufacturer() == StorageManufacturer.values()[input];
    }

    /** меню выбора стандарта жесткого диска */
    private static Expression storageTechnologyMenu() {
        for (int i = 0; i < StorageTechnology.values().length; i++) {
            System.out.println(((i + 1) + ". " + StorageTechnology.values()[i]));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % StorageTechnology.values().length;
        System.out.println("filtered by [" + StorageTechnology.values()[input] + "]");
        return (laptop) -> laptop.getStorage().getTechnology() == StorageTechnology.values()[input];
    }

    /** меню выбора оперативной памяти */
    private static Expression ramMenu() {

        System.out.println("1. Filter by RAM Standards");
        System.out.println("2. Filter by RAM Volumes");
        System.out.println("3. Filter by RAM Counts");
        System.out.print(">");

        switch (sc.nextInt()) {
            case 1: {
                return ramStandardMenu();
            }
            case 2: {
                return ramVolumeMenu();
            }
            case 3: {
                return ramCountMenu();
            }
            default:
                return (laptop) -> true;
        }
    }

    /** меню выбора количества модулей оперативной памяти */
    private static Expression ramCountMenu() {
        for (int i = 0; i < Ram.counts.length; i++) {
            System.out.println(((i + 1) + ". " + Ram.counts[i]));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Ram.counts.length;
        System.out.println("filtered by [" + Ram.counts[input] + "]");
        return (laptop) -> laptop.getRam().getCountOfMemoryModules() >= Ram.counts[input];
    }

    /** меню выбора объема (полного) памяти */
    private static Expression ramVolumeMenu() {
        for (int i = 0; i < Ram.volumes.length; i++) {
            System.out.println(((i + 1) + ". " + Ram.volumes[i]));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Ram.volumes.length;
        System.out.println("filtered by [" + Ram.volumes[input] + " MB]");
        return (laptop) -> laptop.getRam().getVolumeTotal() >= Ram.volumes[input];
    }

    /** меню выбора стандарта оперативной памяти */
    private static Expression ramStandardMenu() {
        for (int i = 0; i < RamStandard.values().length; i++) {
            System.out.println(((i + 1) + ". " + RamStandard.values()[i]));
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % RamStandard.values().length;
        System.out.println("filtered by [" + RamStandard.values()[input] + "]");
        return (laptop) -> laptop.getRam().getStandard() == RamStandard.values()[input];
    }

    /** меню выбора процессора */
    private static Expression cpuMenu() {
        System.out.println("1. Filter by CPU Manufactories");
        System.out.println("2. Filter by CPU Frequency");
        System.out.println("3. Filter by CPU Cores");
        System.out.print(">");

        switch (sc.nextInt()) {
            case 1: {
                return cpuManufactureMenu();
            }
            case 2: {
                return cpuFrequencyMenu();
            }
            case 3: {
                return cpuCoreMenu();
            }
            default:
                return (laptop) -> true;
        }
    }

    /** меню выбора количества ядер процессора */
    private static Expression cpuCoreMenu() {
        for (int i = 0; i < Cpu.counts.length; i++) {
            System.out.println((i + 1) + ". " + Cpu.counts[i]);
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Cpu.counts.length;
        System.out.println("filtered by [" + Cpu.counts[input] + " cores]");
        return (laptop) -> laptop.getCpu().getCountOfCores() >= Cpu.counts[input];
    }

    /** меню выбора тактовой частоты процессора */
    private static Expression cpuFrequencyMenu() {
        for (int i = 0; i < Cpu.frequencies.length; i++) {
            System.out.println((i + 1) + ". " + Cpu.frequencies[i]);
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % Cpu.frequencies.length;
        System.out.println("filtered by [" + Cpu.frequencies[input] + " Hrz]");
        return (laptop) -> laptop.getCpu().getFrequency() >= Cpu.frequencies[input];
    }

    /** меню выбора производителя процессора */
    private static Expression cpuManufactureMenu() {
        for (int i = 0; i < CpuManufacturer.values().length; i++) {
            System.out.println((i + 1) + ". " + CpuManufacturer.values()[i].toString());
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % CpuManufacturer.values().length;
        System.out.println("filtered by [" + CpuManufacturer.values()[input] + "]");
        return (laptop) -> laptop.getCpu().getManufacturer() == CpuManufacturer.values()[input];
    }

    /** меню выбора производителя ноутбука */
    private static Expression manufactureMenu() {
        for (int i = 0; i < LaptopManufacturer.values().length; i++) {
            System.out.println((i + 1) + ". " + LaptopManufacturer.values()[i].toString());
        }
        System.out.print(">");
        int input = (sc.nextInt() - 1) % LaptopManufacturer.values().length;
        System.out.println("filtered by [" + LaptopManufacturer.values()[input] + "]");
        return (laptop) -> laptop.getManufacturer() == LaptopManufacturer.values()[input];
    }

    /** основное меню выбор критерия фильтрации */
    private static int mainMenu(int count) {
        System.out.println("(" + count + ") laptops found");
        System.out.println("1. Filter by Manufacture");
        System.out.println("2. Filter by CPU");
        System.out.println("3. Filter by RAM");
        System.out.println("4. Filter by Hard Drive");
        System.out.println("5. Filter by OS");
        System.out.println("6. Filter by Color");
        System.out.println("7. Filter by Screen size");
        System.out.println("8. Reset");
        System.out.println("9. Print result");
        System.out.println("0. Quit");
        System.out.print(">");
        return sc.nextInt();
    }

    /** фильтрует список ноутбуков по выбранному предикату */
    private static List<Laptop> filter(List<Laptop> list, Expression expression) {
        return list.stream().filter(p -> expression.isEqual(p)).collect(Collectors.toList());
    }
}
