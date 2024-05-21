package commandsPack;

import mainPack.MovieCollection;

/**
 * Class storing method clear
 */
public class Clear extends RemoveById implements commandInterfacePack.Clear {
    protected Clear() {}

    /**
     * This method erases previously stored collection (this doesn't affect file)
     */
    @Override
    public void clear() {
        collection = new MovieCollection();
    }
}
