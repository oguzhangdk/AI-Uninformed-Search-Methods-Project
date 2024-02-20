import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oguzh
 */
public class UninformedSearch {
    
    int maxSizeFringe =1; //SE
    
    public UninformedSearch(){
        
    }
    
    public List<Node> BreadthFirstSearch(Node root){
        
        List<Node> PathToSolution = new ArrayList<Node>();
        List<Node> OpenList = new ArrayList<Node>(); //Fringe içindeki nodelarım
        List<Node>  ClosedList = new ArrayList<Node>();//Already expanded
        
        //rootu ekledim
        OpenList.add(root);
        boolean goalFound = false;
        
        //fringe 0 lanırsa ve hedefe ulaşamamışsak bulamamışızdır.
        while(OpenList.size() > 0 && !goalFound){ //+++
            
            //queue yapısı oluşturuyorum
            Node currentNode = OpenList.get(0); //+++
            ClosedList.add(currentNode);
            OpenList.remove(0); //+++
            //queue daki ilk elemanı Closed liste attım
            
            
            
            //EĞER FRİNGE İÇİ DAHA BÜYÜKSE MAKSİMUM FRİNGE SİZE IM OLACAK //SE
            if(OpenList.size()>=maxSizeFringe)
                maxSizeFringe=OpenList.size();
            
            
            
                    
                    
            
            currentNode.ExpandNode();
           //currentNode.PrintPuzzle(); /*Tüm current nodelardaki puzzle hali görmek için*/
            
            for(int i =0; i< currentNode.children.size();i++)
            {
                Node currentChild = currentNode.children.get(i);
                if(currentChild.GoalTest()){
                    
                    System.out.println("Goal found.");
                    goalFound = true;
                    
                    
                    System.out.println("NUMBER OF NODES EXPANDED "+ClosedList.size());//SE HANGİLERİNİ ATIYOR BURAYA VS BAKARSIN SABAH.
                    System.out.println("MAXIMUM SIZE OF THE FRINGE " + maxSizeFringe); //SE EĞER GOAL FOUND BULUNURSA MAKSİMUM FRİNGE
                    
                    
                    
                    //trace path to root node
                    
                    PathTrace(PathToSolution,currentChild);
                }
                
                if(!Contains(OpenList,currentChild) && !Contains(ClosedList,currentChild)){
                    OpenList.add(currentChild);
                }
                
                
                
                
            }
            
            
        }
        
        
        return PathToSolution;
    }
    
    
    public List<Node> DepthFirstSearch(Node root){
        
         List<Node> PathToSolution = new ArrayList<Node>();
        List<Node> OpenList = new ArrayList<Node>(); //Fringe içindeki nodelarım
        List<Node>  ClosedList = new ArrayList<Node>();//Already expanded
        
        //rootu ekledim
        OpenList.add(root);
        boolean goalFound = false;
        
        
        while(OpenList.size() > 0 && !goalFound){ //+++
            
            //stack yapısı oluşturuyorum
            Node currentNode = OpenList.get(OpenList.size()-1); //+++
            ClosedList.add(currentNode);
            OpenList.remove(OpenList.size()-1); //+++
            //stack daki son elemanı Closed liste attım
            
            
            
            //EĞER FRİNGE İÇİ DAHA BÜYÜKSE MAKSİMUM FRİNGE SİZE IM OLACAK //SE
            if(OpenList.size()>=maxSizeFringe)
                maxSizeFringe=OpenList.size();
            
            
            
                    
                    
            
            currentNode.ExpandNode();
           //currentNode.PrintPuzzle(); /*Tüm current nodelardaki puzzle hali görmek için*/
            
            for(int i =0; i< currentNode.children.size();i++)
            {
                Node currentChild = currentNode.children.get(i);
                if(currentChild.GoalTest()){
                    
                    System.out.println("Goal found.");
                    goalFound = true;
                    
                    
                    System.out.println("NUMBER OF NODES EXPANDED "+ClosedList.size());//SE HANGİLERİNİ ATIYOR BURAYA VS BAKARSIN SABAH.
                    System.out.println("MAXIMUM SIZE OF THE FRINGE " + maxSizeFringe); //SE EĞER GOAL FOUND BULUNURSA MAKSİMUM FRİNGE
                    
                    
                    
                    //trace path to root node
                    
                    PathTrace(PathToSolution,currentChild);
                }
                
                if(!Contains(OpenList,currentChild) && !Contains(ClosedList,currentChild)){
                    OpenList.add(currentChild);
                }
                
                
                
                
            }
            
            
        }
        
        return PathToSolution;
        
    }
    
    
    public List<Node> DepthLimitedSearch(Node root,int depthLimit){
        
         List<Node> PathToSolution = new ArrayList<Node>();
        List<Node> OpenList = new ArrayList<Node>(); //Fringe içindeki nodelarım
        List<Node>  ClosedList = new ArrayList<Node>();//Already expanded
        
        //rootu ekledim
        OpenList.add(root);
        boolean goalFound = false;
        
        
        while(OpenList.size() > 0 && !goalFound){ //+++
            
            //stack yapısı oluşturuyorum
            Node currentNode = OpenList.get(OpenList.size()-1); //+++
            ClosedList.add(currentNode);
            
            if(currentNode.getDepth()<depthLimit){
                currentNode.ExpandNode();
            }
            OpenList.remove(OpenList.size()-1); //+++
            //stack daki son elemanı Closed liste attım
            
            
            
            //EĞER FRİNGE İÇİ DAHA BÜYÜKSE MAKSİMUM FRİNGE SİZE IM OLACAK //SE
            if(OpenList.size()>=maxSizeFringe)
                maxSizeFringe=OpenList.size();
            
            
            for(int i =0; i< currentNode.children.size();i++)
            {
                Node currentChild = currentNode.children.get(i);
                if(currentChild.GoalTest()){
                    
                    System.out.println("Goal found.");
                    goalFound = true;
                    
                    
                    System.out.println("NUMBER OF NODES EXPANDED "+ClosedList.size());//SE HANGİLERİNİ ATIYOR BURAYA VS BAKARSIN SABAH.
                    System.out.println("MAXIMUM SIZE OF THE FRINGE " + maxSizeFringe); //SE EĞER GOAL FOUND BULUNURSA MAKSİMUM FRİNGE
                    
                    
                    
                    //trace path to root node
                    
                    PathTrace(PathToSolution,currentChild);
                }
                
                if(!Contains(OpenList,currentChild) && !Contains(ClosedList,currentChild)){
                    OpenList.add(currentChild);
                   
                
                }
            }
        }
        
        if(goalFound == false){
            System.out.println("Goal not found at this depth.You can increase the depth value.");
        }
        
        return PathToSolution;
        
    }
    
