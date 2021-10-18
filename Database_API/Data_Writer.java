
import java.io.*;
import java.util.*;

class Data_Writer{
    String name;
    String descriptions;
    String ingredients;
    String instructions;

    String database_path;


	public void setName(String name) {
		this.name = name;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void setDatabase_path(String database_path) {
		this.database_path = database_path;
	}

    public void set (Scanner sc){
        System.out.println("What is the name of the recipe?");
        String temp = sc.nextLine();
        setName(temp);
        System.out.println("How would you describe the recipe?");
        temp = sc.nextLine();
        setDescriptions(temp);
        System.out.println("What do you use in your recipe?");
        temp  = sc.nextLine();
        setIngredients(temp);
        System.out.println("How do you make such recipe?");
        temp = sc.nextLine();
        setInstructions(temp);
    }


    public Data_Writer(String database_path){
        this.database_path = database_path;
    }

    public void write_csv(){
        try{
            FileWriter csvWriter = new FileWriter(this.database_path,true);
            csvWriter.append("\n"+ this.name + "," + this.descriptions + "," + this.ingredients + "," + this.instructions );
            csvWriter.flush();
            csvWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    

}