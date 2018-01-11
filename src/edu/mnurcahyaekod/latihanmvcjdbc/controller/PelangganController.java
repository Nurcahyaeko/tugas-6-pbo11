/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mnurcahyaekod.latihanmvcjdbc.controller;

import edu.mnurcahyaekod.latihanmvcjdbc.model.PelangganModel;
import edu.mnurcahyaekod.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan(); 
    }
    
    public void insertPelanggan(PelangganView view){

        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
     
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        }else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih dari 255 Karakter");
        }else if (telepon.length()>12) {
            JOptionPane.showMessageDialog(view, "No Telp tidak boleh lebih dari 12 digit");
        }else if (!email.contains("@")||!email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        }else{    
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
        
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view,"Pelanggan Berhasi Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi eror di database", throwable.getMessage()});
            }
            }
    }
    
    public void updatePelanggan(PelangganView view){

        if (view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang Akan Diubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
     
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        }else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih dari 255 Karakter");
        }else if (telepon.length()>12) {
            JOptionPane.showMessageDialog(view, "No Telp tidak boleh lebih dari 12 digit");
        }else if (email.contains("@")||!email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email Tidak Valid");
        }else{
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
        
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view,"Update Berhasi DitambahkDiubahan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi eror di database", throwable.getMessage()});
            }
            }
    }
    
    public void deletePelanggan(PelangganView view){
        if (view.getTablePelanggan().getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang Akan Dihapus");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus ?")==JOptionPane.OK_CANCEL_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view,"Pelangan Berhasil Dihapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi eror di database", throwable.getMessage()});
            }
        }
    }
}
