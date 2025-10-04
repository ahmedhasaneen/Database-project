package com.example.demo.service.admin;

import java.util.List;

import com.example.demo.model.Admin;


public interface AdminServiceImpl {
    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    void saveAdmin(Admin Admin);

    void deleteAdmin(Long id);
}
