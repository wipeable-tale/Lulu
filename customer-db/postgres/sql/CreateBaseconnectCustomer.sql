set client_encoding = 'UTF8';

create table if not exists baseconnect_customer (
    -- 企業コード
    id varchar(36) primary key,
    -- 漢字商号
    company_name varchar(100) not null unique,
    -- 業種
    category varchar(24) not null,
    -- 設立
    establish varchar(16) not null,
    -- 資本金(千円)
    foundation  varchar(16) not null,
    -- 売上高
    benefit varchar(16) not null,
    -- 従業員数
    number_of_employees numeric,
    -- 新卒採用数
    new_hired varchar(16) not null,
    -- 事業所数
    offices_number varchar(16) not null,
    -- サイト
    site varchar(256) not null,
    -- 住所
    address varchar(256) not null,
    -- 更新日時
    update_date timestamp
);