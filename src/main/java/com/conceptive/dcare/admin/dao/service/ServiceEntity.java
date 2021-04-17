package com.conceptive.dcare.admin.dao.service;

import com.conceptive.dcare.admin.dao.Auditable;
import com.conceptive.dcare.admin.dao.provider.ProviderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "service", schema = "dcare_master", catalog = "dcare")
public class ServiceEntity extends Auditable {
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    @Column(name = "service_id", nullable = false)
    private int serviceId;

    @Basic
    @Column(name = "code", nullable = true, length = 10)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Basic
    @Column(name = "description", nullable = true, length = 80)
    private String description;

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    private ServiceCategoryEntity serviceCategory;

    @ManyToOne
    @JoinColumn(name="rsc_grp_id")
    private RegistrationGroupEntity registrationGroup;

    @ManyToOne
    @JoinColumn(name="supt_purs_id")
    private SupportPurposeEntity supportPurpose;

    @ManyToOne
    @JoinColumn(name="otc_frmek_id")
    private OutcomeFrmwkEntity outcomeFramework;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "provider_service",
            joinColumns = {
                    @JoinColumn(name = "service_id", referencedColumnName = "service_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id",
                            nullable = false, updatable = false)})
    private Set<ProviderEntity> providers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return serviceId == that.serviceId &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, code, name, description);
    }



}
