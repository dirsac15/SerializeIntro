
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sabrina
 */
public class SchulerBL 
{
    private ArrayList<Schueler> klasse = new ArrayList<>();
    
    public void add(Schueler s)
    {
        klasse.add(s);
    }
    
    public void save(File f) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for(Schueler s : klasse)
        {
            bw.write(s.getName());
            bw.write(";");
            bw.write(s.getBirthday().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public void load(File f)throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        String line = "";
        
        while((line = br.readLine()) != null)
        {
            String parts[] = line.split(";");
            Schueler s = new Schueler(parts[0], LocalDate.parse(parts[1]));
            
        }
        br.close();
    }
    
    public void print()
    {
        for (Schueler schueler : klasse) 
        {
            System.out.format("%s %s\n", schueler.getName(), schueler.getBirthday());
        }
    }
    
    public void serialsave(File f) throws FileNotFoundException, IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
        for (Schueler schueler : klasse) {
            oos.writeObject(schueler);
        }
        
        oos.flush();
        oos.close();
          
    }
    
    public void serialload()
    {
        
    }
}
