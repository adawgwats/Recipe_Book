import java.util.*;
import java.io.*;

class Data_Sender{
    String user_name;
    String database_path;
    String data_to_add ="";
    String password;
    Data_Retriever dr;

    public Data_Sender(String user_name, String password, String database_path){
        this.user_name = user_name;
        this.password = password;
        this.database_path = database_path;
    }

    void get_user_data(){
        boolean prompt = true;
        while(prompt){
            System.out.println("Please enter the name of your recipe or 'quit()' to exit");
            Scanner sc = new Scanner(System.in);
            String recipe = sc.nextLine();
            if (recipe.equals("quit()")){
                return;
            }
            System.out.println("Please enter the description for " + recipe);
            String description = sc.nextLine();
            System.out.println("Please enter the ingredients for " + recipe + " separated by ';' ");
            String ingredients = sc.nextLine();
            System.out.println("Please enter the instructions for " + recipe );
            String instructions = sc.nextLine();
            this.data_to_add += recipe + "," + description + "," + ingredients + ","+ instructions + "\n";
        }
        this.data_to_add = this.data_to_add.substring(0, this.data_to_add.length() - 1);
    }

    void add_to_csv(){
       try{
            FileWriter fstream = new FileWriter(this.database_path, true);
            BufferedWriter writer = new BufferedWriter(fstream);
            PrintWriter pwriter = new PrintWriter(writer);
            System.out.println(this.data_to_add);
            pwriter.println(this.data_to_add);
            pwriter.flush();
            pwriter.close();
       }   
        catch (IOException e){
            System.out.println(e);
        }
    }

    void read_csv(String path_to_csv){
        this.dr = new Data_Retriever(this.user_name, this.password, path_to_csv);
        this.dr.read_csv();
        Enumeration<String> food_item = this.dr.file_data.keys();
        while (food_item.hasMoreElements()){ 
            String key = food_item.nextElement();
            this.data_to_add += convert_array_to_string(this.dr.file_data.get(key)) + '\n';
        }
        this.data_to_add = this.data_to_add.substring(0, this.data_to_add.length() - 1);
    }

    String convert_array_to_string(String[] inarr){
        String return_string ="";
        for (String val: inarr){
            return_string += val + ",";
        }
        return return_string.substring(0, return_string.length() - 1);
    }
}
