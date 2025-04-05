CREATE TABLE tenants
(
    id    BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) UNIQUE,
    hash  VARCHAR(255)
);

CREATE TABLE tenant_members
(
    user_id   BIGINT NOT NULL,
    tenant_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, tenant_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (id)
);
