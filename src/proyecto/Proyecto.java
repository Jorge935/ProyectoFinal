/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author gearj
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String[ ] Nombres = new  String[50];
        String[ ] Ape = new String[50];
        String[ ] Dir = new String[50];
        int i = 0;
        try{
            FileReader fr2 = new FileReader("Apellidos.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            String linea2 = br2.readLine();
            FileReader fr = new FileReader("Nombres.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            FileReader fr3 = new FileReader("Dir.txt");
            BufferedReader br3 = new BufferedReader(fr3);
            String linea3 = br3.readLine();
            
            StringTokenizer tokenizer = new StringTokenizer(linea,",");
            StringTokenizer tokenizer2 = new StringTokenizer(linea2,",");
            StringTokenizer tokenizer3 = new StringTokenizer(linea3,",");
            while(tokenizer.hasMoreTokens() && tokenizer2.hasMoreTokens()){
                Nombres[i] = tokenizer.nextToken();
                Ape[i] = tokenizer2.nextToken();
                Dir[i] = tokenizer3.nextToken();
                i++;
            }
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        Menu menu = new Menu();
        menu.inicio(Nombres, Ape, Dir);
        menu.imp();
    }
    
}
