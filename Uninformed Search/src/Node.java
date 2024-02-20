
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
public class Node {
    
    public List<Node> children = new ArrayList<Node>(); 
    
    public Node parent;
    public int depth; //SSE
    
    //9 karoyu tek boyutlu bir array içinde tutacağım
    public int[] puzzle = new int[9];
    public int x = 0;
    public int col = 3; //kısıtlama yapmak için kullanıyorum
    
    public Node(int[] p,int depth){ //SSE depth int kısmı
        
        SetPuzzle(p);
        
        this.depth =depth; //SSE
    }
    
    //SSE derinlik için get set
    
    public int getDepth(){
        return depth;
    }
    
    public void setDepth(int Depth){
        this.depth =depth;
    }
    
    //SSE yukardakiler
    
    public void SetPuzzle(int[] p){
        for(int i=0; i< puzzle.length;i++)
            this.puzzle[i] = p[i];
            
    }
    
    public void ExpandNode(){
        for(int i = 0; i<puzzle.length;i++){
            
            if(puzzle[i]==0)
                x=i;
        }
        
        MoveToRight(puzzle,x);
        MoveToLeft(puzzle,x);
        MoveToUp(puzzle,x);
        MoveToDown(puzzle,x);
        
        
        //SSE
        for(Node child : children){
            child.depth = this.depth+1;
        }
        //SSE
    }
    
    public void MoveToRight(int[] p, int i)
    {
        //sağ karolardan dışarıya çıkamasın diye
        if(i % col < col-1 ){
            
            int[] pc = new int[9];
            CopyPuzzle(pc,p);
            
            int temp = pc[i+1];
            pc[i+1] = pc[i];
            pc[i] = temp;
            
            Node child = new Node(pc,this.depth+1);
            children.add(child);
            child.parent = this;
        }

    }
    
     public void MoveToLeft(int[] p, int i)
    {
        
        //1 in ve 2 nin katlarında iken sola geçiş yapılabiliyor sadece
        if(i%col>0){
            
            int[] pc = new int [9];
            CopyPuzzle(pc,p);
            
            
            int temp = pc[i-1];
            pc[i-1]=pc[i];
            pc[i]=temp;
            Node child = new Node(pc,this.depth+1);
            children.add(child);
            child.parent=this;
        }
        
    }
     
      public void MoveToUp(int[] p, int i)
    {
        
        if(i-col >=0){
            
               int[] pc = new int [9];
            CopyPuzzle(pc,p);
           
            
             int temp = pc[i-3];
            pc[i-3]=pc[i];
            pc[i]=temp;
            
            Node child = new Node(pc,this.depth+1);//SSE this.depth+1
            children.add(child);
            child.parent=this;
            
        }
    }
      
       public void MoveToDown(int[] p, int i)
    {
        
        if(i+col < puzzle.length){
            int[] pc = new int [9];
            CopyPuzzle(pc,p);
            
            int temp = pc[i+3];
            pc[i+3]=pc[i];
            pc[i]= temp;
            
            Node child = new Node(pc,this.depth+1);
            children.add(child);
            child.parent=this;
            
            
        }
        
    }
       
       public void PrintPuzzle(){
           
           System.out.println();
           int m =0;
           
           for(int i =0; i< col; i++){
               
               for(int j= 0; j<col;j++){
                   //her puzzle arası boşluk
                   System.out.print(puzzle[m]+" ");
                   m++;
               }
               System.out.println();
                   
           }
       }
       
       
       //Aynı ise true dönecek
       public boolean IsSamePuzzle(int[] p){
           
           boolean samePuzzle=true;
           
           for(int i =0; i< p.length;i++){
           
           if(puzzle[i] != p[i]){
               
               samePuzzle = false;
               
           }
       }
           
           return samePuzzle;
           
       }
       
    
       public void CopyPuzzle(int[] a, int[] b){
           
           for(int i =0 ; i< b.length; i++){
               
               a[i] = b[i];
               
           }
       }
       
    
    public boolean GoalTest(){
        boolean isGoal = true;
        int m = puzzle[0];
        
        for(int i =1; i< puzzle.length;i++){
            
            if(m>puzzle[i])
                isGoal = false;
            
            m= puzzle[i];
        }
        
        return isGoal;
    }
}
