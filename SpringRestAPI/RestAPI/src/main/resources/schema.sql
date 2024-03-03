create table cliente
(
    idCliente integer not null,
    razonSocial text not null,
    email text not null,
    primary key(idCliente)
);
create table producto
(
    idProducto integer not null,
    idCliente integer not null,
    nombre text not null,
    precio integer not null,
    primary key(idProducto),
    foreign key (idCliente) references cliente(idCliente)
);