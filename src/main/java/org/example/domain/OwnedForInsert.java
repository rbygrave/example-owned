package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "owned")
public class OwnedForInsert {
  @Id
  private UUID id;

  @Column(name = "owner_id")
  private final UUID ownerId;

  @Column(name = "owner_type")
  private final int ownerType;

  public OwnedForInsert(UUID ownerId, int ownerType) {
    this.ownerId = ownerId;
    this.ownerType = ownerType;
  }

  public UUID getId() {
    return id;
  }

//  public void setId(final UUID id) {
//    this.id = id;
//  }

  public UUID getOwnerId() {
    return ownerId;
  }

//  public void setOwnerId(final UUID ownerId) {
//    this.ownerId = ownerId;
//  }

  public int getOwnerType() {
    return ownerType;
  }

//  public void setOwnerType(final int ownerType) {
//    this.ownerType = ownerType;
//  }

}
