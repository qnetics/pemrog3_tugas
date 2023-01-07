CREATE TABLE data_anggota (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nama_anggota VARCHAR(32) NOT NULL,
    email VARCHAR(64) NOT NULL,
    password VARCHAR(19) NOT NULL
);

INSERT INTO data_anggota (nama_anggota, email, password)
    VALUES ("al-fariqy", "test@mail.com", "test");
INSERT INTO data_anggota (nama_anggota, email, password)
    VALUES ("raihan", "test1@mail.com", "test1");
INSERT INTO data_anggota (nama_anggota, email, password)
    VALUES ("azhwar", "test2@gmail.com", "test2");

CREATE TABLE data_buku (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nama_buku VARCHAR(500) NOT NULL,
    pengarang VARCHAR(500) NOT NULL
);

INSERT INTO data_buku (nama_buku, pengarang)
    VALUES ("clean code", "uncle bob");
INSERT INTO data_buku (nama_buku, pengarang)
    VALUES ("refactoring", "uncle bob");
INSERT INTO data_buku (nama_buku, pengarang)
    VALUES ("clean architecture", "uncle bob");

CREATE TABLE data_peminjam (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_anggota INTEGER NOT NULL,
    id_buku INTEGER NOT NULL,
    jumlah_buku INTEGER NOT NULL
        CHECK(jumlah_buku >= 1),

    CONSTRAINT ANGGOTA_FOREIGN_KEY
    FOREIGN KEY (id_anggota)
    REFERENCES data_anggota(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT BUKU_FOREIGN_KEY
    FOREIGN KEY (id_buku)
    REFERENCES data_buku(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


SELECT
    peminjam.id,
    peminjam.id_anggota,
    anggota.nama_anggota,
    peminjam.id_buku,
    buku.nama_buku,
    peminjam.jumlah_buku
FROM data_peminjam peminjam
INNER JOIN
    data_anggota anggota
        ON peminjam.id_anggota = anggota.id
INNER JOIN
    data_buku buku
        ON peminjam.id_buku = buku.id;
