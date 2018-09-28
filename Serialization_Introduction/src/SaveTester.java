
import java.io.File;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sabrina
 */
public class SaveTester 
{
    public static void main(String[] args) {
        Schueler s1 = new Schueler("Hans", LocalDate.of(2000, 3, 1));
        Schueler s2 = new Schueler("Mensch", LocalDate.of(2001, 5, 7));
        
        SchulerBL bl = new SchulerBL();
        bl.add(s1);
        bl.add(s2);
        
        try
        {
            bl.save(new File("./klasse.csv"));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
