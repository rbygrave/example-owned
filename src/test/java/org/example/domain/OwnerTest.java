package org.example.domain;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OwnerTest {

  @Test
  public void insert_via_server() {
    EbeanServer server = Ebean.getDefaultServer();
    Owner1 owner1 = new Owner1();
    server.save(owner1);

    OwnedForInsert owned1 = new OwnedForInsert(owner1.getId(), 1);
    //Owned owned1 = new Owned(owner1.getId(), 1);
    server.save(owned1);

    Owner1 refereshedOwner1 = server.find(Owner1.class, owner1.getId());
    assertFalse(refereshedOwner1.getOwneds().isEmpty());
    assertEquals(1, refereshedOwner1.getOwneds().size());
    Owned refreshedOwned1 = refereshedOwner1.getOwneds().get(0);

    assertEquals(owned1.getId(), refreshedOwned1.getId());
    assertNotNull(refreshedOwned1.getOwner1());
    assertEquals(owner1.getId(), refreshedOwned1.getOwner1().getId());
    assertNull(refreshedOwned1.getOwner2());


    Owner2 owner2 = new Owner2();
    server.save(owner2);

    OwnedForInsert owned2 = new OwnedForInsert(owner2.getId(), 2);
    //Owned owned2 = new Owned(owner2.getId(), 2);
    server.save(owned2);

    Owner2 refereshedOwner2 = server.find(Owner2.class, owner2.getId());
    assertFalse(refereshedOwner2.getOwneds().isEmpty());
    assertEquals(1, refereshedOwner2.getOwneds().size());
    Owned refreshedOwned2 = refereshedOwner2.getOwneds().get(0);
    assertEquals(owned2.getId(), refreshedOwned2.getId());
    assertNotNull(refreshedOwned2.getOwner2());
    assertEquals(owner2.getId(), refreshedOwned2.getOwner2().getId());
    assertNull(refreshedOwned2.getOwner1());

  }
}