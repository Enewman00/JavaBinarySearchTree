
/**
 *
  Licensing Information:  You are free to use or extend these projects for
# personal and educational purposes provided that (1) you do not distribute
# or publish solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UT Dallas, including a link to http://cs.utdallas.edu.
#
# This file is part of Project for CE|CS|SE 3345: DataStructure and Introduction to Algorithms.
# 
# Anjum Chida (anjum.chida@utdallas.edu)
#
#
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class P3Driver {

    public static void main(String[] args) {
        
        Scanner in;
        Scanner lineScanner;
        if (args.length!=2) {
            System.out.print("Error Incorrect Arguments:" + Arrays.toString(args));
            System.exit(0);
            
        }

        try {
            //file input
	        File input_file = new File(args[0]);
            in = new Scanner(input_file);

            //file output
            File output_file = new File(args[1]); 
            PrintWriter out;
            out = new PrintWriter(output_file);

            //create new bst
            LazyBinarySearchTree BST = new LazyBinarySearchTree(); 

            //variables to save operation and line number
            String operation = "";
	        int lineno = 0;
	
            
	        int key = 0;
            boolean result;
            
            whileloop:
            while (in.hasNextLine())
            {
	            lineno++;
                
                String line = in.nextLine();

                
                lineScanner = new Scanner(line).useDelimiter(":");
                operation = lineScanner.next();

                //if it starts with a #, skip it
                if(operation.charAt(0) == '#')
                {
		            // in.nextLine();
		            continue;
                }
                switch (operation)
                {
                    //if "End" break out of the loop
                    case "End":
                        break whileloop;
                    
                    //if "Insert", Insert node with Key at appropriate spot in BST
                    case "Insert":
                        try
                        {
                            key = lineScanner.nextInt();

                            result = BST.insert(key);
                            //result = Insert the item into the bst and print true or false 
                            out.println(result ? "True" :"False");
                        }
                        catch (IllegalArgumentException ex)
                        {
                            out.println("Error in insert " + ex);
                        }
                        catch (Exception e)
                        {
                            out.println("Error in line: " + line);
                        }
                        break;
                    
                    //if "dELETE", Delete node with Key at appropriate spot in BST
                    case "Delete":
                        try
                        {
                            key = lineScanner.nextInt();

                            result = BST.delete(key);
                            // result = Delete the item from the bst and print true or false
                            out.println(result ? "True" : "False");
                        }
                        catch (IllegalArgumentException ex)
                        {
                            out.println("Error in delete " + ex);
                        } 
                        catch (Exception e)
                        {
                            out.println("Error in line: " + line);
                        }
                        break;

                    //if "PrintTree", print tree in preorder traversal
                    case "PrintTree":
                        try
                        {
                            //call the toString method on the BST
                            out.println(BST.toString());
                        }
                        catch (Exception e){
                            out.println("ERROR");
                        }
                        
                        break;
                    
                    //if "Contains", print true if tree contains key, false if not
                    case "Contains":
                        try {

                            key = lineScanner.nextInt();

                            result = BST.contains(key);
                            // result = contains the item in the bst and print true or false
                            out.println(result ? "True" : "False");
                        }
                        catch (IllegalArgumentException ex)
                        {
                            out.println("Error in insert " + ex);
                        }
                        catch (Exception e) {
                            out.println("Error in line: " + line);
                        }
                        break;
                    
            
                    //if "findMin", call findMin method of BST to return lowest key
                    case "FindMin":
                        //Call the findMin method of the bst and print the given int into the output file.
                        int min = BST.findMin();
                        out.println(min);
                        break;


                    //if "findMin", call findMax method of BST to return lowest key
                    case "FindMax":
                        //Call the findMax method of the bst and print the given int into the output file.
                        int max = BST.findMax();
                        out.println(max);
                        break;
                        

                    // if "height", call the height method of the BST and return it (longest chain of nodes)
                    case "Height":
                        int height = BST.height();
                        out.println(height + "");
                        break;


                    //if "size", call the size method of the BST and return it (number of nodes in tree)
                    case "Size":
                        int size = BST.size();
                        out.println(size + "");
                        break;
                        


                    //else, ERROR
                    default:
                        out.println("Error in line: " + operation);
                        //in.nextLine();
                }
                lineScanner.close();
            }
            //close files
            in.close();
            out.close();
        
        } //end of try

        catch(Exception e){
            System.out.println("Exception: " + e);
        }

    } //end of main method

} //end of class p2Driver