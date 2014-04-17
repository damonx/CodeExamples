package concurrentExamples.chapter2.sync2;

public class Main {


    public static void main(String[] args) {
          Cinema cinema = new Cinema();
          TicketOffice1 ticketoffice1 = new TicketOffice1(cinema);
          Thread thread1 = new Thread(ticketoffice1, "TicketOffice1");
          TicketOffice2 ticketoffice2 = new TicketOffice2(cinema);
          Thread thread2 = new Thread(ticketoffice2, "TicketOffice2");
          
          thread1.start();
          thread2.start();
          
          try{
              thread1.join();
              thread2.join();
          }catch(InterruptedException e){
               e.printStackTrace();
          }
          System.out.println("Room 1 vacancies: " + cinema.getVacanciesCinema1());
          System.out.println("Room 2 vacancies: " + cinema.getVacanciesCinema2());
          
    }

}
