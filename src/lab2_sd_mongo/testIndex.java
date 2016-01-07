/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.xml.sax.SAXException;

/**
 *
 * @author Nelson
 */
public class testIndex {
    
    public static ArrayList<String> testIndex(String in) throws FileNotFoundException, IOException, SAXException{ 
        //while(true){
            
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("entrada: ");
//
//            String in = scanner.nextLine();

            System.out.println("la entrada fue: "+in);
            
            String id_splitted[] = in.split(" ");
            ArrayList<String> input = new ArrayList();

            for (int i = 0; i < id_splitted.length; i++) {
                input.add(id_splitted[i]);
            }

            System.out.println(Arrays.asList(in.split(" ")));
            ArrayList<String> respuestas = InvertedIndex.search(input, LAB2_SD_MONGO.index_db, LAB2_SD_MONGO.coleccion);
            
            System.out.println("respuestas " + respuestas);
        //}
        return respuestas;
        
    }
}
