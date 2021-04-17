package com.conceptive.dcare.admin.dao.address;

import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NaturalIdCache
@Table(name = "address_type", schema = "dcare_master", catalog = "dcare")
@Immutable
public class AddressTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "adrs_typ_id", nullable = false)
    private int adrsTypId;


    @Basic
    @NaturalId
    @Column(name = "name", nullable = false, updatable = false, unique = true, length = 10)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressTypeEntity that = (AddressTypeEntity) o;
        return adrsTypId == that.adrsTypId &&
                Objects.equals(name, that.name);
    }

    public int getId(){
        return adrsTypId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(adrsTypId, name);
    }
}
