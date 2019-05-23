/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alat;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import peminjaman.ItemPeminjaman;
import pengembalian.ItemPengembalian;


@DatabaseTable(tableName = "alat")
public class AlatDiving {
   @DatabaseField(generatedId = true)
   private int idalat;
   @DatabaseField
   private String namaalat;
   @DatabaseField
   private double hargasewa;
   @DatabaseField
   private int jumlah;
   @ForeignCollectionField
   private ForeignCollection<ItemPeminjaman>item;
   @ForeignCollectionField
   private ForeignCollection<ItemPengembalian>itembalik;

    public ForeignCollection<ItemPengembalian> getItembalik() {
        return itembalik;
    }

    public void setItembalik(ForeignCollection<ItemPengembalian> itembalik) {
        this.itembalik = itembalik;
    }

    public ForeignCollection<ItemPeminjaman> getItem() {
        return item;
    }

    public void setItem(ForeignCollection<ItemPeminjaman> item) {
        this.item = item;
    }

    public int getIdalat() {
        return idalat;
    }

    public void setIdalat(int idalat) {
        this.idalat = idalat;
    }

    public String getNamaalat() {
        return namaalat;
    }

    public void setNamaalat(String namaalat) {
        this.namaalat = namaalat;
    }

    public double getHargasewa() {
        return hargasewa;
    }

    public void setHargasewa(double hargasewa) {
        this.hargasewa = hargasewa;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
