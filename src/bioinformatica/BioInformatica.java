package bioinformatica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class BioInformatica {

    public static String nucleotide()
    {
        Random rd = new Random();
        switch(rd.nextInt(4))
        {
            case 0: return "A";
            case 1: return "C"; 
            case 2: return "G";
            case 3: return "T";
            default: return "";
        }
    }
    
    public static String chromosome()
    {
        Random rd = new Random();
        return "chr" + (rd.nextInt(23)+1);
    }
    
    
    public static String sequence(int lenght)
    {
        if(lenght==1)
            return nucleotide();
        else
            return nucleotide() + sequence(lenght - 1);            
    }
    
    public static void readSequences() throws FileNotFoundException, IOException
    {
        
       FileReader file = new FileReader("sequences.txt");
       try(BufferedReader br = new BufferedReader(file))
       {
           
       }
       catch(IOException e)
       {
           
       }
    }
       
    
    
    public static void saveSequences() throws IOException
    {
        try
        {
            FileWriter file = new FileWriter("sequences.txt");
            try (BufferedWriter bw = new BufferedWriter(file)) {
                Random rd = new Random();
                int lenght, start, datasize = 100;
                for (int i = 0; i < datasize; i++)
                {
                    lenght=rd.nextInt(50)+1;
                    start=rd.nextInt(1000+1);
                    String experimental_read=sequence(lenght) + "," + chromosome()+ "," + start + "," + (start + (lenght - 1) + "\n");
                    bw.write(experimental_read );
                }   bw.flush();
            }
            
        }
        catch(IOException e)
                {
                }
        
    }
    
    public static void main(String[] args) throws IOException {
        saveSequences();
    }
    
}

