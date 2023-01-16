package klapertart.lab.toko.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kurakuraninja
 * @since 16/01/23
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity<T> {

    @CreatedBy
    @Column(updatable = false)
    protected T createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    protected Date createdDate;

    @LastModifiedBy
    @Column(insertable = false)
    protected T updatedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    protected Date updatedDate;

}
