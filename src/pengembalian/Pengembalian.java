/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import pelanggan.Pelanggan;
import peminjaman.Peminjaman;
import user.User;


@DatabaseTable(tableName = "pengembalian")
public class Pengembalian {
    @DatabaseField(generatedId = true)
    private int idpengembalian;
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private User user_iduser;
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Pelanggan pelanggan_idpelanggan;
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Peminjaman sewa_idsewa;

   
    @DatabaseField
    private String tanggal;
    @DatabaseField
    private double denda;
    @ForeignCollectionField
    ForeignCollection<ItemPengembalian>item;

    public int getIdpengembalian() {
        return idpengembalian;
    }

    public void setIdpengembalian(int idpengembalian) {
        this.idpengembalian = idpengembalian;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    public ForeignCollection<ItemPengembalian> getItem() {
        return item;
    }

    public void setItem(ForeignCollection<ItemPengembalian> item) {
        this.item = item;
    } public User getUser_iduser() {
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

    public Peminjaman getSewa_idsewa() {
        return sewa_idsewa;
    }

    public void setSewa_idsewa(Peminjaman sewa_idsewa) {
        this.sewa_idsewa = sewa_idsewa;
    }
}
