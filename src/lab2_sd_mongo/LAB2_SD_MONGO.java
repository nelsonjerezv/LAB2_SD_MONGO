/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import static lab2_sd_mongo.InvertedIndex.mongo;
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
    public static DBCollection test;
    public static DBCollection index_db;
    public static DBCollection index_part[];
    public static Mongo mongo;
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
    public static int particiones = 0;
    public static DBCollection shard;
    
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
                    case 8:
                        particiones = Integer.parseInt(parametro);
                        System.out.println("parametro " + counter + ": " + particiones);
                        break;
                    default:
                        System.out.println("parametro " + counter + ": " + parametro);
                        break;
                }
                counter++;            
            }
        }
        
        mongo = new Mongo("localhost",puerto_mongoDB);
        db = mongo.getDB(nombre_BD);
        test = db.createCollection("asdasdasd", null);
        if (!db.collectionExists("test")) {
            System.out.println("asd");
            coleccion = db.createCollection(nombre_coleccion_DB, null);

        }else{
            coleccion = db.getCollection("test");
        }
        if (!db.collectionExists("index")) {
            System.out.println("qwe");
            index_db = db.createCollection(nombre_coleccion_DB_Index,null);
        }else{
            index_db = db.getCollection("index");
        }
        //**********************************************************
        
        
        //**********************************************************
        
        
        System.out.println("Procesamos...");
        ProcesaXML.ProcesaXML(archivo_stopwords, ruta_XML);
        
        System.out.println("\nXML Index size: " + LAB2_SD_MONGO.index_db.count() + 
                          " Db size: " + LAB2_SD_MONGO.coleccion.count() + "\n");
        
        System.out.println("DB creada en Mongo, lista para indexar");        
        
        InvertedIndex.indexar();
        
        System.out.println("\nXML Index size: " + LAB2_SD_MONGO.index_db.count() + 
                          " Db size: " + LAB2_SD_MONGO.coleccion.count() + "\n");
        
        System.out.println("Index creado en Mongo, listo para ser usado");
//        System.out.println("id mide: " + "argentina".length());
//        ArrayList<String> asd = testIndex.testIndex("argentina");
    }
    
}
