/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import peminjaman.Peminjaman;


public interface DAOPengembalian {
    public void insertPengembalian(Pengembalian pengembalian);
    public DefaultTableModel view();
    public DefaultTableModel item(int key);
    public DefaultTableModel cari(int key);
    public List<Peminjaman>listPeminjaman();
}
