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
    
    /**
     * Controller class constructor
     */
    public Controller(){
        
        view = new ConsolView();
        this.start();
        
    }
    
    /**
     * Initial method of the program, specifically the program menu with its
     * various options.
     */
    public void start() {
        OUTER:
        while (true) {
            this.view.menu();
            int opcion = this.view.readerInt("Opcion: ");
            switch (opcion) {
                case 100:
                    this.view.write("No se escribio un caracter valido");
                    this.view.nextLine();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    exit();
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
    /**
     * Method to send a goodbye message when closing program.
     */
    public void exit(){
        this.view.separator();
        this.view.write("Adios");
        this.view.separator();
    }
}
