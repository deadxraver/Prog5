package commandsPack;

/**
 * Class storing method exit
 */
public class Exit extends ExecuteScript implements commandInterfacePack.Exit {
    protected Exit() {}

    /**
     * This method simply stops the program
     */
    @Override
    public void exit() {
        System.exit(0);
    }
}
