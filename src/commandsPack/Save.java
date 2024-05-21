package commandsPack;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class storing method save
 */
public class Save extends Clear implements commandInterfacePack.Save {
    protected Save() {}

    /**
     * This method saves current collection to history.xml
     */
    @Override
    public void save() {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(System.getenv("VAR")));){
            byte[] history = xStream.toXML(collection).getBytes();
            outputStream.write(history, 0, history.length);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            return;
        }
        System.out.println("Collection successfully saved!");
    }
}
