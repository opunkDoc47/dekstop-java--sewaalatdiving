/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alat;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class DAOAlatDivingIMP implements DAO{

    Dao<AlatDiving,Integer> dao;
    
    public DAOAlatDivingIMP(){
        try {
            dao=DaoManager.createDao(Koneksi.cs(), AlatDiving.class);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlatDivingIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    /*
    memasuka data ke tabel alat
    */
    public void insert(Object alat) {
        try {
            dao.create((AlatDiving)alat);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlatDivingIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    /*
    merubah data yang ada di tabel alat
    */
    public void update(Object alat) {
        try {
            dao.update((AlatDiving)alat);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlatDivingIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    /*
    menghapus data yang ada di tabel alat sesuai parameter id
    */
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlatDivingIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    /*
    berfungsi memodelkan tabel yang ada di form
    */
    public DefaultTableModel view() {
        String[]kolom={"kode alat","nama alat","harga sewa","jumlah"};
        DefaultTableModel dtm =new DefaultTableModel(null, kolom);
    try {
        List<AlatDiving> h =dao.queryForAll();
        for(AlatDiving u:h){
        Object o []=new Object[4];
        o[0]=u.getIdalat();
        o[1]=u.getNamaalat();
        o[2]=u.getHargasewa();
        o[3]=u.getJumlah();
        dtm.addRow(o);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DAOAlatDivingIMP.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dtm;
    }
    /*
    mencetak data alat
    */
    public static void cetak(String nama){
    File file = new File("src/report/" + nama + ".jrxml");
        try {
            JasperDesign design = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(design);
            HashMap parameter = new HashMap();
            parameter=null;
            JasperPrint print = JasperFillManager.fillReport(report, parameter, new Koneksi().connection());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(DAOAlatDivingIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
