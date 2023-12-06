create table projetos(
nomeProjeto varchar(40) not null check(nomeProjeto <> ' '),
	escopo varchar(200) not null check(length(escopo) <= 200),
	qtdeStakeholders integer not null check(qtdeStakeholders > 0),
	custoOrcado numeric not null check(custoOrcado > 0),
	custoAprovado numeric not null check(custoOrcado > 0 and custoAprovado < custoOrcado),
	primary key(nomeProjeto)
);

create table stakeholders(
codStakeholder serial not null,
	nomeStakeholder varchar(50) not null check(nomeStakeholder <> ' '),
	primary key(codStakeholder)
);

create table projeto_stakeholders(
codStakeholder integer,
	nomeProjeto varchar(40),
	foreign key(codStakeholder) references stakeholders(codStakeholder),
	foreign key(nomeProjeto) references projetos(nomeProjeto)
);

create table integrantes(
nomeIntegrante varchar(40) not null check(nomeIntegrante <> ' '),
	cargo varchar(40) check(cargo <> ' '),
	empresaTerceira varchar(40) check(empresaTerceira <> ' '),
	tipoEquipe char not null check(tipoEquipe <> ' '),
	reponsavelPorEtapa char not null check(reponsavelPorEtapa <> ' '),
	etapa integer,
	dataInicio date,
	dataFim date,
	primary key(nomeIntegrante)
);

create table equipes(
codEquipe serial not null,
	responsavelGeral varchar(40) not null check(responsavelGeral <> ' '),
	primary key(codEquipe)
);

create table equipe_integrante(
	codEquipe integer not null,
	nomeIntegrante varchar(40) not null,
	foreign key(codEquipe) references equipes(codEquipe),
	foreign key(nomeIntegrante) references integrantes(nomeIntegrante)
);

create table equipe_projeto(
codEquipe integer not null,
	nomeProjeto varchar(40) not null check(nomeProjeto <> ' '),
	foreign key(codEquipe) references equipes(codEquipe),
	foreign key(nomeProjeto) references projetos(nomeProjeto)	
);

create table dadosGerais(
cnpj varchar(14) not null check(length(cnpj) = 14),
	modeloGestao  varchar(25) not null check(modeloGestao <> ' '),
	nomeProjeto varchar(40) not null check(nomeProjeto <> ' '),
	atividadeTecnologia varchar(300) not null check(atividadeTecnologia <> ' '),
	primary key(cnpj),
	foreign key(nomeProjeto) references projetos(nomeProjeto)
);

create table cronograma(
etapa integer not null check(etapa > 0),
	nomeEtapa varchar(50) not null check(nomeEtapa <> ' '),
	descEtapa varchar(120) not null check(descEtapa <> ' '),
	dataInicio date not null,
	dataFinal date not null,
	nomeProjeto varchar(40) not null check(nomeProjeto <> ' '),
	foreign key(nomeProjeto) references projetos(nomeProjeto)
);

create table ajusteCronograma(
etapaAlterada integer not null check(etapaAlterada > 0),
	motivoAlteracao varchar(100) not null check(length(motivoAlteracao) > 0 and motivoAlteracao <> ' '),
	impactoAlteracao varchar(100) not null check( motivoAlteracao <> ' '),
	riscoAlteracao varchar(100) not null check( riscoAlteracao <> ' '),
	novaDataFim date not null,
	nomeProjeto varchar(40) not null check(nomeProjeto <> ' '),
	foreign key(nomeProjeto) references projetos(nomeProjeto)
);

create table medicao(
etapaCompleta integer not null check(etapaCompleta > 0),
	valorTotal numeric not null check(valorTotal > 0),
	valorPago numeric not null check(valorPago > 0),
	nomeProjeto varchar(40) not null check(nomeProjeto <> ' '),
	foreign key(nomeProjeto) references projetos(nomeProjeto)
);

select * from equipes;

select * from projetos;

select * from stakeholders;

select * from projeto_stakeholders;

select * from dadosGerais;

select * from medicao;

select * from cronograma;

select * from ajusteCronograma;

select * from integrantes;

select * from equipes;

select * from equipe_projeto;

select * from equipe_integrante;



