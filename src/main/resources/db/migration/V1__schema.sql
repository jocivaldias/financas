drop table if exists ativo;
drop table if exists carteira;
drop table if exists ativo;

create table ativo (
    codigo varchar(10) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    tipo varchar(100) not null,
    ultimo_valor money not null,
    data_ultima_atualizacao timestamp
);

create table carteira (
    id_carteira UUID primary key not null,
    rendimento float not null,
    data_ultimo_rendimento timestamp
);

create table carteira_ativo (
    codigo varchar(10) not null,
    id_carteira UUID not null,
    preco_medio money not null,
    quantidade integer not null,
    constraint carteira_ativo_pk primary key (codigo, id_carteira),
    constraint carteira_ativo_codigo_ativo_fk foreign key (codigo) references ativo(codigo),
    constraint carteira_ativo_id_carteira_fk foreign key (id_carteira) references carteira(id_carteira)
);

create table transacao (
    id_transacao UUID primary key not null,
    codigo varchar(10) not null,
    id_carteira UUID not null,
    tipo_transacao varchar(100) not null,
    quantidade integer not null,
    valor money not null,
    data_transacao timestamp  not null,
    constraint transacao_codigo_ativo_fk foreign key (codigo) references ativo(codigo),
    constraint transacao_id_carteira_fk foreign key (id_carteira) references carteira(id_carteira)
);