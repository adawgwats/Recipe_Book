import java.util.Scanner;
class testing{
    public static void main(String[] args){
        Data_Retriever dr = new Data_Retriever("user", "abc1234", "sample_data.csv");
        dr.read_csv();

        Scanner sc = new Scanner(System.in);
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
        if (choice == 1) System.out.println("\n The ingredient(s) for " + recipe+ " is " + dr.get_ingredients(recipe) + ".");
        else if (choice == 2) System.out.println("\n" + recipe + " is(are) " + dr.get_description(recipe) + ".");
        else System.out.println("\n" + "To make " + recipe + " " + dr.get_instructions(recipe) + ".");
    }
}