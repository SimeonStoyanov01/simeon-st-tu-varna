package bg.tu_varna.commands;

import bg.tu_varna.sit.FileNotOpenedException;

public class HelpCommand  implements Command {

    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if(!OpenCommand.flagOpen){
            throw new FileNotOpenedException();
        }
        if(args.length==0) {
            printAll();
        }
    }

    private void printAll(){
        System.out.println(
                "The following commands are supported:\n" +
                        "open <file>                                        opens <file> \n" +
                        "close                                              closes currently opened file \n" +
                        "save                                               saves the currently open file\n" +
                        "saveas <file>                                      saves the currently open file in <file>\n" +
                        "help                                               prints this information\n" +
                        "exit                                               exits the program \n" +
                        "book <date> <starttime> <endtime> <name> <note>    Запазва час за среща с име <name> и коментар <note>\n" +
                        "                                                   на дата <date>с начален час <starttime> и краен час <endtime>. \n" +
                        "unbook <date> <starttime> <endtime>                Отменя час за среща на дата <date> с начален час <starttime>\n" +
                        "                                                   и краен час <endtime>.\n" +
                        "agenda <date>                                      Извежда хронологичен списък с всички ангажименти за деня <date>.\n" +
                        "change <date> <starttime> <option> <newvalue>      <option> е едно от date, starttime, enddate, name, note. \n" +
                        "                                                   Задава нова стойност <newvalue> на събитието на дата <date> с начален час <starttime>,\n" +
                        "                                                   като при промяна на дата и час се прави проверка дали са коректни и свободни.\n" +
                        "find <string>                                      Търсене на среща: извеждат се данните за всички срещи, в чието име или бележка се съдържа низът <string>\n" +
                        "holiday <date>                                     Датата <date> се отбелязва като неработна. \n" +
                        "busydays <from> <to>                               Извеждане на статистика за натовареност: по дадени начална дата <from> и крайна дата <to>\n" +
                        "                                                   се извежда списък с дните от седмицата, подредени по критерия “брой заети часове”. \n" +
                        "findslot <fromdate> <hours>                        Намиране на свободно място за среща: по дадена дата <fromdate> и желана продължителност \n" +
                        "                                                   на срещата <hours> търси дата, на която е възможно да се запази такава среща,\n" +
                        "                                                   но само в работни дни и не преди 8 часа или след 17 часа. \n" +
                        "findslotwith <fromdate> <hours> <calendar>         Намиране на свободно място за среща, синхронизирана с даден календар:\n" +
                        "                                                   по дадена дата <fromdate> и желана продължителност на срещата <hours> търси дата,\n" +
                        "                                                   на която е възможно да се запази такава среща в текущия календар и \n" +
                        "                                                   в календара, записан във файл <calendar>, \n" +
                        "                                                   но само в работни дни и не преди 8 часа или след 17 часа.\n" +
                        "merge <calendar>                                   Прехвърля всички събития от календара, записан във файл <calendar>,\n" +
                        "                                                   в текущия календар. Прехвърлянето да става в диалогов режим така, \n" +
                        "                                                   че ако има конфликт на събития потребителят да има възможност \n" +
                        "                                                   да избере кое събитие да остане и кое да се премести в друг ден и час.  \n");

    }

}