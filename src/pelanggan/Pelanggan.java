/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelanggan;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import peminjaman.Peminjaman;


@DatabaseTable(tableName = "pelanggan")
public class Pelanggan {
    @DatabaseField(generatedId = true)
    private int idpelanggan;
    @DatabaseField
    private String nik;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String alamat;
    @DatabaseField
    private String nohp;
     @ForeignCollectionField
    private ForeignCollection<Peminjaman> peminjaman;

    public ForeignCollection<Peminjaman> getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(ForeignCollection<Peminjaman> peminjaman) {
        this.peminjaman = peminjaman;
    }

    public int getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(int idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
