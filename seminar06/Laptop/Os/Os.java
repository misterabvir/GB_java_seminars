package seminar06.Laptop.Os;

//#region imports
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//#endregion

/** Система (абстрактный класс) */
public abstract class Os {
    
    //#region abstract methods
    /** получение наименование системы */
    public abstract String getName();
    /** получение версии системы */
    public abstract String getVersion();
    //#endregion

    //#region overrides
    @Override
    public String toString() {
        return getName() + " " + getVersion();
    }
    //#endregion

    //#region static methods
    /** возвращает список всех систем и их версий*/
    public static List<Os> getList() {
        List<Os> osList = new ArrayList<>();
        osList.add(new OsNone());
        for (OsLinuxDistrib distrib : OsLinuxDistrib.values()) {
            osList.add(new OsLinux(distrib));
        }        
        for (OsWindowsVersion version : OsWindowsVersion.values()) {
            osList.add(new OsWindows(version));
        }
        return osList;
    }

    /** возвращает имена систем */
    public static List<String> getNames(){
        Set<String> set = new HashSet<>();
        for (Os os : getList()) {
            set.add(os.getName());
        }
        return new ArrayList<>(set);
    }
    //#endregion
}
