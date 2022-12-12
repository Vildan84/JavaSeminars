package org.example;

import java.util.Random;

public class creator {

    Random rand = new Random();
    private String[] brand = new String[]{"lenovo", "asus", "dell", "acer", "msi", "hp"};
    private String[] os = new String[]{"windows", "linux", "noos"};
    private String[] processor = new String[]{"core i3", "core i5", "core i7", "ryzen3", "ryzen5", "ryzen7"};
    private Integer[] ram = new Integer[]{1, 4, 8, 16, 32};
    private Integer[] rom = new Integer[]{256, 512, 1000};

    public void makeNote(NoteBook name){

        name.brand = brand[rand.nextInt(brand.length)];
        name.os = os[rand.nextInt(os.length)];
        name.processor = processor[rand.nextInt(processor.length)];
        name.ram = ram[rand.nextInt(ram.length)];
        name.rom = rom[rand.nextInt(rom.length)];
    }
}
