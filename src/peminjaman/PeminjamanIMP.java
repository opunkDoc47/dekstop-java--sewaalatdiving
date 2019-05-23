/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman;

import pelanggan.Pelanggan;
import alat.AlatDiving;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
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


public class PeminjamanIMP implements DAOPeminjaman {

    public static List<ItemPeminjaman> listItem = new ArrayList<>();
    Dao<AlatDiving, Integer> daoalat;
    Dao<Pelanggan, Integer> daopelanggan;
    Dao<ItemPeminjaman, Integer> daoitem;
    Dao<Peminjaman, Integer> daopinjam;
    public static int id=0;
    public PeminjamanIMP() {
        try {
            daoalat = DaoManager.createDao(Koneksi.cs(), AlatDiving.class);
            daoitem = DaoManager.createDao(Koneksi.cs(), ItemPeminjaman.class);
            daopelanggan = DaoManager.createDao(Koneksi.cs(), Pelanggan.class);
            daopinjam = DaoManager.createDao(Koneksi.cs(), Peminjaman.class);
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertpeminjaman(Peminjaman peminjaman) {
        
        try {
            daopinjam.create(peminjaman);
            for (ItemPeminjaman i : listItem) {
                ItemPeminjaman item = new ItemPeminjaman();
                item.setSewa_idsewa(peminjaman);
                item.setQty(i.getQty());
                item.setSubtotal(i.getSubtotal());
                item.setAlat_idalat(i.getAlat_idalat());
                daoitem.create(item);
            }
            List<Peminjaman> list = daopinjam.queryForAll();
            for (Peminjaman p : list) {
                id = p.getIdsewa();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public double refreshTotal() {
        double total = 0;
        for (ItemPeminjaman item : listItem) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public List<AlatDiving> listalat() {
        List<AlatDiving> listalat = null;
        try {
            listalat = daoalat.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listalat;
    }

    @Override
    public void tambahList(ItemPeminjaman item) {
        listItem.add(item);
    }

    @Override
    public void hapusList(int id) {
        listItem.remove(id);
    }

    @Override
    public void updateList(int id, ItemPeminjaman item) {
        listItem.set(id, item);
    }

    @Override
    public DefaultTableModel viewItem() {
        DefaultTableModel dtm;
        String[] column = {"id alat", "nama alat", "jumlah sewa", "sub biaya"};
        dtm = new DefaultTableModel(null, column);
        for (ItemPeminjaman item : listItem) {
            Object[] object = new Object[4];
            object[0] = item.getAlat_idalat().getIdalat();
            object[1] = item.getAlat_idalat().getNamaalat();
            object[2] = item.getQty();
            object[3] = item.getSubtotal();
            dtm.addRow(object);
        }
        return dtm;
    }

    @Override
    public List<Pelanggan> listPelanggan() {
        List<Pelanggan> pelanggan = null;
        try {
            pelanggan = daopelanggan.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pelanggan;
    }

    @Override
    public void insertpelanggan(Object Pelanggan) {
        try {
            daopelanggan.create((Pelanggan) Pelanggan);
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cetak(String nama, int id) {
        File file = new File("src/report/" + nama + ".jrxml");
        try {
            JasperDesign design = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(design);
            HashMap parameter = new HashMap();
            parameter.put("ID", id);
            JasperPrint print = JasperFillManager.fillReport(report, parameter, new Koneksi().connection());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(PeminjamanIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
