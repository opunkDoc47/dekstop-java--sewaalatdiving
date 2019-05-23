/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import peminjaman.Peminjaman;


@DatabaseTable(tableName = "user")
public class User {
    @DatabaseField(generatedId = true)
    private int iduser;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String username;
    @DatabaseField
    private String pass;
     @ForeignCollectionField
    private ForeignCollection<Peminjaman> peminjaman;

    public ForeignCollection<Peminjaman> getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(ForeignCollection<Peminjaman> peminjaman) {
        this.peminjaman = peminjaman;
    }

    public String getpass() {
        return pass;
    }

    public void setpass(String nohp) {
        this.pass = nohp;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setusername(String alamat) {
        this.username = alamat;
    }
    
}
