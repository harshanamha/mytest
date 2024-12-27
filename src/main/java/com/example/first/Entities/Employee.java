package com.example.first.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EPF_NO", nullable = false, length = 50,unique = true)
    private String epfNo;

    @Column(name = "FullName", nullable = false,length = 100)
    private String fullName;

    @Column(name="Address", nullable = false)
    private String address;

    @Column(name="NIC")
    private String nic;

    @ManyToOne
    @JoinColumn(name="Department_id",nullable = false)
    private Department dep;

    @Column(name="Designation")
    private String designation;

    @Column(name="Email")
    private String email;

    @Column(name="Date_of_Birth")
    private LocalDate dob;

    @Column(name = "Mobile")
    private Integer mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpfNo() {
        return epfNo;
    }

    public void setEpfNo(String epfNo) {
        this.epfNo = epfNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }
}
