package commandsPack;

import exceptionsPack.EmptyStringException;
import parserPack.StringParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class storing method executeScript
 */
public class ExecuteScript extends Save implements commandInterfacePack.ExecuteScript {
    protected ExecuteScript() {}

    /**
     * This method changes the reader to get data from file
     */
    @Override
    public void executeScript() {
        try {
            String fileName = StringParser.parse(reader.next());
            if (readingFromFile) fileCallsCount++;
            if (fileCallsCount > 100) {
                System.err.println("Too many file calls");
                fileCallsCount = 0;
                return;
            }
            reader = new Scanner(new FileReader(fileName));
            readingFromFile = true;
        } catch (EmptyStringException e) {
            System.err.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("No such file");
        }
    }
}
