package com.conceptive.dcare.admin.dao.country;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NaturalIdCache
@Table(name = "state", schema = "dcare_master", catalog = "dcare",uniqueConstraints = @UniqueConstraint(columnNames={"code"}))
public class StateEntity implements Serializable {

    @Id
    @Column(name = "state_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int stateId;

    @NaturalId(mutable = false)
    @Basic
    @Column(name = "code", length = 3)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 10)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "cntry_id", referencedColumnName = "cntry_id")
    private CountryEntity country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity that = (StateEntity) o;
        return stateId == that.stateId &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateId, code, name);
    }
}
