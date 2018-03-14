package bioinformatica;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Stack {

    Sequence head;
    
    public boolean isEmpty() 
    {
        return head == null ? true : false;
    }
    
    public void pop() 
    {
        Sequence temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }

    public void printStack() throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Sequence temp = head;

        try {
            bw.write("Grades: \n");
            while (!isEmpty()) 
            {
                bw.write(push());
                temp = temp.next;

            }
            bw.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
    
    
    
    public String push() 
    {
        Sequence temp = head;
        head = head.next;
        String info = temp.toString();
        return info;
    }

    
    public void push(Sequence newSequence) {
        newSequence.next = head;
        head = newSequence;
    }

    
    
}
