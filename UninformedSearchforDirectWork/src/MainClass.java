import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainClass {
    
    public static void main(String[] args) {
        
    int[] puzzle1 = {1, 2, 4,
                    3, 0, 5,
                    7, 6, 8};
    
    int[] puzzle2 = {1, 0, 2,
                     3, 4, 5,
                     6, 7, 8};
    
    int[] puzzle3 = {7, 0, 8,
                     4, 6, 1,
                     5, 3, 2};
    
    int[] puzzle4 = {1, 0, 3,
                     4, 2, 5,
                    7, 8, 6};
    
    int[] puzzle5 = {1, 2, 3,
                     4, 5, 6,
                     7, 0, 8};
    
    int[] puzzle6 = {2, 8, 1,
                     4, 6, 3,
                     0, 7, 5};
    
    int[] puzzle7 = {4, 3, 2,
                     1, 0, 5,
                     7, 8, 6};
    
    int[] puzzle8 = {6, 4, 7,
                     8, 5, 0,
                     3, 2, 1};
    
    
    int[] puzzle9 = {1, 2, 0,
                     3, 4, 5,
                     6, 7, 8};
    
    int[] puzzle10 = {7, 2, 4,
                     5, 0, 6,
                     8, 3 ,1};
    
    
    
    
    
    
    //IF YOU WANT A RANDOM PUZZLE INSTEAD OF PUZZLE 1, REMOVE THE COMMENT STARS.
    /*
    int[] puzzleRNDinit = {0, 1, 2,
                           3, 4, 5,
                           6, 7, 8};
    MainClass a = new MainClass();
    puzzle1=a.randomArray(puzzleRNDinit);
    
    
        
       //IF YOU WANT TO SEE OUR RANDOM PROBLEM AS AN ARRAY(RANDOM INITIAL STATE)
        for(int i=0 ; i<9 ; i++)
        System.out.print(puzzle1[i]);*/
        
        
   
    
    Node root= new Node(puzzle1,0);// KÖK NODE DERİNLİĞİ 0
    
    
    
    UninformedSearch ui=new UninformedSearch();
    
    //TO SELECT SEARCH, REMOVE THE COMMENT LINE MARK, PUT OTHERS IN THE COMMENT LINE
    
    List<Node> solution = ui.BreadthFirstSearch(root);
    
    //List<Node> solution = ui.DepthFirstSearch(root);
    
    //List<Node> solution = ui.DepthLimitedSearch(root,32);
    
    //List<Node> solution = ui.IterativeDeepeningSearch(root);
    
    
    
    /*
    //IF YOU WANT TO SEE THE STATES FROM THE INITIAL STATE TO THE GOAL STATE.PLEASE REMOVE COMMENT STARS
    
    System.out.println("Tracing path...");
    if(solution.size()>0){
        
        // initial kısmını ilkten göstermek için tracing path i tersine çevirmek için kod
        Collections.reverse(solution);
        
        
        for(int i =0;i<solution.size();i++)
            solution.get(i).PrintPuzzle();
    }
    else{
        System.out.println("No path to solution is found");
    }*/
        
    
   
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
    
    
    
    }

    
    
    

