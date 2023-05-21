package seminar06.Laptop.Os;

/** систем Windows */
public class OsWindows extends Os{

    /** версия */
    private OsWindowsVersion version;

    //#region overrides
    @Override
    public String getName() {
        return "Windows";
    }

    @Override
    public String getVersion() {
        return version.toString();
    }
    //#endregion

    //#region constructors
    public OsWindows(OsWindowsVersion version){
        this.version = version;
    }
    //#endregion
}
