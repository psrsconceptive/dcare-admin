package com.conceptive.dcare.admin.dao.country;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "country", schema = "dcare_master", catalog = "dcare")
@NaturalIdCache
public class CountryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "cntry_id", nullable = false)
    private int cntryId;


    @NaturalId(mutable = false)
    @Basic
    @Column(name = "alpha_2_cd", nullable = true, length = 2)
    private String alpha2Cd;

    @Basic
    @Column(name = "alpha_3_cd", nullable = true, length = 3)
    private String alpha3Cd;

    @Basic
    @Column(name = "name", nullable = true, length = 40)
    private String name;

       public int getId(){
            return cntryId;
        }
    @OneToMany(mappedBy="country" ,fetch = FetchType.LAZY)
    private Set<StateEntity> states ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return cntryId == that.cntryId &&
                Objects.equals(alpha2Cd, that.alpha2Cd) &&
                Objects.equals(alpha3Cd, that.alpha3Cd) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cntryId, alpha2Cd, alpha3Cd, name);
    }
}
