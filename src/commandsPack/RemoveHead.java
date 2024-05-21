package commandsPack;

/**
 * Class storing method removeHead
 */
public class RemoveHead extends Exit implements commandInterfacePack.RemoveHead{
    protected RemoveHead() {}

    /**
     * This method removes the first collection element if it has it
     */
    @Override
    public void removeHead() {
        if (!collection.getCollection().isEmpty()) {
            collection.removeElement(collection.getCollection().getFirst());
            System.out.println("Movie successfully deleted!");
            return;
        }
        System.out.println("Collection is empty!");
    }
}
