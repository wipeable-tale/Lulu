set client_encoding = 'UTF8';



create table if not exists customer (
    -- 企業コード
    company_code varchar(10) primary key,
    -- 漢字商号
    kanji_tradeName varchar(100) not null,
    -- 検索用カナ商号
    kana_trade_name_for_search varchar(100) not null,
    -- 企業電話番号
    company_phone_number varchar(12) not null,
    -- 代表者漢字氏名
    representative_name_in_kanji varchar(15) not null,
    -- 代表者カナ氏名
    representatives_kana_name varchar(30) not null,
    -- ＴＤＢ産業分類名主業
    tdbIndustry_classification_name_main_business varchar(20),
    -- ＴＤＢ産業分類名従業
    ttdb_industry_classification_name_employee varchar(20),
    -- 郵便番号
    postal_code_number varchar(7) not null,
    -- 企業所在地バーコード番号
    company_address_barcode_number  varchar(30) not null,
    -- 帝国住所コード
    imperial_address_code varchar(10) not null,
    -- 漢字所在地
    kanji_address varchar(100) not null,
    -- 資本金(千円)
     capitalthousand_yen numeric,
    -- 従業員数
    number_of_employees numeric,
    -- 創業年
    founding_year varchar(4) not null,
    -- 創業月
    founding_month  varchar(2) not null,
    -- 設立年
    year_established varchar(4) not null,
    -- 設立月
    month_of_establishment varchar(2) not null,
    -- 決算年
    fiscal_year varchar(4) not null,
    -- 決算月
    closing_month varchar(2) not null,
    -- 売上高(百万円)	
    net_sales_millions_of_yen numeric,
    -- 更新日時
    update_date timestamp
);
