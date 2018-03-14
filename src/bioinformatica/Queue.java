package bioinformatica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Queue {
 
    public boolean isEmpty() 
    {
        return head == null ? true : false;
    }
    
        Sequence head = null;

    
    public void enqueue(Sequence newSequence) {
        if (isEmpty()) 
        {
            head = newSequence;
        } else {
            Sequence temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newSequence;

        }
    }
    
    public String dequeue() 
    {
        Sequence temp = head;
        head = head.next;
        String info = temp.toString();
        temp = null;
        System.gc();
        return info;
    }
    
}
