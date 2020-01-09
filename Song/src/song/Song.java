/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package song;

/**
 *
 * @author Belle
 */
public class Song {
    public static void main(String[] args) {
        cat();
        catlast();
        System.out.println();
        hen();
        henlast();
        System.out.println();
        duck();
        ducklast();
        System.out.println();
        goose();
        gooselast();
        System.out.println();
        sheep();
        sheeplast();
        System.out.println();
        pig();
        piglast();
       

        
        
    }
    //Prints cat
    public static void cat()
    {
        System.out.println("Bought me a cat and the cat pleased me,");
        System.out.println("I fed my cat under yonder tree");
    }
    public static void catlast() {
        System.out.println("Cat goes fiddle-i-fee.");
        }
    public static void hen() {
        System.out.println("Bought me a hen and the hen pleased me,");
        System.out.println("I fed my cat under yonder tree."); 
    }
    public static void henlast() {
        System.out.println("Hen goes chimy-chuck, chimy-chuck,");
        catlast();    
    }
    public static void duck() {
        System.out.println("Bought me a duck and the duck pleased me,");
        System.out.println("I fed my duck under yonder tree.");
    }
    public static void ducklast() {  
        System.out.println("Duck goes quack, quack,");
        henlast();
    }
    public static void goose() {
        System.out.println("Bought me a goose and the goose pleased me,");
        System.out.println("I fed my goose under yonder tree.");
    }
    public static void gooselast() {
        System.out.println("Goose goes hissy, hissy,");
        ducklast();
    }
    public static void sheep() {
        System.out.println("Bought me a sheep and the sheep pleased me,");
        System.out.println("I fed my sheep under yonder tree.");
        //양희원
    }
    public static void sheeplast() {
        System.out.println("Sheep goes baba,");
        gooselast();
    }
    public static void pig() {
        System.out.println("Bought me a pig and the pig pleased me,");
        System.out.println("I fed my pig under yonder tree.");
    }
    public static void piglast() {
        System.out.println("Pig goes oink, oink,");
        sheeplast();
    }
        
   
        
    
        
            
        
        // TODO code application logic here
    }
    

