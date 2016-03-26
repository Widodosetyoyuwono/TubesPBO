/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.learning;

/**
 *
 * @author LENOVO X230
 */
import java.util.Scanner;
import java.io.*;
public class Aplikasi {
    private Dosen[] daftarDosen = new Dosen[50];
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private Matakuliah[] daftarMatakuliah = new Matakuliah[50];
    int nd = 0, nmhs = 0;
    int nmatkul = 0;
    
    public void addDosen(Dosen d){
        if (nd<50) {
         daftarDosen[nd] = d;
         nd++;
        }
    }
    
    public void addMahasiswa(Mahasiswa m) {
        if (nmhs<100) {
         daftarMahasiswa[nmhs] = m;
         nmhs++;
        }
    }
    
    public void addMatakuliah(Matakuliah t) {
        if (nmatkul<50) {
         daftarMatakuliah[nmatkul] = t;
         nmatkul++;
        }
    }
        
    public Mahasiswa getMahasiswabyNim(long IdMhs) { 
        int a;
        for (a=0; a<100; a++) {
            if (daftarMahasiswa[a].getId() == IdMhs) {
                break;
            }   
        }        
        return daftarMahasiswa[a];
    }
    
    public Mahasiswa getMahasiswabyIndex(int index) {
        return daftarMahasiswa[index];
    }
        
    public void deleteMahasiswa(long IdMhs) {
        int a = 0;
        for (a=0; a<100; a++) {
            if ( daftarMahasiswa[a].getId() == IdMhs) {
                break;
            }
        }
        daftarMahasiswa[a] = null;
        for (int b=0;b<100;b++) {
            if (daftarMahasiswa[b] == null) {
                while(b<(100-b)){
                    daftarMahasiswa[b] = daftarMahasiswa[b+1];
                    b++;
                }
            }
        }
    }
    
    public Dosen getDosen(long IdDosen) { 
        int a = 0;
        for (a=0; a<50; a++) {
            if ( daftarDosen[a].getId() == IdDosen) {
                break;
            }
        }
        return daftarDosen[a];
    }
    
    public Dosen getDosenbyIndex(int index) {
        return daftarDosen[index];
    }
    
    public void deleteDosen(long IdDosen) {
        int a = 0;
        for (a=0; a<50; a++) {
            if ( daftarDosen[a].getId() == IdDosen) {
                break;
            }
        }
        daftarDosen[a] = null;
        for (int b=0;b<50;b++) {
            if (daftarDosen[b] == null) {
                while(b<(50-b)){
                    daftarDosen[b] = daftarDosen[b+1];
                    b++;
                }
            }
        }
    }
    
    public Matakuliah getMatkul(String KodeMK) { 
        int a = 0;
        for (a=0; a<50; a++) {
            if ( daftarMatakuliah[a].getKodeMk() == KodeMK) {
                break;
            }
        }
        return daftarMatakuliah[a];
    }
    
    public Matakuliah getMatkul(int index) {
        return daftarMatakuliah[index];
    }
    
    public void deleteMatkul(String KodeMK) {
        int a = 0;
        for (a=0; a<50; a++) {
            if ( daftarMatakuliah[a].getKodeMk() == KodeMK) {
                break;
            }
        }
        daftarMatakuliah[a] = null;
        for (int b=0;b<50;b++) {
            if (daftarMatakuliah[b] == null) {
                while(b<(5-b)){
                    daftarMatakuliah[b] = daftarMatakuliah[b+1];
                    b++;
                }
            }
        }
    }
               
    public void Menu1() { //add data dosen
        String nama,kodeDosen;
        long IdDosen;
        Scanner input=new Scanner(System.in);
        System.out.println("Input Data Dosen");
        System.out.print("Kode Dosen : ");
        kodeDosen = input.nextLine();
        System.out.print("Nama Dosen : ");
        nama = input.nextLine();
        System.out.print("NIP Dosen : ");
        IdDosen = input.nextLong();
        Dosen d = new Dosen (nama,IdDosen);
        d.setKdDosen(kodeDosen);
        addDosen(d);
    }
   
