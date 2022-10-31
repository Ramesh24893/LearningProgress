public class Check {
    public static void main(String[] args) {
        //Check check=new Check();
   //     check.createSeat(5);
        Default def = new Default();
            def.createDefaultStations();
            def.createDefaultTrains();
            def.createDefaultUsers();

        RailwayDataBase dat=new RailwayDataBase();
        System.out.println(countAvailableTickets(dat.getTrain(2000)));
    }
    public static int countAvailableTickets(Train train){
        //ArrayList<Seat> seats=train.seats;
        return train.seats.size();
    }





//    public ArrayList<Seat> createSeat(int count){
//        ArrayList<Seat> seats=new ArrayList<>();
//        for(int seatNo=1;seatNo<=count;seatNo++){
//            Seat seat=new Seat(seatNo,new ArrayList<>());
//            seats.add(seat);
//        }
//        return seats;
//    }
}