    //The only difference frome DepthLimitedSearch is that DepthLimitedSearchforIterative does not give "Goal not found at this depth" error.
    public List<Node> DepthLimitedSearchforIterative(Node root,int depthLimit){
        
         List<Node> PathToSolution = new ArrayList<Node>();
        List<Node> OpenList = new ArrayList<Node>(); //Fringe içindeki nodelarım
        List<Node>  ClosedList = new ArrayList<Node>();//Already expanded
        
        //rootu ekledim
        OpenList.add(root);
        boolean goalFound = false;
        
        
        while(OpenList.size() > 0 && !goalFound){ //+++
            
            //stack yapısı oluşturuyorum
            Node currentNode = OpenList.get(OpenList.size()-1); //+++
            ClosedList.add(currentNode);
            
            if(currentNode.getDepth()<depthLimit){
                currentNode.ExpandNode();
            }
            OpenList.remove(OpenList.size()-1); //+++
            //stack daki son elemanı Closed liste attım
            
            
            
            //EĞER FRİNGE İÇİ DAHA BÜYÜKSE MAKSİMUM FRİNGE SİZE IM OLACAK //SE
            if(OpenList.size()>=maxSizeFringe)
                maxSizeFringe=OpenList.size();
            
            
            for(int i =0; i< currentNode.children.size();i++)
            {
                Node currentChild = currentNode.children.get(i);
                if(currentChild.GoalTest()){
                    
                    System.out.println("Goal found.");
                    goalFound = true;
                    
                    
                    System.out.println("NUMBER OF NODES EXPANDED "+ClosedList.size());//SE HANGİLERİNİ ATIYOR BURAYA VS BAKARSIN SABAH.
                    System.out.println("MAXIMUM SIZE OF THE FRINGE " + maxSizeFringe); //SE EĞER GOAL FOUND BULUNURSA MAKSİMUM FRİNGE
                    
                    
                    
                    //trace path to root node
                    
                    PathTrace(PathToSolution,currentChild);
                }
                
                if(!Contains(OpenList,currentChild) && !Contains(ClosedList,currentChild)){
                    OpenList.add(currentChild);
                   
                
                }
            }
        }
        
        return PathToSolution;
        
    }
    
     public List<Node> IterativeDeepeningSearch(Node root){
         //Repeatedly applies depth-limited search with increasing limits.
         //her seferinde derinliği 1 arttırarak depth limited search çalıştıracağım. 
         
         int depthLimit = 0;
    List<Node> solutionPath = new ArrayList<>();

    while (true) {
        List<Node> result = DepthLimitedSearchforIterative(root, depthLimit);
        if (!result.isEmpty()) {
            // Hedef bulundu
            solutionPath.addAll(result);
            break;
        }
        depthLimit++;
    }
    
    return solutionPath;
       
    }
    
    
    public void PathTrace(List<Node> path, Node n){
        Node current = n;
        //In this part, n equals goal node and I will scan path backwards when the goal node found.
        path.add(current);
        while(current.parent != null){
            current = current.parent;
            path.add(current);
        }
    }
    public static boolean Contains(List<Node> list, Node c){
        
        boolean contains = false;
        
        for(int i =0;i< list.size();i++){
            
            if(list.get(i).IsSamePuzzle(c.puzzle))
                contains = true;
        }
        
        return contains;
        
    }
    
    
}
