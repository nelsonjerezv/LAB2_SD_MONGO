/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_sd_mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler;  
  
public class ManejadorEjemplo extends DefaultHandler{  
    private String valor = "";
    private String cadena = "";
    private String titulo = "";
    
    Mongo mongo = new Mongo("localhost",LAB2_SD_MONGO.puerto_mongoDB);    
    DB db = mongo.getDB(LAB2_SD_MONGO.nombre_BD);
    DBCollection coleccion = db.getCollection(LAB2_SD_MONGO.nombre_coleccion_DB);

   @Override  
   public void startDocument() throws SAXException {  
      System.out.println("\nPrincipio del documento...");  
   }  
  
   @Override  
   public void endDocument() throws SAXException {  
      System.out.println("\nFin del documento...");  
   }  
  
   @Override  
   public void startElement(String uri, String localName, String name,  
        Attributes attributes) throws SAXException {
   }  
     
   @Override  
   public void characters(char[] ch, int start, int length)  
         throws SAXException {  
      //System.out.println("\nProcesando texto dentro de una etiqueta... ");      
      cadena = new String(ch, start, length);
      valor = valor + cadena;
   }  
  
   @Override  
    public void endElement(String uri, String localName, String name) throws SAXException {  
       
        if(localName.equals("title")){
            titulo = valor;
        }

        if (localName.equals("page")){
           try {
                titulo = filtroStopWords.filtrar(titulo);
                valor = filtroStopWords.filtrarSW(valor);
                System.out.println(titulo);
                System.out.println(valor);

                BasicDBObject document = new BasicDBObject();
                document.put("titulo", titulo);
                document.put("cuerpo", valor);
                coleccion.insert(document);

                valor = "";
                System.out.println("----------------------");
               
            } catch (IOException ex) {
                Logger.getLogger(ManejadorEjemplo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (localName.equals("siteinfo")){
            valor = "";
         }
        if (localName.equals("format")){
            valor = "";
         }
   }  
}