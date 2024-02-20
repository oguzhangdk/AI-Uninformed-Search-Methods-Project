import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which puzzle would you like to choose? (Enter a number between 1-10)(Use 0 to generate Random.):" );
        int puzzleNumber = scanner.nextInt();
        
        int[] selectedPuzzle = getPuzzle(puzzleNumber);
        
    //SEÇİLEN START STATE YAZDIRMA
        System.out.println("Selected start state:");
    for (int i = 0; i < 9; i++) {
    System.out.print(selectedPuzzle[i] + " ");
    if ((i + 1) % 3 == 0) {
        System.out.println();
    }
    }
        
        System.out.println("\n"+"Which search algorithm would you like to use?");
        System.out.println("1. Breadth-First Search");
        System.out.println("2. Depth-First Search");
        System.out.println("3. Depth-Limited Search");
        System.out.println("4. Iterative Deepening Search");

        int searchAlgorithmChoice = scanner.nextInt();
        
        Node root= new Node(selectedPuzzle,0);
        
        UninformedSearch ui = new UninformedSearch();
        List<Node> solution = null;

        switch (searchAlgorithmChoice) {
            case 1:
                solution = ui.BreadthFirstSearch(root);
                break;
            case 2:
                solution = ui.DepthFirstSearch(root);
                break;
            case 3:
                System.out.println("Specify max depth: ");
                int maxDepth = scanner.nextInt();
                solution = ui.DepthLimitedSearch(root, maxDepth);
                break;
            case 4:
                solution = ui.IterativeDeepeningSearch(root);
                break;
            default:
                System.out.println("Invalid search algorithm selection");
                break;
        }
       
    
    //If you want to see the states from the initial state to the goal state.
    System.out.println("Tracing path...");
    if(solution.size()>0){
        
        // initial kısmını ilkten göstermek için tracing path i tersine çevirmek için kod
        Collections.reverse(solution);
        
        
        for(int i =0;i<solution.size();i++)
            solution.get(i).PrintPuzzle();
    }
    else{
        System.out.println("No path to solution is found");
    }
    }
    
    
    //A random problem generator
    public int[] randomArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = 8; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
    
    
     public static int[] getPuzzle(int puzzleNumber) {
        int[] puzzle;

        switch (puzzleNumber) {
            case 1:
                puzzle = new int[]{1, 2, 4, 3, 0, 5, 7, 6, 8};
                break;
            case 2:
                puzzle = new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8};
                break;
            case 3:
                puzzle = new int[]{7, 0, 8, 4, 6, 1, 5, 3, 2};
                break;
            case 4:
                puzzle = new int[]{1, 0, 3, 4, 2, 5, 7, 8, 6};
                break;
            case 5:
                puzzle = new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8};
                break;
            case 6:
                puzzle = new int[]{2, 8, 1, 4, 6, 3, 0, 7, 5};
                break;
            case 7:
                puzzle = new int[]{4, 3, 2, 1, 0, 5, 7, 8, 6};
                break;
            case 8:
                puzzle = new int[]{6, 4, 7, 8, 5, 0, 3, 2, 1};
                break;
            case 9:
                puzzle = new int[]{1, 2, 0, 3, 4, 5, 6, 7, 8};
                break;
            case 10:
                puzzle = new int[]{7, 2, 4, 5, 0, 6, 8, 3, 1};
                break;
                case 0:
                    int [] init = new int[]{1, 2, 4, 3, 0, 5, 7, 6, 8};
                    MainClass a = new MainClass();
                    puzzle=a.randomArray(init);
                break;
            default:
                throw new IllegalArgumentException("Invalid puzzle number: " + puzzleNumber);
        }

        return puzzle;
    }
    
    }

    
    
    

