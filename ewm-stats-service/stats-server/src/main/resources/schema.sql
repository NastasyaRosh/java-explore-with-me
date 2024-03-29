CREATE TABLE IF NOT EXISTS APPS (
                                    ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL ,
                                    APP VARCHAR(1000) NOT NULL UNIQUE ,
                                    CONSTRAINT PK_APPS PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS STAT_STORAGE (
                                            ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                                            APP_ID BIGINT NOT NULL,
                                            URI VARCHAR(1000) NOT NULL,
                                            IP VARCHAR(15) NOT NULL,
                                            TIMESTAMP TIMESTAMP WITHOUT TIME ZONE,
                                            CONSTRAINT PK_SS PRIMARY KEY (ID),
                                            CONSTRAINT FK_SS_APPS FOREIGN KEY(APP_ID) REFERENCES APPS(ID)
);