package com.ampf.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class FailureResponse {
    String failureCode;
    String failureReason;

}
