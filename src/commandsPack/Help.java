package commandsPack;

/**
 * Class storing method help
 */
public class Help extends Command implements commandInterfacePack.Help {
    protected Help() {}

    /**
     * This method prints info about available commands
     */
    @Override
    public void help() {
        System.out.println("help : get info about commands\n" +
                "info : get info about collection\n" +
                "show : get all collection elements\n" +
                "add : add a new element to the collection\n" +
                "update id : update element by its id\n" +
                "remove_by_id id : remove element by its id\n" +
                "clear : clear collection\n" +
                "save : save collection to file\n" +
                "execute_script file_name : execute script\n" +
                "exit : stop the program without saving collection to file\n" +
                "remove_head : get first collection element and remove it from collection\n" +
                "add_if_max : add a new element to the collection if it is greater then max element\n" +
                "remove_lower : remove all elements lower than current\n" +
                "remove_all_by_oscars_count oscarsCount : remove all elements having the same oscarsCount field\n" +
                "max_by_mpaa_rating : get an element having max mpaaRating field\n" +
                "print_field_ascending_operator : get all operators ascending");
    }
}
