--------------------------------------------------------
--  File creato - mercoledì-aprile-22-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence COD_LOCATION
--------------------------------------------------------

   CREATE SEQUENCE  "COD_LOCATION"  MINVALUE 1000 MAXVALUE 9999 INCREMENT BY 1 START WITH 1000 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COD_RESIDENZA
--------------------------------------------------------

   CREATE SEQUENCE  "COD_RESIDENZA"  MINVALUE 1000 MAXVALUE 9999 INCREMENT BY 1 START WITH 1000 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ALLOGGIO
--------------------------------------------------------

  CREATE TABLE "ALLOGGIO" 
   (	"COD" CHAR(7 BYTE), 
	"PREZZO_MEDIO" NUMBER(*,0), 
	"TIPO_ALLOGGIO" VARCHAR2(25 BYTE) DEFAULT 'Non Specificato'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table APPARTAMENTO
--------------------------------------------------------

  CREATE TABLE "APPARTAMENTO" 
   (	"COD" CHAR(7 BYTE), 
	"N_VANI" NUMBER(*,0), 
	"N_BAGNI" NUMBER(*,0), 
	"CUCINA" CHAR(2 BYTE) DEFAULT 'ns', 
	"VERANDA" CHAR(2 BYTE) DEFAULT 'ns'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ATTRAZIONE
--------------------------------------------------------

  CREATE TABLE "ATTRAZIONE" 
   (	"COD" CHAR(7 BYTE), 
	"PAGAMENTO" CHAR(2 BYTE) DEFAULT 'ns', 
	"TIPO_ATTRAZIONE" VARCHAR2(25 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BEB
--------------------------------------------------------

  CREATE TABLE "BEB" 
   (	"COD" CHAR(7 BYTE), 
	"N_CAMERE" NUMBER(*,0), 
	"STELLE" NUMBER(*,0), 
	"BAGNO_COMUNE" CHAR(2 BYTE) DEFAULT 'ns'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table BRACERIA
--------------------------------------------------------

  CREATE TABLE "BRACERIA" 
   (	"COD" CHAR(7 BYTE), 
	"ASPORTO" CHAR(2 BYTE) DEFAULT 'ns', 
	"ALCOLICI_ARTIGIANALI" CHAR(2 BYTE) DEFAULT 'ns', 
	"TIPO_CARNE" VARCHAR2(20 BYTE) DEFAULT 'Non Specificato'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table HOTEL
--------------------------------------------------------

  CREATE TABLE "HOTEL" 
   (	"COD" CHAR(7 BYTE), 
	"N_CAMERE" NUMBER(*,0), 
	"N_SUITE" NUMBER(*,0), 
	"STELLE" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LOCATION
--------------------------------------------------------

  CREATE TABLE "LOCATION" 
   (	"COD" CHAR(7 BYTE), 
	"NOME" VARCHAR2(25 BYTE), 
	"COD_RES" CHAR(5 BYTE), 
	"TIPO_LOCATION" VARCHAR2(25 BYTE), 
	"PARTITA_IVA" CHAR(11 BYTE) DEFAULT 'Nessuna', 
	"DESCRIZIONE" VARCHAR2(250 BYTE) DEFAULT 'Nessuna Descrizione'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PIZZERIA
--------------------------------------------------------

  CREATE TABLE "PIZZERIA" 
   (	"COD" CHAR(7 BYTE), 
	"ASPORTO" CHAR(2 BYTE) DEFAULT 'ns', 
	"TIPO_FORNO" VARCHAR2(20 BYTE) DEFAULT 'Non Specificato'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table RECENSIONE
--------------------------------------------------------

  CREATE TABLE "RECENSIONE" 
   (	"COD_LOCALE" CHAR(7 BYTE), 
	"CREATORE" VARCHAR2(15 BYTE), 
	"VOTO" NUMBER(*,0), 
	"DATA" DATE DEFAULT CURRENT_TIMESTAMP, 
	"TITOLO" VARCHAR2(25 BYTE), 
	"TESTO" VARCHAR2(250 BYTE) DEFAULT 'Non esiste testo'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table RESIDENZA
--------------------------------------------------------

  CREATE TABLE "RESIDENZA" 
   (	"VIA" VARCHAR2(25 BYTE), 
	"N_CIVICO" VARCHAR2(5 BYTE), 
	"CAP" CHAR(5 BYTE), 
	"COMUNE" VARCHAR2(25 BYTE), 
	"COD_RESIDENZA" CHAR(5 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table RISTORAZIONE
--------------------------------------------------------

  CREATE TABLE "RISTORAZIONE" 
   (	"COD" CHAR(7 BYTE), 
	"PREZZO_MEDIO" NUMBER(*,0), 
	"N_POSTI" NUMBER(*,0), 
	"TIPO_RISTORAZIONE" VARCHAR2(25 BYTE) DEFAULT 'Non Specificato'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SERVIZI_ALLOGGIO
--------------------------------------------------------

  CREATE TABLE "SERVIZI_ALLOGGIO" 
   (	"COD" CHAR(7 BYTE), 
	"WI_FI" CHAR(2 BYTE) DEFAULT 'ns', 
	"DAYUSE" CHAR(2 BYTE) DEFAULT 'ns', 
	"SPA" CHAR(2 BYTE) DEFAULT 'ns', 
	"PISCINA" CHAR(2 BYTE) DEFAULT 'ns', 
	"ARIA_CONDIZIONATA" CHAR(2 BYTE) DEFAULT 'ns', 
	"ACCESSO_DISABILI" CHAR(2 BYTE) DEFAULT 'ns', 
	"ACCESSO_ANIMALI" CHAR(2 BYTE) DEFAULT 'ns', 
	"ASCENSORE" CHAR(2 BYTE) DEFAULT 'ns', 
	"SERVIZIO_LAVANDERIA" CHAR(2 BYTE) DEFAULT 'ns', 
	"SERVIZIO_RISTORAZIONE" CHAR(2 BYTE) DEFAULT 'ns', 
	"TV_STEREO" CHAR(2 BYTE) DEFAULT 'ns', 
	"PARCHEGGIO" CHAR(2 BYTE) DEFAULT 'ns'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SUSHIBAR
--------------------------------------------------------

  CREATE TABLE "SUSHIBAR" 
   (	"COD" CHAR(7 BYTE), 
	"ALLYOUCANEAT" CHAR(2 BYTE) DEFAULT 'ns', 
	"TIPO_SUSHI" VARCHAR2(20 BYTE) DEFAULT 'Non Specificato'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table UTENTE
--------------------------------------------------------

  CREATE TABLE "UTENTE" 
   (	"USERNAME" VARCHAR2(15 BYTE), 
	"NOME" VARCHAR2(25 BYTE), 
	"COGNOME" VARCHAR2(25 BYTE), 
	"PASSWORD" VARCHAR2(15 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into ALLOGGIO
SET DEFINE OFF;
REM INSERTING into APPARTAMENTO
SET DEFINE OFF;
REM INSERTING into ATTRAZIONE
SET DEFINE OFF;
REM INSERTING into BEB
SET DEFINE OFF;
REM INSERTING into BRACERIA
SET DEFINE OFF;
REM INSERTING into HOTEL
SET DEFINE OFF;
REM INSERTING into LOCATION
SET DEFINE OFF;
REM INSERTING into PIZZERIA
SET DEFINE OFF;
REM INSERTING into RECENSIONE
SET DEFINE OFF;
REM INSERTING into RESIDENZA
SET DEFINE OFF;
REM INSERTING into RISTORAZIONE
SET DEFINE OFF;
REM INSERTING into SERVIZI_ALLOGGIO
SET DEFINE OFF;
REM INSERTING into SUSHIBAR
SET DEFINE OFF;
REM INSERTING into UTENTE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C007084
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007084" ON "UTENTE" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007094
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007094" ON "LOCATION" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007099
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007099" ON "RESIDENZA" ("COD_RESIDENZA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007102
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007102" ON "ALLOGGIO" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007107
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007107" ON "RISTORAZIONE" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_APP
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_APP" ON "APPARTAMENTO" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_ATT
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_ATT" ON "ATTRAZIONE" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_BEB
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_BEB" ON "BEB" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_BRAC
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_BRAC" ON "BRACERIA" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_HOTEL
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_HOTEL" ON "HOTEL" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_PIZZA
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_PIZZA" ON "PIZZERIA" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_SALL
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_SALL" ON "SERVIZI_ALLOGGIO" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_COD_SUSHI
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_COD_SUSHI" ON "SUSHIBAR" ("COD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index UC_RECENSIONE
--------------------------------------------------------

  CREATE UNIQUE INDEX "UC_RECENSIONE" ON "RECENSIONE" ("CREATORE", "COD_LOCALE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger CHECK_DATES
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "CHECK_DATES" 
  before insert or update on recensione
  for each row

begin

  IF(:new.data >=SYSDATE) then
    :new.data:=SYSDATE;
  END IF;

END;
/
ALTER TRIGGER "CHECK_DATES" ENABLE;
--------------------------------------------------------
--  DDL for Trigger INSERT_NEW_LOCATION
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "INSERT_NEW_LOCATION" 
  after insert on location
  for each row

begin

IF :new.tipo_location='Alloggio' THEN

	insert into alloggio(cod) values (:new.cod);
	insert into servizi_alloggio(cod) values (:new.cod);


ELSIF :new.tipo_location='Ristorante' THEN

	insert into ristorazione(cod) values (:new.cod);

ELSIF :new.tipo_location='Attrazione' THEN

	insert into attrazione(cod) values (:new.cod);


END IF;

END;
/
ALTER TRIGGER "INSERT_NEW_LOCATION" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SEQ_COD_LOCATION
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SEQ_COD_LOCATION" 
before insert on location
for each row

declare
prefisso char(3):='LOC';
codice char(4):='';

begin

codice:=COD_LOCATION.nextval;
:new.cod:=prefisso||codice;

END;
/
ALTER TRIGGER "SEQ_COD_LOCATION" ENABLE;
--------------------------------------------------------
--  DDL for Trigger SEQ_COD_RESIDENZA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SEQ_COD_RESIDENZA" 
before insert on residenza
for each row

declare
prefisso char(1):='R';
codice char(4):='';

begin

codice:=COD_RESIDENZA.nextval;
:new.cod_residenza:=prefisso||codice;

END;
/
ALTER TRIGGER "SEQ_COD_RESIDENZA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_COD_ALLOGGIO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_COD_ALLOGGIO" 
  after update of cod on alloggio
  for each row 

declare
tipo VARCHAR2(25):='';

begin 

  tipo:=:old.tipo_alloggio;

IF tipo='Hotel'  THEN

    update hotel h
    set h.cod=:new.cod
    where h.cod=:old.cod;

ELSIF tipo='BeB' THEN

    update beb bb
    set bb.cod=:new.cod
    where bb.cod=:old.cod;

ELSIF tipo='Appartamento' THEN

   update appartamento ap
   set ap.cod=:new.cod
   where ap.cod=:old.cod;

END IF;

END;
/
ALTER TRIGGER "UPDATE_COD_ALLOGGIO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_COD_LOCALE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_COD_LOCALE" 
  after update of cod on location
  for each row 

declare
tipo VARCHAR2(25):='';

begin 

  update recensione r
  set r.cod_locale=:new.cod 
  where r.cod_locale=:old.cod;

  tipo:=:old.tipo_location;

IF tipo='Attrazione'  THEN

    update attrazione a
    set a.cod=:new.cod
    where a.cod=:old.cod;

ELSIF tipo='Alloggio' THEN

    update alloggio al
    set al.cod=:new.cod
    where al.cod=:old.cod;

ELSIF tipo='Ristorazione' THEN

   update ristorazione ri
   set ri.cod=:new.cod
   where ri.cod=:old.cod;

END IF;

END;
/
ALTER TRIGGER "UPDATE_COD_LOCALE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_COD_RESIDENZA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_COD_RESIDENZA" 
  after update of cod_residenza on residenza
  for each row

begin

   update location l
   set l.cod_res=:new.cod_residenza
   where l.cod_res=:old.cod_residenza;

END;
/
ALTER TRIGGER "UPDATE_COD_RESIDENZA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_COD_RISTORAZIONE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_COD_RISTORAZIONE" 
  after update of cod on ristorazione
  for each row 

declare
tipo VARCHAR2(25):='';

begin 

  tipo:=:old.tipo_ristorazione;

IF tipo='Elenco completo'  THEN

    update braceria b
    set b.cod=:new.cod
    where b.cod=:old.cod;

    update sushibar sh
    set sh.cod=:new.cod
    where sh.cod=:old.cod;

    update pizzeria p
    set p.cod=:new.cod
    where p.cod=:old.cod;

ELSIF tipo='Braceria' THEN

    update braceria b
    set b.cod=:new.cod
    where b.cod=:old.cod;

ELSIF tipo='SushiBar' THEN

    update sushibar sh
    set sh.cod=:new.cod
    where sh.cod=:old.cod;

ELSIF tipo='Pizzeria' THEN

    update pizzeria p
    set p.cod=:new.cod
    where p.cod=:old.cod;

ELSIF tipo='Pizza e Brace' THEN

    update pizzeria p
    set p.cod=:new.cod
    where p.cod=:old.cod;

    update braceria b
    set b.cod=:new.cod
    where b.cod=:old.cod;

ELSIF tipo='Pizza e Sushi' THEN

    update pizzeria p
    set p.cod=:new.cod
    where p.cod=:old.cod;

    update sushibar sh
    set sh.cod=:new.cod
    where sh.cod=:old.cod;

ELSIF tipo='Brace e Sushi' THEN

    update braceria b
    set b.cod=:new.cod
    where b.cod=:old.cod;

    update sushibar sh
    set sh.cod=:new.cod
    where sh.cod=:old.cod;

END IF;

END;
/
ALTER TRIGGER "UPDATE_COD_RISTORAZIONE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_SEVIZI_ALLOGGIO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_SEVIZI_ALLOGGIO" 
  after update of cod on alloggio
  for each row 

begin 

   update servizi_alloggio sa
   set sa.cod=:new.cod 
   where sa.cod=:old.cod;

END;
/
ALTER TRIGGER "UPDATE_SEVIZI_ALLOGGIO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_TIPO_ALLOGGIO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_TIPO_ALLOGGIO" 
  after update of tipo_alloggio on alloggio
  for each row

begin

IF :old.tipo_alloggio='Hotel' AND :old.tipo_alloggio<>:new.tipo_alloggio THEN

	delete from hotel where hotel.cod=:old.cod;

ELSIF :old.tipo_alloggio='BeB' AND :old.tipo_alloggio<>:new.tipo_alloggio THEN

	delete from beb where beb.cod=:old.cod;

ELSIF :old.tipo_alloggio='Appartamento' AND :old.tipo_alloggio<>:new.tipo_alloggio THEN

	delete from appartamento where appartamento.cod=:old.cod;

END IF;

IF :new.tipo_alloggio='Hotel' AND  :old.tipo_alloggio<>:new.tipo_alloggio THEN

	insert into hotel(cod) values (:old.cod);

ELSIF  :new.tipo_alloggio='BeB' AND :old.tipo_alloggio<>:new.tipo_alloggio THEN

	insert into beb(cod) values (:old.cod);

ELSIF  :new.tipo_alloggio='Appartamento' AND  :old.tipo_alloggio<>:new.tipo_alloggio THEN

	insert into appartamento(cod) values (:old.cod);

END IF;

END;
/
ALTER TRIGGER "UPDATE_TIPO_ALLOGGIO" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_TIPO_LOCATION
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_TIPO_LOCATION" 
  after update of tipo_location on location
  for each row

begin

IF :old.tipo_location='Alloggio' AND :old.tipo_location<>:new.tipo_location THEN

	delete from alloggio where alloggio.cod=:old.cod;
	delete from servizi_alloggio where servizi_alloggio.cod=:old.cod;

ELSIF :old.tipo_location='Ristorazione' AND :old.tipo_location<>:new.tipo_location THEN

	delete from ristorazione where ristorazione.cod=:old.cod;

ELSIF :old.tipo_location='Attrazione' AND :old.tipo_location<>:new.tipo_location THEN

	delete from attrazione where attrazione.cod=:old.cod;

END IF;

IF :new.tipo_location='Alloggio' AND  :old.tipo_location<>:new.tipo_location THEN

	insert into alloggio(cod) values (:old.cod);
	insert into servizi_alloggio(cod) values (:old.cod);

ELSIF  :new.tipo_location='Ristorazione' AND :old.tipo_location<>:new.tipo_location THEN

	insert into ristorazione(cod) values (:old.cod);

ELSIF  :new.tipo_location='Attrazione' AND  :old.tipo_location<>:new.tipo_location THEN

	insert into attrazione(cod) values (:old.cod);

END IF;

END;
/
ALTER TRIGGER "UPDATE_TIPO_LOCATION" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_TIPO_RISTORAZIONE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_TIPO_RISTORAZIONE" 
  after update of tipo_ristorazione on ristorazione
  for each row

begin

IF :old.tipo_ristorazione='Elenco completo' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    delete from braceria where braceria.cod=:old.cod;
    delete from sushibar where sushibar.cod=:old.cod;
    delete from pizzeria where pizzeria.cod=:old.cod;

ELSIF :old.tipo_ristorazione='Braceria' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

     delete from braceria where braceria.cod=:old.cod;

ELSIF :old.tipo_ristorazione='SushiBar' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    delete from sushibar where sushibar.cod=:old.cod;

ELSIF :old.tipo_ristorazione='Pizzeria' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    delete from pizzeria where pizzeria.cod=:old.cod;

ELSIF :old.tipo_ristorazione='Pizza e Brace' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    delete from pizzeria where pizzeria.cod=:old.cod;
    delete from braceria where braceria.cod=:old.cod;

ELSIF :old.tipo_ristorazione='Pizza e Sushi' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    delete from pizzeria where pizzeria.cod=:old.cod;
    delete from sushibar where sushibar.cod=:old.cod;

ELSIF :old.tipo_ristorazione='Brace e Sushi' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    delete from braceria where braceria.cod=:old.cod;
    delete from sushibar where sushibar.cod=:old.cod;

END IF;

IF :new.tipo_ristorazione='Elenco completo' AND  :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into braceria(cod) values (:new.cod);
    insert into sushibar(cod) values (:new.cod);
    insert into pizzeria(cod) values (:new.cod);

ELSIF  :new.tipo_ristorazione='Braceria' AND :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into braceria(cod) values (:new.cod);

ELSIF  :new.tipo_ristorazione='SushiBar' AND  :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into sushibar(cod) values (:new.cod);

ELSIF  :new.tipo_ristorazione='Pizzeria' AND  :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into pizzeria(cod) values (:new.cod);

ELSIF  :new.tipo_ristorazione='Pizza e Brace' AND  :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into pizzeria(cod) values (:new.cod);
    insert into braceria(cod) values (:new.cod);

ELSIF  :new.tipo_ristorazione='Pizza e Sushi' AND  :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into pizzeria(cod) values (:new.cod);
    insert into sushibar(cod) values (:new.cod);

ELSIF  :new.tipo_ristorazione='Brace e Sushi' AND  :old.tipo_ristorazione<>:new.tipo_ristorazione THEN

    insert into braceria(cod) values (:new.cod);
    insert into sushibar(cod) values (:new.cod);

END IF;

END;
/
ALTER TRIGGER "UPDATE_TIPO_RISTORAZIONE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UPDATE_UTENTE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "UPDATE_UTENTE" 
  after update of username on utente
  for each row 

begin 

   update recensione r
   set r.creatore=:new.username
   where r.creatore=:old.username;

END;
/
ALTER TRIGGER "UPDATE_UTENTE" ENABLE;
--------------------------------------------------------
--  DDL for Procedure GETMEDIAVOTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "GETMEDIAVOTO" (cod in VARCHAR2, media out float) as

BEGIN

select AVG(voto) into media from recensione where recensione.cod_locale=cod;

END;

/
--------------------------------------------------------
--  Constraints for Table ALLOGGIO
--------------------------------------------------------

  ALTER TABLE "ALLOGGIO" ADD PRIMARY KEY ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ALLOGGIO" ADD CHECK (tipo_alloggio='Hotel' OR  tipo_alloggio='BeB' OR  tipo_alloggio='Appartamento' OR tipo_alloggio='Non Specificato') ENABLE;
  ALTER TABLE "ALLOGGIO" ADD CHECK (prezzo_medio>=0) ENABLE;
--------------------------------------------------------
--  Constraints for Table APPARTAMENTO
--------------------------------------------------------

  ALTER TABLE "APPARTAMENTO" ADD CONSTRAINT "UC_COD_APP" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "APPARTAMENTO" ADD CHECK (veranda='si' OR veranda='no' OR veranda='ns') ENABLE;
  ALTER TABLE "APPARTAMENTO" ADD CHECK (cucina='si' OR cucina='no' OR cucina='ns') ENABLE;
  ALTER TABLE "APPARTAMENTO" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ATTRAZIONE
--------------------------------------------------------

  ALTER TABLE "ATTRAZIONE" ADD CONSTRAINT "TIPO_ATTRAZIONE" CHECK (tipo_attrazione='Chiesa' OR tipo_attrazione='Museo' OR tipo_attrazione='Parco' OR tipo_attrazione='Monumento' OR tipo_attrazione='Parco Giochi' OR tipo_attrazione='Centro Sportivo' OR tipo_attrazione='Teatro' OR tipo_attrazione='Cinema' OR tipo_attrazione='Acquario' OR tipo_attrazione='Zona Balneare' OR tipo_attrazione='Zoo') ENABLE;
  ALTER TABLE "ATTRAZIONE" ADD CONSTRAINT "UC_COD_ATT" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ATTRAZIONE" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BEB
--------------------------------------------------------

  ALTER TABLE "BEB" ADD CONSTRAINT "UC_COD_BEB" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BEB" ADD CHECK (bagno_comune='si' OR bagno_comune='no' OR bagno_comune='ns') ENABLE;
  ALTER TABLE "BEB" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BRACERIA
--------------------------------------------------------

  ALTER TABLE "BRACERIA" ADD CONSTRAINT "UC_COD_BRAC" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BRACERIA" ADD CHECK (tipo_carne='Entrambe' OR tipo_carne='Importata' OR tipo_carne='Italiana' OR tipo_carne='Non Specificato') ENABLE;
  ALTER TABLE "BRACERIA" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table HOTEL
--------------------------------------------------------

  ALTER TABLE "HOTEL" ADD CONSTRAINT "UC_COD_HOTEL" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "HOTEL" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOCATION
--------------------------------------------------------

  ALTER TABLE "LOCATION" ADD PRIMARY KEY ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LOCATION" ADD CHECK (tipo_location='Alloggio' OR tipo_location='Attrazione' OR tipo_location='Ristorante') ENABLE;
  ALTER TABLE "LOCATION" MODIFY ("TIPO_LOCATION" NOT NULL ENABLE);
  ALTER TABLE "LOCATION" MODIFY ("COD_RES" NOT NULL ENABLE);
  ALTER TABLE "LOCATION" MODIFY ("NOME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PIZZERIA
--------------------------------------------------------

  ALTER TABLE "PIZZERIA" ADD CONSTRAINT "UC_COD_PIZZA" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PIZZERIA" ADD CHECK (tipo_forno='Entrambi' OR tipo_forno='A legna' OR tipo_forno='Elettrico' OR tipo_forno='Non Specificato') ENABLE;
  ALTER TABLE "PIZZERIA" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RECENSIONE
--------------------------------------------------------

  ALTER TABLE "RECENSIONE" ADD CONSTRAINT "UC_RECENSIONE" UNIQUE ("CREATORE", "COD_LOCALE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "RECENSIONE" ADD CHECK (voto between 1 AND 5) ENABLE;
  ALTER TABLE "RECENSIONE" MODIFY ("TITOLO" NOT NULL ENABLE);
  ALTER TABLE "RECENSIONE" MODIFY ("VOTO" NOT NULL ENABLE);
  ALTER TABLE "RECENSIONE" MODIFY ("CREATORE" NOT NULL ENABLE);
  ALTER TABLE "RECENSIONE" MODIFY ("COD_LOCALE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESIDENZA
--------------------------------------------------------

  ALTER TABLE "RESIDENZA" ADD PRIMARY KEY ("COD_RESIDENZA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "RESIDENZA" MODIFY ("COMUNE" NOT NULL ENABLE);
  ALTER TABLE "RESIDENZA" MODIFY ("CAP" NOT NULL ENABLE);
  ALTER TABLE "RESIDENZA" MODIFY ("N_CIVICO" NOT NULL ENABLE);
  ALTER TABLE "RESIDENZA" MODIFY ("VIA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RISTORAZIONE
--------------------------------------------------------

  ALTER TABLE "RISTORAZIONE" ADD PRIMARY KEY ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "RISTORAZIONE" ADD CHECK (tipo_ristorazione='Elenco completo' OR tipo_ristorazione='Pizzeria' OR tipo_ristorazione='Braceria' OR tipo_ristorazione='SushiBar' OR tipo_ristorazione='Pizza e Brace' OR tipo_ristorazione='Pizza e Sushi' OR tipo_ristorazione='Brace e Sushi' OR tipo_ristorazione='Non Specificato') ENABLE;
  ALTER TABLE "RISTORAZIONE" ADD CHECK (prezzo_medio>=0) ENABLE;
--------------------------------------------------------
--  Constraints for Table SERVIZI_ALLOGGIO
--------------------------------------------------------

  ALTER TABLE "SERVIZI_ALLOGGIO" ADD CONSTRAINT "UC_COD_SALL" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SERVIZI_ALLOGGIO" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SUSHIBAR
--------------------------------------------------------

  ALTER TABLE "SUSHIBAR" ADD CONSTRAINT "UC_COD_SUSHI" UNIQUE ("COD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SUSHIBAR" ADD CHECK (tipo_sushi='Fusion' OR tipo_sushi='Giapponese' OR tipo_sushi='Cinese' OR tipo_sushi='Non Specificato') ENABLE;
  ALTER TABLE "SUSHIBAR" MODIFY ("COD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table UTENTE
--------------------------------------------------------

  ALTER TABLE "UTENTE" ADD PRIMARY KEY ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "UTENTE" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "UTENTE" MODIFY ("COGNOME" NOT NULL ENABLE);
  ALTER TABLE "UTENTE" MODIFY ("NOME" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ALLOGGIO
--------------------------------------------------------

  ALTER TABLE "ALLOGGIO" ADD CONSTRAINT "FK_ALLOGGIO" FOREIGN KEY ("COD")
	  REFERENCES "LOCATION" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table APPARTAMENTO
--------------------------------------------------------

  ALTER TABLE "APPARTAMENTO" ADD CONSTRAINT "FK_APPARTAMENTO" FOREIGN KEY ("COD")
	  REFERENCES "ALLOGGIO" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ATTRAZIONE
--------------------------------------------------------

  ALTER TABLE "ATTRAZIONE" ADD CONSTRAINT "FK_ATTRAZIONE" FOREIGN KEY ("COD")
	  REFERENCES "LOCATION" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BEB
--------------------------------------------------------

  ALTER TABLE "BEB" ADD CONSTRAINT "FK_BEB" FOREIGN KEY ("COD")
	  REFERENCES "ALLOGGIO" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BRACERIA
--------------------------------------------------------

  ALTER TABLE "BRACERIA" ADD CONSTRAINT "FK_BRACERIA" FOREIGN KEY ("COD")
	  REFERENCES "RISTORAZIONE" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table HOTEL
--------------------------------------------------------

  ALTER TABLE "HOTEL" ADD CONSTRAINT "FK_HOTEL" FOREIGN KEY ("COD")
	  REFERENCES "ALLOGGIO" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOCATION
--------------------------------------------------------

  ALTER TABLE "LOCATION" ADD CONSTRAINT "FK_RESIDENZA_COD_RESIDENZA" FOREIGN KEY ("COD_RES")
	  REFERENCES "RESIDENZA" ("COD_RESIDENZA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PIZZERIA
--------------------------------------------------------

  ALTER TABLE "PIZZERIA" ADD CONSTRAINT "FK_PIZZERIA" FOREIGN KEY ("COD")
	  REFERENCES "RISTORAZIONE" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECENSIONE
--------------------------------------------------------

  ALTER TABLE "RECENSIONE" ADD CONSTRAINT "FK_RECENSIONE_COD_LOCALE" FOREIGN KEY ("COD_LOCALE")
	  REFERENCES "LOCATION" ("COD") ON DELETE CASCADE ENABLE;
  ALTER TABLE "RECENSIONE" ADD CONSTRAINT "FK_RECENSIONE_CREATORE" FOREIGN KEY ("CREATORE")
	  REFERENCES "UTENTE" ("USERNAME") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RISTORAZIONE
--------------------------------------------------------

  ALTER TABLE "RISTORAZIONE" ADD CONSTRAINT "FK_RISTORAZIONE" FOREIGN KEY ("COD")
	  REFERENCES "LOCATION" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SERVIZI_ALLOGGIO
--------------------------------------------------------

  ALTER TABLE "SERVIZI_ALLOGGIO" ADD CONSTRAINT "FK_SERVIZI_ALLOGGIO" FOREIGN KEY ("COD")
	  REFERENCES "ALLOGGIO" ("COD") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SUSHIBAR
--------------------------------------------------------

  ALTER TABLE "SUSHIBAR" ADD CONSTRAINT "FK_SUSHIBAR" FOREIGN KEY ("COD")
	  REFERENCES "RISTORAZIONE" ("COD") ON DELETE CASCADE ENABLE;
