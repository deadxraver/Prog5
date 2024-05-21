package commandsPack;

import elementsPack.Person;

import java.util.LinkedList;

/**
 * Class storing method printFieldAscendingOperator
 */
public class PrintFieldAscendingOperator extends MaxByMpaaRating implements commandInterfacePack.PrintFieldAscendingOperator {
    protected PrintFieldAscendingOperator() {}

    /**
     * This method prints operators ascending
     */
    @Override
    public void printFieldAscendingOperator() {
        LinkedList<Person> people = collection.getOperatorsSorted();
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
