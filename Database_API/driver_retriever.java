import java.util.*;
import java.io.*;
class driver_retriever{
    public static void main(String[] args){
        Data_Retriever dr = new Data_Retriever("user", "abc1234", "sample_data.csv");
        dr.read_csv();
        for (String val: args){
            if (val.startsWith("desc")){
                try{
                    System.out.println(dr.get_description(val.split("_")[1]));
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else if (val.startsWith("ingr")){
                try{
                    System.out.println(dr.get_ingredients(val.split("_")[1]));
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else if (val.startsWith("stepingr")){
                try{
                    dr.get_ingredients(val.split("_")[1]);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else if (val.startsWith("inst")){
                try{
                    System.out.println(dr.get_instructions(val.split("_")[1]));
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else if(val.startsWith("all")){
                Enumeration<String> food_item = dr.file_data.keys();
                while (food_item.hasMoreElements()){ 
                    String key = food_item.nextElement();
                    if (!dr.file_data.get(key)[0].equals("\n")){
                        System.out.println(dr.file_data.get(key)[0]);

                    }

                }
                System.out.println("Which recipe would you like to know about? ");
                Scanner sc = new Scanner(System.in);
                String recipe = sc.nextLine();
                System.out.println(dr.get_ingredients(recipe));

            }
            else{
                System.out.println(val + " is not a valid command");
                System.out.println("Valid commands are desc_ , ingr_, or inst_");
            }
        }
    }
}