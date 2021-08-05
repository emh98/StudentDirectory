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
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Emanuel Mateus
 */
public class Directory {
    
    private String name;
    private String lastName;
    private Date birthday;
    private String institutionalMail;
    private String personalMail;
    private long cellPhone;
    private long landline;
    private String academicProgram;

    public Directory(){

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String birthday) throws ParseException {
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
        this.birthday = format.parse(birthday);
    }

    public String getInstitutionalMail() {
        return this.institutionalMail;
    }

    public void setInstitutionalMail(String institutionalMail) {
        this.institutionalMail = institutionalMail;
    }

    public String getPersonalMail() {
        return this.personalMail;
    }

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }

    public long getCellPhone() {
        return this.cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public long getLandline() {
        return this.landline;
    }

    public void setLandline(long landline) {
        this.landline = landline;
    }

    public String getAcademicProgram() {
        return this.academicProgram;
    }

    public void setAcademicProgram(String academicProgram) {
        this.academicProgram = academicProgram;
    }

    @Override
    public String toString() {

        return  "Nombres: " + name + "\n" 
                + "Apellidos: " + lastName + "\n" 
                + "Fecha de nacimiento:" + birthday + "\n" 
                + "Correo institucional: " + institutionalMail + "\n" 
                + "Correo personal: " + personalMail + "\n" 
                + "N�mero telef�nico celular: " + cellPhone + "\n" 
                + "N�mero telef�nico fijo: " + landline + "\n" 
                + "N�mero telef�nico fijo: " + academicProgram + "\n";

    }
    
}
