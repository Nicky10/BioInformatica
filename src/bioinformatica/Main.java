/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatica;
import java.io.*;


public class Main {
    
    List sequences= new List();
    int max_occurrences = Integer.MIN_VALUE;
    String motif_winner= "";
    
    
    public void compareMotif(String motif_candidate)
    {
        int counter=counterOccurrences(motif_candidate);
        if(counter>max_occurrences)
        {
            max_occurrences = counter;
            motif_winner=motif_candidate;
        }
    }
    
    public int counterOccurrences(String motif_candidate)
    {
        int counter = 0;
        String gen_sequence;
        Sequence temp = sequences.head;
        
        while (temp !=null)
        {
            gen_sequence = temp.sequence;
            for (int i = 0; i < (gen_sequence.length() - motif_candidate.length()); i++) 
            {
                if(gen_sequence.subSequence(i, i + motif_candidate.length()).equals(motif_candidate))
                {
                    counter +=1;
                    i+=motif_candidate.length() - 1;
                }
                
            }
            temp=temp.next;
            
        }
        
        return counter;
    }
    
    
    public void generateCombinations(String subsequence, int size)
    {
        if(size == 1)
        {
            compareMotif(subsequence + "A");
            compareMotif(subsequence + "C");
            compareMotif(subsequence + "G");
            compareMotif(subsequence + "T");
        }
        else
        {
            generateCombinations(subsequence + "A",size - 1);
            generateCombinations(subsequence + "C",size - 1);
            generateCombinations(subsequence + "G",size - 1);
            generateCombinations(subsequence + "T",size - 1);
        }
    }
    
    public void countChromosomes() throws IOException
    {
        int[]chromosomes = new int[23];
        Sequence temp = sequences.head;
        String cromosoma;
        int index = 0;
        
        while (temp !=null)
        {
            temp=temp.next;
            if (temp.sequence.contains(motif_winner))
            {
//              chromosomes[Integer.parseInt(temp.chromosome.replace("chr", "")) - 1] +=1;  
                cromosoma=temp.chromosome;
                cromosoma = cromosoma.replace("chr","");
                index = Integer.parseInt(cromosoma) - 1;
                chromosomes[index]+=1;
            }
            
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 23; i++) {
            bw.write("Cromosoma " + (i+1) + ": " + chromosomes[i] + "\n");            
        }
        bw.flush();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try
        {
            FileReader fr = new FileReader("sequences.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String input = br.readLine();
            Main run = new Main();
            
            while (input!=null)
            {
                String[] data = input.split(",");
                run.sequences.insertAtEnd(new Sequence(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3])));
            
            input=br.readLine();
        }
        //run.sequences.printList();
        run.generateCombinations("", 4);
            System.out.println("Motif ganador: " + run.motif_winner + "\tOcurrencias: " + run.max_occurrences);
            run.countChromosomes();
        }
        catch(Exception ex)
        {}
    }
       
}