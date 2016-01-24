/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Nelson
 */
public class filtroStopWords {

    static String filtrarSW(String cadena) throws FileNotFoundException, IOException {
              
        // reemplazamos caracteres especiales        
        cadena = cadena.replaceAll("[Ñ]","N");
        cadena = cadena.replaceAll("[ñ]","n");
        
        cadena = cadena.replaceAll("[èéêë]","e");
        cadena = cadena.replaceAll("[ùúûü]","u");
        cadena = cadena.replaceAll("[ìíîï]","i");
        cadena = cadena.replaceAll("[àáâä]","a");
        cadena = cadena.replaceAll("[òóôö]","o");

        cadena = cadena.replaceAll("[ÈÉÊË]","E");
        cadena = cadena.replaceAll("[ÙÚÛÜ]","U");
        cadena = cadena.replaceAll("[ÌÍÎÏ]","I");
        cadena = cadena.replaceAll("[ÀÁÂÄ]","A");
        cadena = cadena.replaceAll("[ÒÓÔÖ]","O");
        
        cadena = cadena.replaceAll("[|.,<>=/:;]"," ");        
        cadena = cadena.replaceAll("[^a-z \\nA-Z]","");
        cadena = cadena.replaceAll("\\s+", " ");
        
        cadena = cadena.toLowerCase();
        cadena = cadena.trim();
        
        // eliminamos las stopwords, los espacios aseguran no eliminar parte de palabras
        for (int i = 0; i < ProcesaXML.palabras.size(); i++) {
            String aux = "\\b"+ProcesaXML.palabras.get(i)+"\\b";            
            cadena = cadena.replaceAll( aux , "");
        }
        
        return cadena;
    }

    static String filtrar(String cadena) {
        
        // reemplazamos caracteres especiales        
        cadena = cadena.replaceAll("[Ñ]","N");
        cadena = cadena.replaceAll("[ñ]","n");
        
        cadena = cadena.replaceAll("[èéêë]","e");
        cadena = cadena.replaceAll("[ùúûü]","u");
        cadena = cadena.replaceAll("[ìíîï]","i");
        cadena = cadena.replaceAll("[àáâä]","a");
        cadena = cadena.replaceAll("[òóôö]","o");

        cadena = cadena.replaceAll("[ÈÉÊË]","E");
        cadena = cadena.replaceAll("[ÙÚÛÜ]","U");
        cadena = cadena.replaceAll("[ÌÍÎÏ]","I");
        cadena = cadena.replaceAll("[ÀÁÂÄ]","A");
        cadena = cadena.replaceAll("[ÒÓÔÖ]","O");
        
        cadena = cadena.replaceAll("[|.,<>=/:;]"," ");        
        cadena = cadena.replaceAll("[^a-z \\nA-Z]","");
        cadena = cadena.trim();
        
        return cadena;
    }
    
}
