/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static lab2_sd_mongo.InvertedIndex.mongo;
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
    
    public static DB db;
    public static DBCollection coleccion;
    public static DBCollection index_db;
    public static String parametro;
    public static String ruta_XML = null;
    public static String nombre_BD = null;
    public static String nombre_coleccion_DB = null;
    public static String nombre_coleccion_DB_Index = null;
    public static String archivo_stopwords = null;
    public static int puerto_mongoDB;
    public static int counter = 0;
    public static int indexar = 0;
    public static int cargar_BD = 0;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, SAXException {
        // Lectura de parametros
        
        FileReader fr = new FileReader("MongoConf.ini");
        
        if(fr == null){
            System.out.println("Archivo erroneo");
            System.exit(1);
        }
        BufferedReader bf = new BufferedReader(fr);
                
        while( (parametro = bf.readLine() ) != null ){
            if(parametro.charAt(0) != '/'){
                switch (counter) {
                    case 0:
                        ruta_XML = parametro;
                        System.out.println("parametro " + counter + ": " + ruta_XML);
                        break;
                    case 1:
                        indexar = Integer.parseInt(parametro);
                        System.out.println("parametro " + counter + ": " + indexar);
                        break;
                    case 2:
                        cargar_BD = Integer.parseInt(parametro);
                        System.out.println("parametro " + counter + ": " + cargar_BD);
                        break;
                    case 3:
                        puerto_mongoDB = Integer.parseInt(parametro);
                        System.out.println("parametro " + counter + ": " + puerto_mongoDB);
                        break;
                    case 4:
                        nombre_BD = parametro;
                        System.out.println("parametro " + counter + ": " + nombre_BD);
                        break;
                    case 5:
                        nombre_coleccion_DB = parametro;
                        System.out.println("parametro " + counter + ": " + nombre_coleccion_DB);
                        break;
                    case 6:
                        nombre_coleccion_DB_Index = parametro;
                        System.out.println("parametro " + counter + ": " + nombre_coleccion_DB_Index);
                        break;
                    case 7:
                        archivo_stopwords = parametro;
                        System.out.println("parametro " + counter + ": " + archivo_stopwords);
                        break;
                    default:
                        System.out.println("parametro " + counter + ": " + parametro);
                        break;
                }
                counter++;            
            }
        }
        
        db = mongo.getDB(nombre_BD);
        coleccion = db.getCollection(nombre_coleccion_DB);
        index_db = db.getCollection(nombre_coleccion_DB_Index);
        
        ProcesaXML.ProcesaXML(archivo_stopwords, ruta_XML);
        testIndex.testIndex();
    }
    
}
