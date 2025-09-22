package com.ampf.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    Long id;
    String name;
    String brand;
}
