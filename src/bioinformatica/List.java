package bioinformatica;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Estudiante
 */
public class List 
{

    Sequence head = null;

    public boolean isEmpty() 
    {
        return head == null ? true : false;
    }

    public void printList() throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Sequence temp = head;

        try {
            bw.write("Grades: \n");
            while (temp != null) 
            {
                bw.write(temp.toString());
                temp = temp.next;

            }
            bw.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

    public void insertAtBegin(Sequence newSequence) {
        newSequence.next = head;
        head = newSequence;
    }

    public void insertAtEnd(Sequence newSequence) {
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

    public void insertAtPosition(Sequence newSequence, int position) 
    {
        Sequence prev = head;
        for (int i = 0; i < position - 1; i++) 
        {
            prev = prev.next;
        }
        
        newSequence.next = prev.next;
        prev.next = newSequence;        
    }

    public void deleteAtPosition(int position) 
    {
        Sequence prev = head;
        for (int i = 0; i < position - 1; i++) 
        {
            prev = prev.next;
        }
        Sequence temp = prev.next;
        Sequence aft = temp.next;
        prev.next = aft;
        temp = null;
        System.gc();

    }

    public void deleteAtBegin() 
    {
        Sequence temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }

    public void deleteAtEnd() 
    {
        Sequence temp = head;

        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        System.gc();
    }
    
    public Sequence searchByPosition(int position)
    {
        Sequence temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        return temp.next;
    }
    
//    public Sequence searchByValue(List lista,double value)
//    {
//        Sequence temp = head;
//        for (int i = 0; i < lista.; i++) 
//        {
//            temp = temp.next;
//        }
//    }

    
    public static void invertirLista(List lista)
    {
        Stack inversa = new Stack();
        Sequence temp = new Sequence();
        temp = lista.head;
            while (temp.next != null) {
                temp = temp.next;
                inversa.push(temp);
            }
            inversa.toString();
    }
    
//    public void reverse()
//    {
//        Stack tempStack = new Stack();
//        Sequence temp = head;
//        while(temp!= null)
//        {
//            tempStack.push(temp.clone());
//            temp=temp.next;
//        }
//        head=tempStack.head;
//    }
    
//    public static void main(String[] args) throws IOException 
//    {
//
//        Sequence grades = new Sequence();
//
//        grades.insertAtBegin(new Sequence("Task 1", 3.5));
//        grades.insertAtBegin(new Sequence("Quiz 1", 1.5));
//        grades.insertAtBegin(new Sequence("Test1", 0.5));
//        grades.insertAtBegin(new Sequence("Hola", 0.2));
//        grades.printList();
//        invertirLista(grades);
//        grades.reverse();
//        grades.printList();
//        //grades.deleteAtPosition(1);
//        //grades.deleteAtEnd();
//
//
//    }
//
}
