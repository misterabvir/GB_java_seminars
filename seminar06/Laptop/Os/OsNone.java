package seminar06.Laptop.Os;

/** без системы */
public class OsNone extends Os {

    //#region overrides
    @Override
    public String getName() {
        return "none";
    }

    @Override
    public String getVersion() {
        return "\b";
    }
    //#endregion
}
