package seminar06.Laptop.Os;

/** система линукс */
public class OsLinux extends Os {

    /** версия линукс */
    private OsLinuxDistrib distrib;

    //#region constructors
    public OsLinux(OsLinuxDistrib distrib){
        this.distrib = distrib;
    }
    //#endregion
    
    //#region overrides
    @Override
    public String getName() {
        return "Linux";
    }

    @Override
    public String getVersion() {
        return distrib.toString();
    }
    //#endregion
}
