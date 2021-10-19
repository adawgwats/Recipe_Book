class driver_sender{
    public static void main(String[] args){
         Data_Sender ds = new Data_Sender("user", "abc123", "sample_data.csv");
         if(args.length == 0){
             //Case that we wanted to have command line input
             ds.get_user_data();
             ds.add_to_csv();
         }
         else{
             try{
                 ds.read_csv(args[0]);
                 ds.add_to_csv();
             }
             catch(Exception e){
                 System.out.println(e);
             }
         }
    }
}