/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pelanggan.Pelanggan;
import peminjaman.ItemPeminjaman;
import peminjaman.Peminjaman;


public class DAOPengembalianIMP implements DAOPengembalian {

    Dao<Pengembalian, Integer> daoPengembalian;
    Dao<ItemPengembalian, Integer> daoitem;
    Dao<Pelanggan, Integer> daoPelanggan;
    Dao<Peminjaman, Integer> daoPeminjaman;
    Dao<ItemPeminjaman, Integer> daoItemPinjam;
    public static List<ItemPengembalian> listItem = new ArrayList<>();

    public DAOPengembalianIMP() {
        try {
            daoPelanggan = DaoManager.createDao(Koneksi.cs(), Pelanggan.class);
            daoPengembalian = DaoManager.createDao(Koneksi.cs(), Pengembalian.class);
            daoitem = DaoManager.createDao(Koneksi.cs(), ItemPengembalian.class);
            daoPeminjaman = DaoManager.createDao(Koneksi.cs(), Peminjaman.class);
            daoItemPinjam = DaoManager.createDao(Koneksi.cs(), ItemPeminjaman.class);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPengembalianIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertPengembalian(Pengembalian pengembalian) {
        try {
            daoPengembalian.create(pengembalian);
            for (ItemPengembalian item : listItem) {
                ItemPengembalian itemBalik = new ItemPengembalian();
                itemBalik.setPengembalian_idpengembalian(pengembalian);
                itemBalik.setAlat_idalat(item.getAlat_idalat());
                itemBalik.setQty(item.getQty());
                daoitem.create(itemBalik);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPengembalianIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel view() {
        String judul[] = {"NO PEMINJAMAN", "PEMINJAM", "TANGGAL", "TOTAL", "STATUS"};
        DefaultTableModel dtm = new DefaultTableModel(null, judul);
        List<Peminjaman> listPeminjaman = null;
        try {
            listPeminjaman = daoPeminjaman.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPengembalianIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Peminjaman p : listPeminjaman) {
            Object ob[] = new Object[5];
            ob[0] = p.getIdsewa();
            ob[1] = p.getPelanggan_idpelanggan().getNama();
            ob[2] = p.getTanggal();
            ob[3] = p.getTotal();
            ob[4] = p.getStatuspinjaman();
            dtm.addRow(ob);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel item(int key) {
        listItem.clear();
        String[] judul = {"NAMA ALAT", "JUMLAH", "SUB TOTAL"};
        DefaultTableModel dtm = new DefaultTableModel(null, judul);
        List<ItemPeminjaman> listItem = null;
        try {
            listItem = daoItemPinjam.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPengembalianIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ItemPeminjaman item : listItem) {
            if (item.getSewa_idsewa().getIdsewa() == key) {
                Object ob[] = new Object[3];
                ob[0] = item.getAlat_idalat().getNamaalat();
                ob[1] = item.getQty();
                ob[2] = item.getSubtotal();
                dtm.addRow(ob);
                ItemPengembalian itembalik = new ItemPengembalian();
                itembalik.setAlat_idalat(item.getAlat_idalat());
                itembalik.setQty(item.getQty());
                this.listItem.add(itembalik);
                
            }
        }
        return dtm;
    }

    @Override
    public List<Peminjaman> listPeminjaman() {
        List<Peminjaman> pinjam = new ArrayList<>();
        try {
            pinjam = daoPeminjaman.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPengembalianIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pinjam;
    }

    @Override
    public DefaultTableModel cari(int key) {
        int tag = 1;
        String judul[] = {"NO PEMINJAMAN", "PEMINJAM", "TANGGAL", "TOTAL", "STATUS"};
        DefaultTableModel dtm = new DefaultTableModel(null, judul);
        List<Peminjaman> listPeminjaman = null;
        try {
            listPeminjaman = daoPeminjaman.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPengembalianIMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Peminjaman p : listPeminjaman) {
            if (p.getIdsewa() == key) {
                Object ob[] = new Object[5];
                ob[0] = p.getIdsewa();
                ob[1] = p.getPelanggan_idpelanggan().getNama();
                ob[2] = p.getTanggal();
                ob[3] = p.getTotal();
                ob[4] = p.getStatuspinjaman();
                dtm.addRow(ob);
                tag = 0;
            }

        }
        if (tag == 1) {
            JOptionPane.showMessageDialog(null, "data kosong");
        }
        return dtm;
    }

}