    public void Menu2() { //add Data Mahasiswa
        String nama;
        int semester;
        long IdMhs;
        Scanner input=new Scanner(System.in);
        System.out.println("Input Data Mahasiswa");
        System.out.print("Nama Mahasiswa : ");
        nama = input.nextLine();
        System.out.print("NIM Mahasiswa : ");
        IdMhs = input.nextLong();
        System.out.print("Semester : ");
        semester = input.nextInt();
        Mahasiswa m = new Mahasiswa(nama,IdMhs);
        m.setSmt(semester);
        addMahasiswa(m);
    }
    
    public void Menu3() {//add data Matakuliah
        String KodeMK,namaMK;
        System.out.println("Input Kode Matakuliah");
        System.out.print("Kode Matakuliah : ");
        Scanner input=new Scanner(System.in);
        KodeMK = input.nextLine();
        System.out.print("Nama Matakuliah : ");
        namaMK = input.nextLine();
        Matakuliah t = new Matakuliah(KodeMK,namaMK);
        addMatakuliah(t);       
    }
    
    public void Menu4() { //Cari Mahasiswa
        long IdMhs;
        System.out.println("Cari Mahasiswa");
        Scanner input=new Scanner(System.in);
        System.out.println("NIM Mahasiswa : ");
        IdMhs = input.nextLong();
        //System.out.println(getMahasiswabyNim(IdMhs).getId());
        getMahasiswabyNim(IdMhs).display();
    }
    
    public void Menu5() { //Cari dosen
        long IdDosen;
        System.out.println("Cari Dosen");
        Scanner input=new Scanner(System.in);
        System.out.println("NIP Dosen : ");
        IdDosen = input.nextLong();
        getDosen(IdDosen).display();
    }
    
    public void Menu6() {//cari Matakuliah
        String KodeMK;
        long IdDosen;
        System.out.println("Cari Matakuliah");
        Scanner input=new Scanner(System.in);
        System.out.println("Kode Matakuliah: ");
        KodeMK = input.nextLine();
        System.out.println("NIP Dosen: ");
        IdDosen = input.nextLong();
        getDosen(IdDosen).getKelas(nd).displayKelas();
    }
    
    public void Menu7() { //Delete data Mahasiswa
       long IdMhs;
        System.out.println("Hapus Data Mahasiswa");
        Scanner input=new Scanner(System.in);
        System.out.println("NIM Mahasiswa : ");
        IdMhs = input.nextLong();
        deleteMahasiswa(IdMhs);
    }
    
    public void Menu8() {//Delete Data Dosen
        long IdDosen;
        System.out.println("Hapus Data Dosen");
        Scanner input=new Scanner(System.in);
        System.out.println("NIP Dosen : ");
        IdDosen = input.nextLong();
        deleteDosen(IdDosen);
    }
    
    public void Menu9() {//delete data Matakuliah
        String KodeMK;
        System.out.println("Hapus Data Matakuliah");
        Scanner input=new Scanner(System.in);
        System.out.println("Kode Matakuliah : ");
        KodeMK = input.nextLine();
        deleteMatkul(KodeMK);
    }
    
    public void Menu10() { //Menu Tambah Mahasiswa
        long IdMhs,IdDosen;
        String KodeMK;
        int n;
        System.out.println("Tambah Mahasiswa di Kelas");
        Scanner input=new Scanner(System.in);
        System.out.println("NIP Mahasiswa : ");
        IdMhs = input.nextLong();
        System.out.println("NIP Dosen yang menginput : ");
        IdDosen = input.nextLong();
       getDosen(IdDosen).getKelas(nd).addMahasiswa(getMahasiswabyNim(IdMhs));
    }
    
    public void Menu11() { //Hapus Mahasiswa di kelas
        String KodeMK;
        long IdDosen;
        int index;
        Scanner input=new Scanner(System.in);
        System.out.println("Hapus Mahasiswa di Kelas");
        System.out.println("NIP Dosen yang menghapus : ");
        IdDosen = input.nextLong();
        System.out.println("index Mahasiswa : ");
        index = input.nextInt();
        getDosen(IdDosen).getKelas(nd).getMahasiswabyIndex(index);
    }
    
