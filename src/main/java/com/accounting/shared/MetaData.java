package com.accounting.shared;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
public class MetaData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
}