package com.conceptive.dcare.admin.dao.provider;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.conceptive.dcare.admin.dao.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "contact_details", schema = "dcare_provider", catalog = "dcare")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDetailsEntity extends Auditable {
    @Id
    @Column(name = "contact_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int contactId;

    @Basic
    @Column(name = "f_name", nullable = true, length = 20)
    private String fName;

    @Basic
    @Column(name = "l_name", nullable = true, length = 20)
    private String lName;

    @Basic
    @Column(name = "m_name", nullable = true, length = 10)
    private String mName;

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    private String email;

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDetailsEntity that = (ContactDetailsEntity) o;
        return contactId == that.contactId &&
                Objects.equals(fName, that.fName) &&
                Objects.equals(lName, that.lName) &&
                Objects.equals(mName, that.mName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, fName, lName, mName, email, phone);
    }
}
