package com.conceptive.dcare.admin.dao.service;

import com.conceptive.dcare.admin.dao.Auditable;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "service_category", schema = "dcare_master", catalog = "dcare")
@NaturalIdCache
public class ServiceCategoryEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "cat_id", nullable = false)
    private int catId;

    @Basic
    @NaturalId
    @Column(name = "code", nullable = true, length = 10)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Basic
    @Column(name = "description", nullable = true, length = 60)
    private String description;

    @OneToOne
    @JoinColumn(name = "prnt_ser_cat_id", referencedColumnName = "cat_id")
    private ServiceCategoryEntity parentServiceCategory;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceCategoryEntity that = (ServiceCategoryEntity) o;
        return catId == that.catId &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, code, name, description);
    }


}
