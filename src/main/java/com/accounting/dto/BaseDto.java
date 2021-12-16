package com.accounting.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Data
public abstract class BaseDto {

    public Long id;

    public Date createdAt;

    public Date updatedAt;

}
