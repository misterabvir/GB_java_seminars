package seminar06.Laptop.Os;

//#region
import java.util.ArrayList;
import java.util.List;
//#endregion

/** версии windows */
public enum OsWindowsVersion {
    Home10,
    Pro10,    
    Enterprise10,    
    Home11,
    Pro11,
    Enterprise11;

    //#region static methods
    /** получение списка версий */
    public static List<String> getVersions()
    {
        List<String> vers = new ArrayList<>();
        for (OsWindowsVersion ver : OsWindowsVersion.values()) {
            vers.add(ver.toString());
        }
        return vers;
    }
    //#endregion
}
