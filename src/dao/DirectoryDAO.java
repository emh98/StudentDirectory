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
package dao;

import exception.EmailException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Directory;

/**
 *
 * @author Emanuel Mateus
 */
public class DirectoryDAO {
    
    private ArrayList<Directory> list;
    
    public DirectoryDAO() {
    
    }
    
    public ArrayList<Directory> getList(){
        return this.list;
    }
    
    public void setList(ArrayList<Directory> list){
        this.list = list;
    }

    public boolean ingresar(Directory student) {
            if (this.search(student.getInstitutionalMail()) == null) {
                    this.list.add(student);
                    return true;
            } else {
                    return false;
            }
    }

    public Directory search(Directory student) {

        Directory response = null;
        if(!this.list.isEmpty()){
            //for elemento in lista:
            for (Directory search : this.list) {
                if(student.getInstitutionalMail()
                        .equals(search.getInstitutionalMail())){
                    response = search;
                }
            }
        }
        return response;

    }
    
    public Directory search(String institutionalMail) {

        Directory response = null;
        if(!this.list.isEmpty()){
            //for elemento in lista:
            for (Directory search : this.list) {
                if(institutionalMail.equals(search.getInstitutionalMail())){
                    response = search;
                }
            }
        }
        return response;

    }

    public Directory modify(Directory student){
            Iterator<Directory> it2 = this.list.iterator();
            while (it2.hasNext()) {
                    Directory al = it2.next();
                    if (al.getInstitutionalMail().equals(student.getInstitutionalMail())) {
                        al.setName(student.getName());
                        al.setLastName(student.getLastName());
                        al.setBirthday(student.getBirthday());
                        al.setPersonalMail(student.getPersonalMail());
                        al.setInstitutionalMail(student.getInstitutionalMail());
                        break;
                    }
            }
            return null;
    }

    public boolean remove(String institutionalMail) {
            Directory deleted = this.search(institutionalMail);
            if (deleted == null) {
                    return false;
            } else {
                    this.list.remove(deleted);
                    return true;
            }
    }

    public String viewList() {
            String list = "";
            for (Directory student : this.list) {
                    list = list.concat(student.toString() + "\n");
            }
            return list;
    }
}
