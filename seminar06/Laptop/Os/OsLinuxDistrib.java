package seminar06.Laptop.Os;

//#region imports
import java.util.ArrayList;
import java.util.List;
//#endregion

/** версии линукс */
public enum OsLinuxDistrib {
    Debian,
    Prm,
    Pacman;

    //#region static methods
    /** список версий */
    public static List<String> getVersions()
    {
        List<String> vers = new ArrayList<>();
        for (OsLinuxDistrib ver : OsLinuxDistrib.values()) {
            vers.add(ver.toString());
        }
        return vers;
    }
    //#endregion
}
