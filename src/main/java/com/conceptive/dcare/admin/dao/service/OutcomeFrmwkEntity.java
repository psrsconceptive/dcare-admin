package com.conceptive.dcare.admin.dao.service;

import lombok.*;
import lombok.experimental.SuperBuilder;
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
@Table(name = "outcome_frmwk", schema = "dcare_master", catalog = "dcare")
public class OutcomeFrmwkEntity {
    @Id
    @Column(name = "otc_frmek_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int otcFrmekId;

    @NaturalId
    @Basic
    @Column(name = "name", nullable = true, length = 60)
    private String name;

    @OneToMany(mappedBy = "outcomeFramework",fetch = FetchType.LAZY)
    private Collection<ServiceEntity> services;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutcomeFrmwkEntity that = (OutcomeFrmwkEntity) o;
        return otcFrmekId == that.otcFrmekId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otcFrmekId, name);
    }

}
