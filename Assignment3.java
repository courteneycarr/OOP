import javax.swing.*;
public class Assignment3 {
   public static int count = 0;
   public static boolean status=true;
   public static void main(String[] args) {
       Assignment3 test = new Assignment3();

       JFrame f = new JFrame();
       String input = JOptionPane.showInputDialog(f, "Enter Palindrome");

       System.out.println(input);
        //Runs through each method for the input String.
       System.out.println("===========================================");
       System.out.println(stringReverse(input));
       System.out.println("===========================================");
       System.out.println(elementCompare(input));
       System.out.println("===========================================");
       System.out.println(dataStructures(input));
       System.out.println("===========================================");
       System.out.println(recursion(input));
       System.out.println("===========================================");


       //Asks the user whether they want to continue and run every number from 1 to 1 million
       //to find every palindrome and allow them to compare methods.
       JFrame c = new JFrame();
       int confirm = JOptionPane.showConfirmDialog(null,"Would you like to run the numbers from 1-1000000 through each method?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.NO_OPTION);
        //yes = 0, no = 1
       if(confirm == 0) {
           decimal(input);
           binary(input);
       }
   }


   public static void decimal(String Input){


   }
    //This method runs through all numbers from 1 to 1000 and finds which are palindromes.
    //It does this for each of the four methods.
   public static void binary(String input){
       System.out.println("Now running binary number from 1-1000");
       float stringRevStart = System.nanoTime();

       for (int i = 2; i < 1000; i++) {
           String in = Integer.toString(i);
           String binIn = decToBin(in);

           if(stringReverse(binIn)){
               System.out.println(binIn);
               count++;

           }

       }
       System.out.println("Total number of Palindromes: "+count);
       float stringRevEnd = System.nanoTime();
       System.out.println("-----------------------------------------------------------");
       float elementComStart = System.nanoTime();
       count=0;
       for (int i = 2; i < 1000; i++) {
           String in = Integer.toString(i);
           String binIn = decToBin(in);
           elementCompare(binIn);
           if(stringReverse(binIn)){
               count++;
           }
       }
       float elementComEnd = System.nanoTime();
       System.out.println(count);
       System.out.println("-----------------------------------------------------------");
       float dataStruStart = System.nanoTime();
       count=0;
       for (int i = 2; i < 1000; i++) {
           String in = Integer.toString(i);
           String binIn = decToBin(in);
           dataStructures(binIn);

       }
       float dataStruEnd = System.nanoTime();
       System.out.println("-----------------------------------------------------------");
       float recurStart = System.nanoTime();
       for (int i = 2; i < 1000; i++) {
           String in = Integer.toString(i);
           String binIn = decToBin(in);

           recursion(binIn);
       }
       float recurEnd = System.nanoTime();
       System.out.println("-----------------------------------------------------------");

       System.out.print("Time taken(StringReverse): "+(stringRevEnd-stringRevStart));
       System.out.print("Time taken(elementCompare): " +(elementComEnd-elementComStart));
       System.out.print("Time taken(dataStructures): " +(dataStruEnd-dataStruStart));
       System.out.print("Time taken(Recursion): " +(recurEnd-recurStart));
   }

   public static boolean stringReverse(String input){
       String s = "";
       for(int i=input.length()-1;i>=0;i--) {
           char c = input.charAt(i);
           s+=c;

       }
       if(input.equals(s)){
           return true;
       }

       return false;

   }

   public static boolean elementCompare(String input){

       for(int i=0;i<input.length();i++) {
           char c = input.charAt(i);
           int xIndex = (input.length()-1)-i;
           char x = input.charAt(xIndex);

           if(c == x){
                status = true;

           }else {
               return false;
           }
       }
       return status;
   }

   public static boolean dataStructures(String input){
       ArrayStack stack =new ArrayStack();
       ArrayQueue q = new ArrayQueue();

       for(int i=0;i<input.length();i++) {
           char c = input.charAt(i);
           stack.push(c);
           q.enqueue(c);
       }
       for(int i=0;i<input.length();i++){
           if (stack.pop() == q.dequeue()) {
               status = true;

           } else {
               return false;
           }
       }
       return status;
   }

    /**
     * Takes the reversed string and checks if it equals the original string.
     * @param input
     * @return
     */
   public static boolean recursion(String input) {
       String backward = reverse(input);
       if(input.equals(backward)) {
           return true;

       }
       return false;
   }

    /**
     * reverse is a method used to reverse a string recursively.
     * If the string contains one character or less it simply returns the String.
     * Otherwise it calls itself and passes in the substring starting from the second character
     * It then appends the first character onto that until the String is just one character long.
     * @param r
     * @return
     */
    public static String reverse(String r){
       int l=r.length();
       if(r.length() <= 1){
           return r;
       }

       return reverse(r.substring(1))+r.charAt(0);
   }

    /**
     * This method is used to convert decimal to binary.
     * It turns the String into an Integer before converting it to a Binary String.
     * @param d
     * @return
     */
   static String decToBin(String d) {
       int i = Integer.parseInt(d);
       return Integer.toBinaryString(i);
   }

   }



