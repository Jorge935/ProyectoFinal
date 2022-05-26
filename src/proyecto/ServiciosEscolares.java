/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author gearj
 */
public class ServiciosEscolares {
    
    public List<AlumnoP> AlumnosA(){
        int [] arr = new int[500];
        int n = arr.length;
        int [] arr2;
        List<AlumnoP> lista = new ArrayList<>();
        AlumnoP [] arr3 = new AlumnoP[500];
        for (int i = 0; i < n; i++) {
           Random random = new Random();
            int sem = random.nextInt(10)+2;
            int acreditadas = 51;
            int promedio = random.nextInt(5)+6;
            while (acreditadas > sem*5 || acreditadas > 50)
                acreditadas = random.nextInt(sem*5)+5;
            int creditos = acreditadas*random.nextInt(3)+6;
            int num = promedio*((acreditadas*100)/((sem*5)))*((creditos*100)/((sem*5)*8));
            arr[i] = num;
            AlumnoP alu = new AlumnoP(sem, creditos);
            arr3[i] = alu;
        }
        arr2 = arr;
	quickSort(arr2, 0, n - 1);
        int repetido = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            int index = linearSearch(arr, arr2[i])+1;
            if (index == repetido) {
                r += 1;
                index += r;
            }else{
                repetido = index;
                r = 0;
            }
            arr3[i].setNumInscripcion(index);
            lista.add(arr3[i]);
        }
        return lista;
        
    }
    
    public void Buscar(List<AlumnoP> lista, int numIns){
        for (AlumnoP alu : lista) {
            if (alu.getNumInscripcion() == numIns){
                System.out.println(alu);
                return;
            }
        }
    }
    public void BuscarNom(List<AlumnoP> lista, String nom){
        for (AlumnoP alu : lista) {
            if (alu.getNombre().equalsIgnoreCase(nom) ){
                System.out.println(alu);
            }
        }
    }
    
    public List<AlumnoP> CambiarDatos(List<AlumnoP> lista, int numIns) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);
        for (AlumnoP alu : lista) {
            if (alu.getNumInscripcion() == numIns){
                System.out.println(alu+"\nDame un nuevo nombre:");
                String nom = in.readLine();
                alu.setNombre(nom);
                System.out.println("\nDame un nuevo apellido paterno:");
                String ApeP = in.readLine();
                alu.setApPat(ApeP);
                System.out.println("\nDame un nuevo apellido paterno:");
                String ApeM = in.readLine();
                alu.setApMat(ApeM);
                System.out.println("\nDame una nueva dirección:");
                String dir = in.readLine();
                alu.setDir(dir);
                System.out.println("\nDame la edad:");
                int num = reader.nextInt();
                alu.setEdad(num);
                return lista;
            }
        }
        return null;
    }
    
    public List<AlumnoP> anadir(List<AlumnoP> lista) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);
        AlumnoP alu = new AlumnoP();
        System.out.println("\nDame un nuevo nombre:");
        String nom = in.readLine();
        alu.setNombre(nom);
        System.out.println("\nDame un nuevo apellido paterno:");
        String ApeP = in.readLine();
        alu.setApPat(ApeP);
        System.out.println("\nDame un nuevo apellido paterno:");
        String ApeM = in.readLine();
        alu.setApMat(ApeM);
        System.out.println("\nDame una nueva dirección:");
        String dir = in.readLine();
        alu.setDir(dir);
        System.out.println("\nDame la edad:");
        int num = reader.nextInt();
        alu.setEdad(num);
        System.out.println("\nDame los creditos:");
        int creditos = reader.nextInt();
        alu.setCreditos(creditos);
        System.out.println("\nDame el semestre:");
        int semestre = reader.nextInt();
        alu.setSemestre(semestre);
        System.out.println("\nDame el número de cuenta:");
        int numC = reader.nextInt();
        alu.setNumCuenta(numC);
        alu.setNumInscripcion(lista.size()+1);
        lista.add(alu);
        System.out.println("Alumno añadido correctamente");
        return lista;
        
    }

    public void creaArch(List<AlumnoP> lista) throws IOException{
        FileWriter fw = new FileWriter("Gestión_Escolar.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter salida = new PrintWriter(bw)) {
            salida.println("Numero de Inscripcion,Nombre,Apellido Paterno"
                    + ",Apellido Materno,Edad,Direccion,Numero de Cuenta,"
                    + "Semestre,Creditos");
            for (AlumnoP alu : lista) {
                salida.println(alu.toString2());
            }
            salida.close();
        }
    }
    
    public ServiciosEscolares() {
    }
    
    static void swap(int[] arr, int i, int j){
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high){
    	int pivot = arr[high];
    	int i = (low - 1);
        
            for(int j = low; j <= high - 1; j++)
            {
            	if (arr[j] < pivot)
            	{
            		i++;
            		swap(arr, i, j);
            	}
	}   
	swap(arr, i + 1, high);
	return (i + 1);
    }
    static void quickSort(int[] arr, int low, int high){
	if (low < high)
	{
		int pi = partition(arr, low, high);
		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
    }
    
    public static int linearSearch(int arr[], int elementToSearch) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }
    
}


