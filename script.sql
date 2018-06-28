# 123
$2y$12$NhYl9bSbdWPuJ3b8gR/uW.5YfsSo0hmu.qWOISh5Nn.wHb.9qcuny
# admin
$2y$12$IRDvLttrHD2Fqzk18l6arutUunLP4/wihp5DM/ES9dFYFLQCDLwju


INSERT INTO usuario (usuario_id, nome, email, senha, ativo)
VALUES(1, 'robson', 'robson@gmail.com', '$2y$12$NhYl9bSbdWPuJ3b8gR/uW.5YfsSo0hmu.qWOISh5Nn.wHb.9qcuny', 1);

INSERT INTO usuario (usuario_id, nome, email, senha, ativo)
VALUES(2, 'julio', 'robson@gmail.com', '$2y$12$NhYl9bSbdWPuJ3b8gR/uW.5YfsSo0hmu.qWOISh5Nn.wHb.9qcuny', 2);

# Papeis
INSERT INTO papel (papel_id, papel)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO papel (papel_id, papel)
VALUES (2, 'ROLE_USER');

# Autenticação
INSERT INTO usuario_papel (usuario_id, papel_id)
VALUES (1, 1);

INSERT INTO usuario_papel (usuario_id, papel_id)
VALUES (1, 2);
