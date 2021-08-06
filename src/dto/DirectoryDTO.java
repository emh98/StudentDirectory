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
package dto;

import dao.DirectoryDAO;
import java.util.ArrayList;
import model.Directory;

/**
 *
 * @author Emanuel Mateus
 */
public class DirectoryDTO {
    private ArrayList<Directory> list;
    private DirectoryDAO dirDAO;

    public DirectoryDTO() {
        list = new ArrayList<Directory>();
        dirDAO = new DirectoryDAO();	
    }

      public ArrayList<Directory> getdatos() {
            return list;
        }

        public void setdatos(ArrayList<Directory> datos) {
            this.list = datos;
        }

        public DirectoryDAO getdire_DAO() {
            return dirDAO;
        }

        public void setdire_DAO(DirectoryDAO dire_DAO) {
            this.dirDAO = dire_DAO;
        }
}
