/*
 * Copyright (C) 2021 Emanuel Mateus
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that allows you to design the visual to the console.
 * @author Emanuel Mateus
 */
public class ConsolView {
    
    /**
     * The scanner.
     */ 
    private Scanner reader;
    
    /**
     * ConsolView class constructor.
     */
    public ConsolView(){
        reader = new Scanner(System.in);
    }
    
    /**
     * System.out.println method overridden.
     * @param msj Message to print
     */
    public void write(String msj){
        System.out.println(msj);
    }
    
    /**
     * System.out.print method overridden.
     * @param msj Message to print
     */
    public void writeNoBreak(String msj){
        System.out.print(msj);
    }
    
    /**
     * Scanner(System.in).next() method overridden.
     * @param msj Input title
     * @return The text captured by console.
     */
    public String readerString(String msj){
        
        this.writeNoBreak(msj);
        return this.reader.next();
    }

    /**
     * Scanner(System.in).nextInt() method overridden,
     * with a validation if a wrong character is typed.
     * @param msj Input title
     * @return The number captured by console.
     */
    public int readerInt(String msj){
        
        this.writeNoBreak(msj);
        int fact;
        try {
            fact = this.reader.nextInt();
        } catch (InputMismatchException e) {
            fact = 100;
        }
        return fact;
    }
    
    /**
     * Scanner(System.in).nextLong() method overridden, 
     * with a validation if a wrong character is typed.
     * @param msj Input title
     * @return The number captured by console.
     */
    public Object readerLong(String msj){
        
        this.writeNoBreak(msj);
        Object fact;
        try {
            fact = this.reader.nextLong();
        } catch (InputMismatchException e) {
            fact = true;
        }
        return fact;
    }
    public Object readerDate(String msj){
        this.writeNoBreak(msj);
        Object fact;
        try {
            DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            fact = (Date)format.parse(this.reader.next());
        } catch (ParseException e) {
            fact = true;
        }
        return fact;
        
    }
    
    public Object readerEmail(String msj){
        this.writeNoBreak(msj);
        Object fact;
        Pattern pattern = Pattern.compile(
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        );
        
        fact = this.reader.next();
        Matcher mather = pattern.matcher((String)fact);
        
        if (mather.find() == false) {
            fact = true;
        }
        
        return fact;
    }
    
    
    /**
     * Scanner(System.in).nextLine() method overridden.
     */
    public void nextLine(){
        this.reader.nextLine();
    }
    
    /**
     * Representation of a separator for the console.
     */
    public void separator(){
        this.write("///=============0000000===========///");
    }
    
    /**
     * Graphic representation of the program menu.
     */
    public void menu(){
        this.separator();
        this.write("INSTITUTO LA FLORESTA");
        this.write("Seleccione tarea a realizar:");
        this.write("1. Ingresar estudiante");
        this.write("2. Buscar estudiante");
        this.write("3. Modificar estudiante");
        this.write("4. Eliminar Estudiante");
        this.write("5. Ver directorio de estudiantes");
        this.write("6. Salir");
        this.separator();
    }
        
}
