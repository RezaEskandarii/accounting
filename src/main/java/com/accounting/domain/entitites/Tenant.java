package com.accounting.domain.entitites;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Getter
@Entity
@Table(name = "tenants", uniqueConstraints = {
        @UniqueConstraint(columnNames = "title")
})
public class Tenant extends BaseEntity {

    public Tenant() {

    }

    @Column(name = "title", length = 100)
    public String title;

    @Column(name = "hash", length = 255)
    public String hash;


//    @Column(columnDefinition = "json")
//    @JsonRawValue
//    private MetaData extraData ;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tenant_members",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "tenant_id")}
    )
    Set<User> users = new HashSet<>();
}
