set client_encoding = 'UTF8';

create table if not exists customer (
    user_id varchar(36) primary key,
    account_name varchar(100) not null,
    login_password varchar(255) not null, 
    last_login timestamp not null default current_timestamp
);

-- 企業コード
-- company_code
-- 漢字商号
-- kanji_tradeName
-- 検索用カナ商号
-- kana_trade_name_for_search
-- 企業電話番号
-- company_phone_number
-- 代表者漢字氏名
-- representative_name_in_kanji
-- 代表者カナ氏名
-- representatives_kana_name
-- ＴＤＢ産業分類名主業
-- tdbIndustry_classification_name_main_business
-- ＴＤＢ産業分類名従業
-- ttdb_industry_classification_name_employee
-- 郵便番号
-- postal_code_number
-- 企業所在地バーコード番号
-- company_address_barcode_number
-- 帝国住所コード
-- imperial_address_code
-- 漢字所在地
-- kanji_address
-- 資本金(千円)
-- capitalthousand_yen
-- 従業員数
-- number_of_employees
-- 創業年
-- year_of_establishment
-- 創業月
-- month_of_establishment
-- 設立年
-- year_established
-- 設立月
-- month_of_establishment
-- 決算年
-- fiscal_year
-- 決算月
-- closing_month
-- 売上高(百万円)	
-- net_sales_millions_of_yen
