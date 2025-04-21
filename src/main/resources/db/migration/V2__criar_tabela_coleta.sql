CREATE SEQUENCE SEQ_COLETA
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_COLETA (
    id_coleta       NUMBER(5) PRIMARY KEY,
    data_hora       DATE,
    rota            VARCHAR2(50),
    status          VARCHAR2(20),
);
