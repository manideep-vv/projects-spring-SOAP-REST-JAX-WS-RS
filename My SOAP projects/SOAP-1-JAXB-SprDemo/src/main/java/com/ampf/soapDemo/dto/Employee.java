package com.ampf.soapDemo.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "employee1")
@XmlRootElement()
@XmlType(name = "employoo")
public class Employee {

    @XmlElement(name = "employeeName")
    String empName;
    @XmlElement(name = "empRollNumber")
    Integer rollNum;
    public Employee(String empName, Integer rollNum) {
        this.empName = empName;
        this.rollNum = rollNum;
    }
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", rollNum=" + rollNum +
                '}';
    }
}
