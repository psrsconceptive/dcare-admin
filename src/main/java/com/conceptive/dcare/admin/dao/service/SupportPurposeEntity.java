package com.conceptive.dcare.admin.dao.service;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NaturalIdCache
@Table(name = "support_purpose", schema = "dcare_master", catalog = "dcare")
public class SupportPurposeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    @Column(name = "supt_purs_id", nullable = false)
    private int suptPursId;

    @NaturalId
    @Basic
    @Column(name = "name", nullable = true, length = 60)
    private String name;

    @OneToMany(mappedBy = "supportPurpose")
    private Collection<ServiceEntity> services;

 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupportPurposeEntity that = (SupportPurposeEntity) o;
        return suptPursId == that.suptPursId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suptPursId, name);
    }

}
