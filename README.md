Base de datos en postgrest

CREATE DATABASE reservas;

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE sala (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(100) NOT NULL,
    capacidad INTEGER NOT NULL
);

CREATE TABLE reserva (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    sala_id INTEGER NOT NULL REFERENCES sala(id),
    fecha_inicio TIMESTAMP NOT NULL,
    fecha_fin TIMESTAMP NOT NULL
);

INSERT INTO usuario (nombre, email) VALUES
  ('Carlos Pérez', 'carlos.perez@empresa.com'),
  ('María López', 'maria.lopez@empresa.com');

INSERT INTO sala (nombre, ubicacion, capacidad) VALUES
  ('Sala Azul', 'Edificio A', 10),
  ('Sala Roja', 'Edificio B', 20);

INSERT INTO reserva (usuario_id, sala_id, fecha_inicio, fecha_fin) VALUES
  (1, 1, '2025-05-25 09:00:00', '2025-05-25 10:00:00'),
  (2, 2, '2025-05-25 11:00:00', '2025-05-25 12:30:00');
