set client_encoding = 'UTF8';


create table if not exists fuma_customer (
    -- 企業コード
    id varchar(36) primary key,
    -- 漢字商号
    company_name varchar(100) not null unique,
    -- 業種1
    main_industry varchar(100) not null,
    -- 業種2
    sub_industry varchar(100) not null,
    -- 住所
    address varchar(100) not null,
    -- 代表者
    representative varchar(24) not null,
    -- 資本金(千円)
    foundation numeric,
    -- 従業員数
    number_of_employees numeric,
    -- 更新日時
    update_date timestamp
);





