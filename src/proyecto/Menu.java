/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gearj
 */
public class Menu {
    private List<AlumnoP> Alumnos;
    private ServiciosEscolares SE = new ServiciosEscolares();

    public Menu() {
    }

    public Menu(List<AlumnoP> Alumnos) {
        this.Alumnos = Alumnos;
    }
    
    public void inicio(String[] Nombres,String[ ] Ape,String[ ] Dir){
        Random random = new Random();
        this.Alumnos = SE.AlumnosA();
        for (AlumnoP alumnoActual : Alumnos) {
            alumnoActual.setNombre(Nombres[random.nextInt(50)]);
            alumnoActual.setApMat(Ape[random.nextInt(50)]);
            alumnoActual.setApPat(Ape[random.nextInt(50)]);
            alumnoActual.setEdad(random.nextInt(10)+18);
            alumnoActual.setNumCuenta(((random.nextInt(899999)+100000)*1000)+alumnoActual.getNumInscripcion()+365);
            alumnoActual.setDir(Dir[random.nextInt(50)]);
        }
    }
    
    public void imp() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);
        int i = 0;
        while(i == 0){
            System.out.println("""
                               
                               
                               Gesti\u00f3n Escolar
                               
                               1.-Mostrar Base de Datos
                               2.-Buscar Alumno
                               3.-Cambiar datos de alumno
                               4.-A\u00f1adir Alumno
                               5.-Salir
                               
                               Elige una Opci\u00f3n:""");
            String Opc = in.readLine();
            switch (Opc) {
                case "1" -> {
                    for (AlumnoP alu : this.Alumnos) {
                        System.out.println(alu);
                    }
                }
                case "2" -> {
                    System.out.println("""
                                       Quieres buscar por nombre o n\u00famero de inscripci\u00f3n?
                                       1.-Nombre
                                       2.-N\u00famero de Inscripci\u00f3n
                                       
                                       Opci\u00f3n:""");
                    String Opc2 = in.readLine();
                    switch(Opc2){
                        case "1" -> {
                            System.out.println("Dame un nombre:");
                            String nom = in.readLine();
                            this.SE.BuscarNom(Alumnos, nom);
                        }
                        case "2" -> {
                            System.out.println("Dame un numero de inscripción:");
                            int num = reader.nextInt();
                            this.SE.Buscar(Alumnos, num);
                        }
                        default -> System.out.println("Opción no valida");
                    }
                }
                case "3" -> {
                    System.out.println("Dame un numero de inscripción:");
                    int num = reader.nextInt();
                    this.SE.CambiarDatos(Alumnos, num);
                    System.out.println("Datos cambiados correctamente");
                }
                case "4" -> {
                    this.Alumnos = this.SE.anadir(Alumnos);
                }
                case "5" -> {
                    System.out.println("Creando Archivo...");
                    this.SE.creaArch(Alumnos);
                    i = 1;
                }
                default -> System.out.println("Opción no valida");
            }
        }
    }

    public List<AlumnoP> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(ArrayList<AlumnoP> Alumnos) {
        this.Alumnos = Alumnos;
    }

    public ServiciosEscolares getSE() {
        return SE;
    }

    public void setSE(ServiciosEscolares SE) {
        this.SE = SE;
    }
      
    
}
