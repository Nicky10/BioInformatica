package bioinformatica;

public class Sequence {
    
    public String sequence;
    public String chromosome;
    public int start;
    public int end;
    
    
    public Sequence next;
    
    public Sequence(){};
    
    public Sequence(String sequence, String chromosome, int start, int end) 
    {
        this.sequence = sequence;
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
    }


    
    public String toString()
    {
        return "Sequence: " + sequence + "\tChromosome: " + chromosome +"\tStart: " + start + "\tEnd: " + end + "\n";
    }
}