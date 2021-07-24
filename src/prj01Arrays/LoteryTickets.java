package prj01Arrays;

public class LoteryTickets {
    public static void main(String[] args) {
        int[] ticketNumbers = new int[1000];
        int[] winTickets = new int[10];

        for (int i = 0; i < 1000; i++) {
            ticketNumbers[i] = 1000000 + (int) (Math.round(1000000 * Math.random()));
            System.out.println(ticketNumbers[i]);
            if(i % 100 == 0){
                winTickets[i / 100] = ticketNumbers[i];
            }
        }

        System.out.println("===Win tickets===");
        for(int winTicket : winTickets){
            System.out.println(winTicket);
        }
    }
}
