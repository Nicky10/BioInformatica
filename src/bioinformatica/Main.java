/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatica;
import java.io.*;


public class Main {
    
    static List sequences= new List();
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try
        {
            FileReader fr = new FileReader("sequences.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String input = br.readLine();
            
            while (input!=null)
            {
                String[] data = input.split(",");
                sequences.insertAtEnd(new Sequence(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3])));
            
            input=br.readLine();
        }
        sequences.printList();
        }
        catch(Exception ex)
        {}
    }
       
}