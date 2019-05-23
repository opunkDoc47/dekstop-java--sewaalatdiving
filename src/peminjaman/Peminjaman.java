/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman;

import pelanggan.Pelanggan;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import pengembalian.Pengembalian;
import user.User;


@DatabaseTable(tableName = "sewa")
public class Peminjaman {

    @DatabaseField(generatedId = true)
    private int idsewa;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user_iduser;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pelanggan pelanggan_idpelanggan;
    @DatabaseField
    private String tanggal;
    @DatabaseField
    private double total;
    @DatabaseField
    private String statuspinjaman;
    @ForeignCollectionField
    private ForeignCollection<ItemPeminjaman> item;
    @ForeignCollectionField
    private ForeignCollection<Pengembalian> kembali;

    public int getIdsewa() {
        return idsewa;
    }

    public void setIdsewa(int idsewa) {
        this.idsewa = idsewa;
    }

    public User getUser_iduser() {
        return user_iduser;
    }

    public void setUser_iduser(User user_iduser) {
        this.user_iduser = user_iduser;
    }

    public Pelanggan getPelanggan_idpelanggan() {
        return pelanggan_idpelanggan;
    }

    public void setPelanggan_idpelanggan(Pelanggan pelanggan_idpelanggan) {
        this.pelanggan_idpelanggan = pelanggan_idpelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatuspinjaman() {
        return statuspinjaman;
    }

    public void setStatuspinjaman(String statuspinjaman) {
        this.statuspinjaman = statuspinjaman;
    }

    public ForeignCollection<ItemPeminjaman> getItem() {
        return item;
    }

    public void setItem(ForeignCollection<ItemPeminjaman> item) {
        this.item = item;
    }

   
}
