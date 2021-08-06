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
package controller;

import dto.DirectoryDTO;
import java.util.Date;
import model.Directory;
import view.ConsolView;

/**
 * Application Controller class.
 * @author Emanuel Mateus
 */
public class Controller {
    
    /**
    * Controller class constructor.
    */
    private ConsolView view;
    private DirectoryDTO dto;
    
    /**
     * Controller class constructor
     */
    public Controller(){
        
        this.view = new ConsolView();
        this.dto = new DirectoryDTO();
        this.start();
        
    }
    
    /**
     * Initial method of the program, specifically the program menu with its
     * various options.
     */
    public void start() {
        
        OUTER:
        while (true){ 
            this.dto.getdire_DAO().setList(this.dto.getdatos());
            this.view.menu();
            int opcion = this.view.readerInt("Opcion: ");
            switch (opcion) {
                case 100:
                    this.view.write("No se escribio un caracter valido");
                    this.view.nextLine();
                    break;
                case 1:
                    this.add();
                    break;
                case 2:
                    this.search();
                    break;
                case 3:
                    break;
                case 4:
                    this.remove();
                    break;
                case 5:
                    this.viewList();
                    break;
                case 6:
                    exit();
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
    
    public void add(){
        
        Directory student = new Directory();
        
        String name = this.view.readerString("Ingresar nombres: ");
        student.setName(name);
        
        String lastName = this.view.readerString("Ingresar apellidos: ");
        student.setLastName(lastName);
        
        Object birthday = this.view.readerDate("Ingresar fecha de nacimiento (YYYY-MM-DD): ");
        Date validateBirthday = (Date)this.validate(
                birthday, 
                "fecha mal escrita repita con el formato adecuado.", 
                "Ingresar fecha de nacimiento (YYYY-MM-DD): ",
                "Date",
                "Date");
        student.setBirthday(validateBirthday);

        Object institutionalMail = this.view.readerEmail("Ingresar correo institucional: ");
        String validateinstitutionalMail = (String)this.validate(
                institutionalMail, 
                "Correo mal escrito repita con el formato adecuado.", 
                "Ingresar correo institucional: ",
                "String",
                "Email");
        student.setInstitutionalMail(validateinstitutionalMail);
        
        
        Object personalMail = this.view.readerEmail("Ingresar correo personal: ");
        String validatepersonalMail = (String)this.validate(
                personalMail, 
                "Correo mal escrito repita con el formato adecuado.", 
                "Ingresar correo personal: ",
                "String",
                "Email");
        student.setPersonalMail(validatepersonalMail);
        
        Object cellPhone = this.view.readerLong("Ingresar número de celular: ");
        long validatecellPhone = (long)this.validate(
                cellPhone, 
                "Caracter no valido", 
                "Ingresar número de celular: ",
                "Long",
                "CellOrTel");
        student.setCellPhone(validatecellPhone);
        
        Object landLine = this.view.readerLong("Ingresar número fijo: ");
        long validatelandLine = (long)this.validate(
                landLine, 
                "Caracter no valido", 
                "Ingresar número fijo: ",
                "Long",
                "CellOrTel");
        student.setLandline(validatelandLine);
        
        String academicProgram = this.view.readerString("Ingresar programa: ");
        student.setAcademicProgram(academicProgram);
        
        this.dto.getdire_DAO().ingresar(student);
        this.view.write("Estudiamte Inscrito");
       
    }
    
    public void search(){
        Object institutionalMail = this.view.readerEmail("Ingresar correo institucional a buscar: ");
        String validateinstitutionalMail = (String)this.validate(
                institutionalMail, 
                "Correo mal escrito repita con el formato adecuado.", 
                "Ingresar correo institucional: ",
                "String",
                "Email");
        Directory studentSearch = this.dto.getdire_DAO().search(validateinstitutionalMail);
        if(studentSearch==null){
            this.view.separator();
            this.view.write("El correo no existe");
        }else{
            this.view.separator();
            this.view.write("El estudiante buscado es: ");
            this.view.write(studentSearch.toString());   
        }
    }
    
    public void remove(){
        Object institutionalMail = this.view.readerEmail("Ingresar correo institucional a buscar: ");
        String validateinstitutionalMail = (String)this.validate(
                institutionalMail, 
                "Correo mal escrito repita con el formato adecuado.", 
                "Ingresar correo institucional: ",
                "String",
                "Email");
        
        boolean respones = this.dto.getdire_DAO().remove(validateinstitutionalMail);
        if(respones){
            this.view.separator();
            this.view.write("Se elimino corectamento");
        }else{
            this.view.separator();
            this.view.write("Mo se pudo elininar o no existe el usuario a eliminar.");
        }
    }
    
    public void viewList(){
        this.view.write(this.dto.getdire_DAO().viewList());
    }
    
    
    /**
     * Method to send a goodbye message when closing program.
     */
    public void exit(){
        this.view.separator();
        this.view.write("Adios");
        this.view.separator();
    }
    
    private Object validate(Object obj, String msjerr, String msj,String typeFact ,String type){
        if(obj.getClass().getSimpleName().equals("Boolean")){
            while((boolean)obj){
                this.view.write(msjerr);
                this.view.nextLine();
                if(type.equals("Date")){
                    obj = this.view.readerDate(msj);
                }else if(type.equals("Email")){
                    obj = this.view.readerEmail(msj);
                }else if(type.equals("CellOrTel")){
                    obj = this.view.readerLong(msj);
                }else{
                    obj = this.view.readerString(msj);
                }
                
                if(obj.getClass().getSimpleName().equals(typeFact)){
                    break;
                }
            }
            return obj;
        }
        return obj;
    }
}
