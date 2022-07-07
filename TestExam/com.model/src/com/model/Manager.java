package com.model;

import java.security.InvalidParameterException;

//iztochnik na subitito v sluchaq
public class Manager extends Employee{
    private String manageDeptName;
    private StaffAppointHandler staffAppoint;

    public Manager(String name, double salary, String manageDeptName) {
        super(name, salary);
        setManageDeptName(manageDeptName);
    }

    public String getManageDeptName() {
        return manageDeptName;
    }

    public void setManageDeptName(String manageDeptName) {
        if(manageDeptName == null){
            throw new InvalidParameterException();
        }
        else{
            this.manageDeptName = manageDeptName;
        }
    }

    //callback
    public void addStaffAppointHandler(StaffAppointHandler handler){
        this.staffAppoint = handler;
    }

    //izstrelvane na subitieto
    public void onStaffAppoint(Staff member, double newStaffMemberSalary){
        if(staffAppoint!= null) {
            StaffAppointEventArgs event = new StaffAppointEventArgs(member, newStaffMemberSalary);
            staffAppoint.addStaff(event);
        }
    }

    @Override
    public String toString() {
        return String.format("%s, manageDeptName: %s", super.toString(), manageDeptName);
    }
}
