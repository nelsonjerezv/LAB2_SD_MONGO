/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nelson
 */
public class LAB2_SD_MONGO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, SAXException {
        ProcesaXML.ProcesaXML();
        testIndex.testIndex();
    }
    
}
