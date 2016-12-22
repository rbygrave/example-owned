package org.example.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.ebean.annotation.Formula;
import io.ebean.annotation.Where;

@Entity
@Table(name="owned_vw")
public class Owned {
    @Id
    private UUID id;
    @Column(name = "owner_id")
    private UUID ownerId;
    @Column(name = "owner_type")
    private int ownerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_1", insertable = false, updatable = false, referencedColumnName = "id")
//    @JoinColumns(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), value = {
//	    @JoinColumn(insertable = false, updatable = false, name = "owner_id", referencedColumnName = "id"),
//    })
//    @Where(clause = "owner_type = 1")
    private Owner1 owner1;

    @Formula(select = "CASE WHEN ${ta}.owner_type=2 THEN ${ta}.owner_id ELSE null END")
    UUID o2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_2", insertable = false, updatable = false, referencedColumnName = "id")
//    @JoinColumns(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), value = {
//	    @JoinColumn(insertable = false, updatable = false, name = "owner_id", referencedColumnName = "id"),
//    })
//    @Where(clause = "owner_type = 2")
    private Owner2 owner2;

    public Owned() {}

    public Owned(UUID ownerId, int ownerType) {
	setOwnerId(ownerId);
	setOwnerType(ownerType);
    }

    public UUID getId() {
	return id;
    }

    public void setId(final UUID id) {
	this.id = id;
    }

    public UUID getOwnerId() {
	return ownerId;
    }

    public void setOwnerId(final UUID ownerId) {
	this.ownerId = ownerId;
    }

    public int getOwnerType() {
	return ownerType;
    }

    public void setOwnerType(final int ownerType) {
	this.ownerType = ownerType;
    }

    public Owner1 getOwner1() {
	return owner1;
    }

    public Owner2 getOwner2() {
	return owner2;
    }

    public void setOwner1(final Owner1 owner1) {
	this.owner1 = owner1;
    }

    public void setOwner2(final Owner2 owner2) {
	this.owner2 = owner2;
    }
}
