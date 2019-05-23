/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman;

import pelanggan.Pelanggan;
import alat.AlatDiving;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public interface DAOPeminjaman {
    public void cetak(String nama,int id);
    public void insertpeminjaman(Peminjaman peminjaman);
    public void insertpelanggan(Object Pelanggan);
    public void tambahList(ItemPeminjaman item);
    public void hapusList(int id);
    public void updateList(int id,ItemPeminjaman item);
    public double refreshTotal();
    public List<AlatDiving> listalat();
    public List<Pelanggan> listPelanggan();
    public DefaultTableModel viewItem();
}
