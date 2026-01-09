INSERT INTO CatalogoTipo (Nombre, Descripcion) VALUES 
('Tipo Persona' , 'tipos sol, meca, ...'),
('Sexo'         , 'mas, feme, ...'),
('Estado Civil' , 'sol, viu, cad, ...'),
('Raza'         , 'Negro, blanco...');

INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES 
(1, 'Soldado', 'tipos de perso del ejercito'),      -- ID 1
(1, 'Mecanico', 'tipos de perso del ejercito'),     -- ID 2
(1, 'Experto Ing.', 'tipos de perso del ejercito'), -- ID 3
(1, 'Experto Esp.', 'tipos de perso del ejercito'), -- ID 4

(2, 'Masculino', 'tipos de sexualida'),             -- ID 5
(2, 'Femenino', 'tipos de sexualida'),              -- ID 6
(2, 'Hibrido', 'tipos de sexualida'),               -- ID 7
(2, 'Asexual', 'tipos de sexualida'),               -- ID 8

(3, 'Soltero', 'tipos de estado civil Ecu.'),       -- ID 9
(3, 'Casado', 'tipos de estado civil Ecu.'),        -- ID 10
(3, 'Divorciado', 'tipos de estado civil Ecu.'),    -- ID 11
(3, 'Viudo', 'tipos de estado civil Ecu.'),         -- ID 12

(4, 'Blanco', 'Tipo de etnia'),                     -- ID 13
(4, 'Negro', 'Tipo de etnia'),                      -- ID 14
(4, 'Mestizo', 'Tipo de etnia'),                    -- ID 15
(4, 'Indigena', 'Tipo de etnia');                   -- ID 16

INSERT INTO IABot (Nombre, Observacion) VALUES ("IA-RUSO", "Inteligencia artificial");
INSERT INTO ExaBot (IdIABot, Nombre, Serie) VALUES 
(1, "exabot1", "Serie E1"),
(1, "exabot2", "Serie E2");

INSERT INTO Persona (IdCatalogoTipoPersona, IdCatalogoSexo, IdCatalogoEstadoCivil, Cedula, Nombre, Apellido) VALUES 
(1, 5, 9,  '11111', 'pepe',  'putin'),
(2, 5, 10, '22222', 'juan',  'putin'),
(3, 5, 11, '33333', 'pedro', 'putin'),
(4, 5, 12, '44444', 'pablo', 'putin'),
(1, 6, 9,  '01010', 'ana',   'putin'),
(2, 6, 10, '02020', 'pepa',  'putin');