/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author gearj
 */
public class AlumnoP {
    private String nombre,apPat,apMat,Dir;
    private int numCuenta,NumInscripcion,semestre,creditos,edad;

    public AlumnoP() {
    }

    public AlumnoP(int semestre, int creditos) {
        this.semestre = semestre;
        this.creditos = creditos;
    }

    
    public AlumnoP(String nombre, String apPat, String apMat, String Dir, int numCuenta, int NumInscripcion, int semestre, int creditos, int edad) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.Dir = Dir;
        this.numCuenta = numCuenta;
        this.NumInscripcion = NumInscripcion;
        this.semestre = semestre;
        this.creditos = creditos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getNumInscripcion() {
        return NumInscripcion;
    }

    public void setNumInscripcion(int NumInscripcion) {
        this.NumInscripcion = NumInscripcion;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "NumInscripcion=" + NumInscripcion + ", nombre=" + nombre + 
                ", apPat=" + apPat + ", apMat=" + apMat + ", Dir=" + Dir + 
                ", numCuenta=" + numCuenta + ", semestre=" + semestre + 
                ", creditos=" + creditos + ", edad=" + edad + '}';
    }
    
    public String toString2() {
        return NumInscripcion + "," + nombre + "," + apPat + "," 
                + apMat + "," + edad + "," + Dir + "," + numCuenta 
                + "," + semestre + "," + creditos ;
    }
    
    
    
    
}
