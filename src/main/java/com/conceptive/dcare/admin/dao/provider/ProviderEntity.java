package com.conceptive.dcare.admin.dao.provider;

import com.conceptive.dcare.admin.dao.Auditable;
import com.conceptive.dcare.admin.dao.address.AddressEntity;
import com.conceptive.dcare.admin.dao.service.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NaturalIdCache
@Table(name = "provider", schema = "dcare_provider", catalog = "dcare")
public class ProviderEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "provider_id", nullable = false)
    private int providerId;

    @NaturalId
    @Basic
    @Column(name = "code", nullable = true, length = 30)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 60)
    private String name;

    @Basic
    @Column(name = "reg_num", nullable = true, length = 60)
    private String regNum;

    @Column(name="cnt_add_same_buss_")
    private Boolean contactAddressSameAsBusiness;


    @ManyToOne
    @JoinColumn(name ="bs_grp_id"  )
    private   BusinessGroupEntity businessGroup;

    @ManyToOne
    @JoinColumn(name = "prt_bs_grp_id")
    private BusinessGroupEntity parentBusinessGroup;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private ContactDetailsEntity contactDetails;
    //private ProviderConfigEntity providerConfigByProviderId;


    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "provider_id")
    private List<AddressEntity> addressEntities;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "provider_service",
            joinColumns = {
                    @JoinColumn(name = "provider_Id", referencedColumnName = "provider_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "service_id", referencedColumnName = "service_id",
                            nullable = false, updatable = false)})
    private Set<ServiceEntity> services = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderEntity that = (ProviderEntity) o;
        return providerId == that.providerId &&
                Objects.equals(name, that.name) &&
                Objects.equals(regNum, that.regNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, name, regNum);
    }
}
