package com.accounting.entitites;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    @DateTimeFormat
    public Date createdAt;

    @DateTimeFormat
    public Date updatedAt;

}
