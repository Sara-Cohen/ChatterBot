import java.util.Scanner;

class Chat{
    public static void main(String[] args) {
        String [] replayBot1={ "what ", "say I should say " };
        String [] replayBot2= { "whaaat ", "say say " };
        String [] legallReplay={"say <phrase>? okay:<phrase> "," you say <phrase>,  i say <phrase>","<phrase>nice!"};
        ChatterBot[] bots=new ChatterBot[2];
        bots[0]=new ChatterBot("Sara",legallReplay,replayBot1);
        bots[1]=new ChatterBot("Racheli",legallReplay,replayBot2);
        Scanner in=new Scanner(System.in);
        String statement=in.nextLine();
        while (true){
            for (ChatterBot bot: bots)
            {
                statement=bot.replyTo(statement);
                System.out.println(bot.getName()+":"+ statement);
                in.nextLine();

            }

        }
    }
}