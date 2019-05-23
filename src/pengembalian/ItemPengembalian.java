/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengembalian;

import alat.AlatDiving;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "itempengembalian")
public class ItemPengembalian {
    @DatabaseField(generatedId = true)
    private int iditempengembalian;
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Pengembalian pengembalian_idpengembalian;
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private AlatDiving alat_idalat;
    @DatabaseField
    private int qty;

    public int getIditempengembalian() {
        return iditempengembalian;
    }

    public void setIditempengembalian(int iditempengembalian) {
        this.iditempengembalian = iditempengembalian;
    }

    public Pengembalian getPengembalian_idpengembalian() {
        return pengembalian_idpengembalian;
    }

    public void setPengembalian_idpengembalian(Pengembalian pengembalian_idpengembalian) {
        this.pengembalian_idpengembalian = pengembalian_idpengembalian;
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
}
