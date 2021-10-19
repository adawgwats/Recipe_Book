import java.util.Scanner;
class testing{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Data_Writer dw = new Data_Writer("sample_data.csv");
        
        System.out.println("Would you like to update the recipe book? (y/n)");
        String write = sc.nextLine();
        while(write.equals("y")){
            dw.set(sc);
            dw.write_csv();
            System.out.println("Any more recipes to add? (y/n)");
            write = sc.nextLine();
        }
        Data_Retriever dr = new Data_Retriever("user", "abc1234", "sample_data.csv");
        dr.read_csv();
        System.out.println("Which recipe would you like to know about?");
        String recipe = sc.nextLine();

        boolean again = true;

        while(again){
            if (dr.notHere(recipe)){
                System.out.println("The recipe for " + recipe + " does not exist yet.");
                System.out.println("Would you like to try again? (y/n)");
                String tryAgain = sc.nextLine();
                while(!tryAgain.equals("y") && !tryAgain.equals("n")){
                    System.out.println("Invalid entry. Please enter (y) for yes and (n) for no.");
                    tryAgain = sc.nextLine();
                }
                if (tryAgain.equals("y")){
                    System.out.println("Enter a new recipe:");
                    recipe = sc.nextLine();
                }
                else return;
            }
            else{
                again = false;
            }
        }
        System.out.println("What would you like to know about " + recipe + "\n");
        System.out.println("1) Ingredients");
        System.out.println("2) Descriptions");
        System.out.println("3) Instructions\n");

        int choice = sc.nextInt();

        while(choice != 1 && choice != 2 && choice !=3){
            System.out.println("Please enter (1) for ingredients, (2) for Descriptions and (3) for instructions of the recipe.");
            choice = sc.nextInt();
        }
        if (choice == 1) System.out.println("\nThe ingredient(s) for " + recipe+ " is " + dr.get_ingredients(recipe) + ".");
        else if (choice == 2) System.out.println("\n" + recipe + " is(are) " + dr.get_description(recipe) + ".");
        else {
            System.out.println("Would you like me to go through the instruction step by step? (y/n)");

            String step = sc.next();

            if (step.equals("y")){
                String ins = (String) dr.get_instructions(recipe);
                System.out.println("Here are the instructions for " + recipe + " step-by-step");
                int j = 0;
                for (int i = 1; i < ins.length();i++){
                    if (Character.isDigit(ins.charAt(i))){
                        System.out.println(ins.substring(j, i));
                        j = i;
                    }
                }
                System.out.println(ins.substring(j,ins.length()));
            }
            else{
                System.out.println("\n" + "To make " + recipe + " " + dr.get_instructions(recipe) + ".");
            }
        }
    }
}