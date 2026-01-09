DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS IABot;

CREATE TABLE CatalogoTipo (
    IdCatalogoTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(10) NOT NULL UNIQUE,
    Descripcion    VARCHAR(90),
    Estado         VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME DEFAULT(datetime('now', 'localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE Catalogo (
    IdCatalogo     INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipo INTEGER NOT NULL REFERENCES CatalogoTipo (IdCatalogoTipo),
    Nombre         VARCHAR(10) NOT NULL UNIQUE,
    Descripcion    VARCHAR(90), 
    Estado         VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME DEFAULT(datetime('now', 'localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE IABot (
    IdIABot     INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre      TEXT NOT NULL UNIQUE,
    Observacion TEXT,
    FechaCrea   DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ExaBot (
    IdExaBot  INTEGER PRIMARY KEY AUTOINCREMENT,
    IdIABot   INTEGER NOT NULL,
    Nombre    TEXT NOT NULL,
    Serie     TEXT NOT NULL,
    CONSTRAINT fk_IABot FOREIGN KEY (IdIABot) REFERENCES IABot(IdIABot)
);

CREATE TABLE Persona (
    IdPersona              INTEGER PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipoPersona  INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo),
    IdCatalogoSexo         INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo),
    IdCatalogoEstadoCivil  INTEGER NOT NULL REFERENCES Catalogo (IdCatalogo),
    Cedula                 VARCHAR(10) NOT NULL UNIQUE,
    Nombre                 VARCHAR(50) NOT NULL,
    Apellido               VARCHAR(50) NOT NULL,
    Estado                 VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCreacion          DATETIME DEFAULT(datetime('now', 'localtime')),
    FechaModifica          DATETIME
);