package org.example;

public class NoteBook {

    String brand, processor, os;
    int ram;
    int rom;


    public NoteBook(){

    }

    public void info(){
        System.out.println("--------------------/////-------------------");
        System.out.printf("Brand: %s\n", brand);
        System.out.printf("OS: %s; Processor: %s; Storage: %d Gb; RAM: %d Gb\n", os, processor, rom, ram);
    }

    public int getRam(){return ram;}

    public int getRom(){return rom;}

    public String getOS(){return os;}

    public String getBrand(){return brand;}

}
