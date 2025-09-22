package com.ampf.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@XmlRootElement(name="Patient")
public class Patient {

    Integer id;
    String name;

    public Patient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
