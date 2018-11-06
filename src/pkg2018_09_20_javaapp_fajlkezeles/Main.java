/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2018_09_20_javaapp_fajlkezeles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static List<String> data; 
    public static void main(String[] args)
    {
        data = Fajlolvasas("applicants.txt");
        System.out.println(data.size());
        int db = 0;
        for (int i = 0; i < data.size(); i++)
        {
            if (data.get(i).equals("Sex:Female"))
            {
                db++;
            }
        }
        System.out.println("A nők száma: " + db);
        Fajl_nok_iras("nok.txt");
    }
    public static List<String> Fajlolvasas (String fajlNev)
    {
        List<String> adatok = new ArrayList<String>();
        try
        {
            Scanner scann = new Scanner(new File(fajlNev));
            while (scann.hasNextLine())
            {
                String sor = scann.nextLine();
                adatok.add(sor);
            }
            scann.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println("Hiba: " + ex);
        }
        return adatok;
    }
    public static void Fajl_nok_iras(String fajlnev)
    {
        try
        {
            FileWriter fw = new FileWriter(fajlnev);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < data.size(); i++)
            {
                if(data.get(i).equals("Sex:Female"))
                {
                    pw.println(
                            nevLevalaszt(data.get(i-1)) + " " +  
                            nevLevalaszt(data.get(i-2)));
                }
            }
            pw.close();
            fw.close();
        }
        catch (IOException ex)
        {
            System.out.println("Hiba: " + ex);
        }
    }
    public static String nevLevalaszt(String s)
    {
        /*
        s.replaceAll("First name:","");
        s.replaceAll("Last name:","");
        return s;
                */
        
        String[] adatok = s.split(":");
        return adatok[1]; 
    }
}