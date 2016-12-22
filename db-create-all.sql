create table owned (
  id                            uuid not null,
  owner_id                      uuid,
  owner_type                    integer,
  constraint pk_owned primary key (id)
);

create table ownerone (
  id                            uuid not null,
  constraint pk_ownerone primary key (id)
);

create table ownertwo (
  id                            uuid not null,
  constraint pk_ownertwo primary key (id)
);

create or replace view owned_vw as select
  id, owner_type, owner_id,
  (case when owner_type=1 THEN owner_id ELSE null END) as owner_1,
  (case when owner_type=2 THEN owner_id ELSE null END) as owner_2
from owned;