    public void Menu12() {//Add Tugas
        String tugas;
        long IdMhs,IdDosen;
        int n;
        System.out.println("Tambah Tugas");
        Scanner input=new Scanner(System.in);
        System.out.println("NIM Mahasiswa: ");
        IdMhs = input.nextLong();
        System.out.println("NIP Dosen : ");
        IdDosen = input.nextLong();
        System.out.println("Jumlah Tugas : ");
        n = input.nextInt();
        for(int a=0;a<n;a++){
            System.out.println("Tugas : ");
            tugas= input.nextLine();
           getDosen(IdDosen).getKelas(nd).createTugas(tugas);
        }
        
    }    
    
    public void Menu13() {//Delete Tugas
        String KodeMK;
        
        long IdMhs,IdDosen;
        int n;
        System.out.println("Hapus Tugas Mahasiswa");
        Scanner input=new Scanner(System.in);
        System.out.println("NIP dosen : ");
        IdDosen = input.nextLong();
        System.out.println("Tugas Mahasiswa: ");
        for(int a=0;a<100;a++) {
           if (getDosen(IdDosen).getKelas(nd).getTugas(a) != null) {
                System.out.println((a+1)+". "+getDosen(IdDosen).getKelas(nd).getTugas(a));
           }
           else {
               break;
            }
        }
        System.out.println("Hapus Tugas ke : ");
        n = input.nextInt();
        getDosen(IdDosen).getKelas(nd).getTugas(n);        
    }
        
    public void MainMenu() {
        int pilih,ulang = 1;
        do{
        System.out.println("+---------------------------------------------------+");    
        System.out.println("+|                SELAMAT DATANG                   |+");
        System.out.println("+|    Aplikasi eLearning Teknik Informatika        |+");
        System.out.println("+|              TELKOM UNIVERSITY                  |+");
        System.out.println("+|-------------------------------------------------|+");
        System.out.println("+| Menu Dosen:                                     |+");
        System.out.println("+| 1. Input Data Dosen                             |+"); 
        System.out.println("+| 2. Cari Data Dosen                              |+");
        System.out.println("+| 3. Delete Data Dosen                            |+");
        System.out.println("+| 4. Tambahkan Mahasiswa di Kelas                 |+");
        System.out.println("+| 5. Hapus Mahasiswa di Kelas                     |+");
        System.out.println("+| 6. Tambahkan Tugas Mahasiswa                    |+");
        System.out.println("+| 7. Delete Tugas Mahasiswa                       |+");
        System.out.println("+| Menu Mahasiswa:                                 |+");
        System.out.println("+| 8. Input Data Mahasiswa                         |+");
        System.out.println("+| 9. Cari Data Mahasiswa                          |+");
        System.out.println("+| 10.Delete Data Mahasiswa                        |+");
        System.out.println("+| Menu Lain:                                      |+");
        System.out.println("+| 11. Input Matakuliah                            |+");
        System.out.println("+| 12. Cari Matakuliah                             |+");
        System.out.println("+| 13. Delete Matakuliah                           |+");
        System.out.println("+| 14. Keluar                                      |+");
        Scanner input=new Scanner(System.in);
        System.out.println("Pilih Menu : ");
        pilih = input.nextInt();
        switch(pilih){
            case 1:
                Menu1();
                
                break;
            case 2:
                Menu5();
                break;
            case 3:
                Menu8();
                break;
            case 4:
                Menu10();
                break;
            case 5:
                Menu11();
                break;
            case 6:
                Menu12();
                break;
            case 7:
                Menu13();
                break;
            case 8:
                Menu2();
                break;
            case 9:
                Menu4();
                break;
            case 10:
                Menu7();
                break;
            case 11:
                Menu3();
                break;
            case 12:
                Menu6();
                break;
            case 13:
                Menu9();
                break;
            case 14:
                ulang = 0;
                break;
        }
        
    } while(ulang == 1);
        
   }
}    
