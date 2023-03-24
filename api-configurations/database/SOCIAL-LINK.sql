CREATE ROLE api_user WITH ENCRYPTED PASSWORD '{INFORME A SENHA}';

CREATE DATABASE api_platform WITH OWNER api_user;

CREATE SCHEMA platform_data;

ALTER SCHEMA platform_data OWNER TO api_user;

ALTER ROLE api_user SET search_path TO platform_data;

SET SEARCH_PATH TO platform_data;