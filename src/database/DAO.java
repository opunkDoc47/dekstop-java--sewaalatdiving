/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.swing.table.DefaultTableModel;


public interface DAO {
    public void insert(Object object);
    public void update(Object object);
    public void delete(int id);
    public DefaultTableModel view();
}
