Coordinates (Room: CoordinatesEntity)
- id : PrimaryKey
- latitude
- longitude


Address (Room: AddressEntity)
- id : PrimaryKey
- country
- region
- settlement
- street
- number
- letter
- flat
- room
- coordinatesId : ForeignKey(Coordinates,id)


Company (Room: CompanyEntity)
- id : PrimaryKey
- name
- description
- addressId : ForeignKey(Address,id)


Personal (Room: PersonalEntity)
- id : PrimaryKey
- firstName
- middleName
- lastName


Curator (Room: CuratorEntity)
- id : PrimaryKey
- nick
- position
- personalId : ForeignKey(Personal,id)


Aborigine (Room: AborigineEntity)   
- id : PrimaryKey
- nick
- position
- personalId : ForeignKey(Personal,id)


Mentee (Room: MenteeEntity)
- id : PrimaryKey
- nick
- description
- companyId : ForeignKey(Company,id)
- curatorId : ForeignKey(Curator,id)
- aborigineId : ForeignKey(Aborigine,id)
