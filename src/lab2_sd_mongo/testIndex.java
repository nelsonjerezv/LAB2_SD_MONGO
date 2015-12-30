/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import org.xml.sax.SAXException;

/**
 *
 * @author Nelson
 */
public class testIndex {
    
    public static void testIndex() throws FileNotFoundException, IOException, SAXException{ 
        InvertedIndex idx = new InvertedIndex();
        InvertedIndex.indexar(idx);
        while(true){
            
            Scanner scanner = new Scanner(System.in);

            System.out.print("entrada: ");

            String input = scanner.nextLine();

            System.out.println("la entrada fue: "+input);
            
            InvertedIndex.search(Arrays.asList(input.split(" ")));
        }
        
    }
}
