package mainPack;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

import commandsPack.AllCommands;


/**
 * Key class storing collection and key run method
 */
public class Program {

    /**
     * Key method that starts the program
     */
    public void run() throws NoSuchMethodException {
        AllCommands allCommands = new AllCommands();
        try {
            System.out.println("Welcome! Type help to get list of commands");
            allCommands.setReader(new Scanner(System.in));
            HashMap<String, Method> methods = new HashMap<>();
            methods.put("help", AllCommands.class.getMethod("help"));
            methods.put("info", AllCommands.class.getMethod("info"));
            methods.put("show", AllCommands.class.getMethod("show"));
            methods.put("add", AllCommands.class.getMethod("add"));
            methods.put("update", AllCommands.class.getMethod("update"));
            methods.put("remove_by_id", AllCommands.class.getMethod("removeById"));
            methods.put("clear", AllCommands.class.getMethod("clear"));
            methods.put("save", AllCommands.class.getMethod("save"));
            methods.put("execute_script", AllCommands.class.getMethod("executeScript"));
            methods.put("exit", AllCommands.class.getMethod("exit"));
            methods.put("remove_head", AllCommands.class.getMethod("removeHead"));
            methods.put("add_if_max", AllCommands.class.getMethod("addIfMax"));
            methods.put("remove_lower", AllCommands.class.getMethod("removeLower"));
            methods.put("remove_all_by_oscars_count", AllCommands.class.getMethod("removeAllByOscarsCount"));
            methods.put("max_by_mpaa_rating", AllCommands.class.getMethod("maxByMpaaRating"));
            methods.put("print_field_ascending_operator", AllCommands.class.getMethod("printFieldAscendingOperator"));
            while (true) {
                if (allCommands.isReadingFromFile() && !allCommands.getReader().hasNext()) {
                    allCommands.stopReadingFromFile();
                    allCommands.setReader(new Scanner(System.in));
                }
                Method command = methods.get(allCommands.getNextReaderWord());
                if (command != null) {
                    command.invoke(allCommands);
                } else {
                    System.out.println("No such command");
                }
            }
        } catch (InvocationTargetException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        catch (java.util.NoSuchElementException ignored) {
        }

    }
}
