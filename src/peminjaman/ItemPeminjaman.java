/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman;

import alat.AlatDiving;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "itemsewa")
public class ItemPeminjaman {

    @DatabaseField(generatedId = true)
    private int iditemsewa;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Peminjaman sewa_idsewa;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private AlatDiving alat_idalat;
    @DatabaseField
    private int qty;
    @DatabaseField
    private double subtotal;

    public int getIditemsewa() {
        return iditemsewa;
    }

    public void setIditemsewa(int iditemsewa) {
        this.iditemsewa = iditemsewa;
    }

    public Peminjaman getSewa_idsewa() {
        return sewa_idsewa;
    }

    public void setSewa_idsewa(Peminjaman sewa_idsewa) {
        this.sewa_idsewa = sewa_idsewa;
    }

    public AlatDiving getAlat_idalat() {
        return alat_idalat;
    }

    public void setAlat_idalat(AlatDiving alat_idalat) {
        this.alat_idalat = alat_idalat;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
