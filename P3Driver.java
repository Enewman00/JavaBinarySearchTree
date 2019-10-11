
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

            //create new IDedLinkedList
            IDedLinkedList<MyItem> LL = new IDedLinkedList(); 

            //variables to save operation and line number
            String operation = "";
	        int lineno = 0;
	
            
	        int id, price;
            boolean result;
	        List<Integer> name = new LinkedList<>();
            
            whileloop:
            while (in.hasNext())
            {
	            lineno++;
	   
                operation = in.next();

                //if it starts with a #, skip it
                if(operation.charAt(0) == '#')
                {
		            in.nextLine();
		            continue;
                }
                switch (operation)
                {
                    //if "End" break out of the loop
                    case "End":
                        break whileloop;
                    
                    //if "Insert",  create new item (MyItem) with id, price, name. Insert it at front of LL
                    case "Insert":
                        try
                        {
                                
                            id = in.nextInt();
                            price = in.nextInt();
                            name.clear();
                            while(true)
                            {
                                int val = in.nextInt();
                                if(val == 0)
                                {
                                    break;
                                }
                                else
                                {
                                    name.add(val);
                                }
                            }
                            MyItem new_item = new MyItem(id, price, name);
                            result = LL.insertAtFront(new_item);
                            //result = Insert the item into the linkedlist and print true or false 
                            out.println(result ? "True" :"False");
                        }
                        catch (Exception e)
                        {
                            out.println("ERROR");
                        }
                        break;
                    
                    //if "FindID", create MyItem copy of LL.findID(id), print the ID (MyItem method)
                    case "FindID":
                        try
                        {
                            id = in.nextInt();
                            MyItem item1 = LL.findID(id);
                            //Call the FindID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                            out.println(item1 != null ? item1.printID(): "Null");
                        }
                        catch (Exception e){
                            out.println("ERROR");
                        }
                        break;

                    //if "DeleteID", create MyItem copy of LL.delete(id), print its ID
                    case "DeleteID":
                        try
                        {
                            id = in.nextInt();
                        
                    
                            //Call the DeleteID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                            MyItem  item1 = LL.delete(id);
                            //Call the FindID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                            out.println(item1 != null ? item1.printID(): "Null");
                        }
                        catch (Exception e){
                            out.println("ERROR");
                        }
                        
                        break;
                    
                    //if "Delete", create MyItem copy of LL.deleteFromFront(id), LL.deleteFromFront(), print itemID
                    case "Delete":
                        //If the list is not empty print and delete the first item in the list. if the list is empty print Null
                
                        MyItem  item1 = LL.deleteFromFront();
                        //Call the FindID method and printID method to print to the output file the entire item in a line. If the item is not found or the list is empty print Null
                        out.println(item1 != null ? item1.printID(): "Null");
                        break;
                    
                            
            
            
                    //return the sum of ids of all elements currently in the list. If the list is empty, return -1
                    case "PrintTotal":
                        //Call the printtotal method of the linkedlist and print the given int into the output file.
                        int total = LL.printTotal();
                        out.println(total);
                        break;
                        
                    //else, ERROR
                    default:
                        out.println("ERROR");
                        in.nextLine();
	            }
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