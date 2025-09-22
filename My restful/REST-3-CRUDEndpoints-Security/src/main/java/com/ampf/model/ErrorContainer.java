package com.ampf.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorContainer{
    String errDetails;
    int status;
}