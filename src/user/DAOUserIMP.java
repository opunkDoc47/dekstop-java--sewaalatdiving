/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class DAOUserIMP implements DAO {

    Dao<User, Integer> dao;

    public DAOUserIMP() {
        try {
            
            // menghubungkan method cs yang ada di koneksi.java dengan dao
            dao = DaoManager.createDao(Koneksi.cs(), User.class);
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    //tambah data ke tabel user
    public void insert(Object User) {
        try {
            dao.create((User)User);
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    //merubah data di tabel user
    public void update(Object User) {
        try {
            dao.update((User)User);
        } catch (SQLException ex) {
           Logger.getLogger(DAOUserIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    //menghapus data di tabel user
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    /*
    mengatur isi tabel di form user
    */
    public DefaultTableModel view() {
        String[]kolom={"kode pegawai","Nama Pegawai","Username","password"};
        DefaultTableModel dtm =new DefaultTableModel(null, kolom);
    try {
        List<User> h =dao.queryForAll();
        for(User u:h){
        Object o []=new Object[4];
        o[0]=u.getIduser();
        o[1]=u.getNama();
        o[2]=u.getUsername();
        o[3]=u.getpass();
        dtm.addRow(o);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DAOUserIMP.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dtm;
    }
    
}
