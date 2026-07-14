create database pet_boarding_schema_final;
use pet_boarding_schema_final;

CREATE TABLE owner (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(255)

);
Alter table owner drop column had_Account;
Alter table owner add column had_Account BOOLEAN default 0;
CREATE TABLE account (
	id INT auto_increment primary key,
    password varchar(255),
    owner_id int,
    constraint fk_account_owner foreign key (owner_id) references owner(id) ON DELETE SET NULL ON UPDATE CASCADE
);
CREATE TABLE pet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age DECIMAL(4,1) NOT NULL, -- Dùng DECIMAL phù hợp với kiểu Double (ví dụ: 2.5 tuổi)
    owner_id INT,
    type VARCHAR(50) NOT NULL, -- Lưu giá trị Enum Types (ví dụ: 'DOG', 'CAT')
    weight decimal,
    species varchar(225),
    status varchar(50),
    CONSTRAINT fk_pet_owner FOREIGN KEY (owner_id) 
        REFERENCES owner(id) ON DELETE SET NULL ON UPDATE CASCADE
);

Alter table pet drop column note;
Alter table pet add column status varchar(50);

CREATE TABLE boarding_record (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pet_id INT NOT NULL,
    check_in_date DATETIME NOT NULL,        
    expected_return_date DATETIME NOT NULL,  
    actual_return_date DATETIME,             
    price_per_day DECIMAL(12,2) NOT NULL,    
    base_fee DECIMAL(12,2) NOT NULL,
    late_fee DECIMAL(12,2) DEFAULT 0.00,
    total_fee DECIMAL(12,2) NOT NULL,
    status VARCHAR(50) NOT NULL,             
    CONSTRAINT fk_record_pet FOREIGN KEY (pet_id) 
        REFERENCES pet(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE care_note (
    id INT AUTO_INCREMENT PRIMARY KEY,
    boarding_record_id INT NOT NULL,
    note TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
    CONSTRAINT fk_note_record FOREIGN KEY (boarding_record_id) 
        REFERENCES boarding_record(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- ====================================================================
-- 1. DỮ LIỆU MẪU CHO BẢNG OWNER
-- ====================================================================

INSERT INTO owner (name, phone_number, email, address) VALUES
('Nguyễn Văn A', '0901234567', 'nguyenvana@gmail.com', 'abc district'),
('Trần Thị B', '0987654321', 'tranthib@gmail.com','abc district'),
('Lê Hoàng Gia Bảo', '0912345678', 'bao.lhg@gmail.com','abc district');
-- ====================================================================
-- 2. DỮ LIỆU MẪU CHO BẢNG PET
-- (owner_id = 1 thuộc về Nguyễn Văn A, owner_id = 2 thuộc về Trần Thị B)
-- ====================================================================
INSERT INTO pet (name, age, owner_id, type, weight, species, status ) VALUES
('Cậu Vàng', 2.5, 5, 'DOG', 4.2, "chó phóc","BOARDING"),
('Miu Miu', 1.0, 5, 'CAT',3.2, "mèo ú lông ngắn","BOARDING" ),
('Ngáo', 3.0, 6, 'DOG', 5.0, "chó husky","RETURNED"),
('AKA', 2.0, 7, 'DOG', 1.5, "chó chihuahua","RETURNED");

-- ====================================================================
-- 3. DỮ LIỆU MẪU CHO BẢNG BOARDING_RECORD
-- (Ghi lại lịch sử gửi thú cưng của Cậu Vàng (pet_id=1) và Ngáo (pet_id=3))
-- ====================================================================
INSERT INTO boarding_record 
(pet_id, check_in_date, expected_return_date, actual_return_date, price_per_day, base_fee, late_fee, total_fee, status) 
VALUES
-- Lượt gửi 1: Đã hoàn thành, trả đúng hạn (Cậu Vàng gửi 3 ngày)
(1, '2026-07-01 08:00:00', '2026-07-04 17:00:00', '2026-07-04 16:30:00', 100000.00, 50000.00, 0.00, 350000.00, 'COMPLETED'),

-- Lượt gửi 2: Bị trễ hạn nên phát sinh late_fee (Ngáo dự kiến gửi 2 ngày nhưng 3 ngày mới lấy)
(3, '2026-07-05 09:00:00', '2026-07-07 09:00:00', '2026-07-08 09:00:00', 150000.00, 50000.00, 150000.00, 500000.00, 'COMPLETED'),

-- Lượt gửi 3: Thú cưng đang ở cửa hàng (Miu Miu), chưa có ngày trả thực tế (actual_return_date = NULL)
(2, '2026-07-12 14:00:00', '2026-07-15 14:00:00', NULL, 120000.00, 50000.00, 0.00, 410000.00, 'CONFIRMED');

-- ====================================================================
-- 4. DỮ LIỆU MẪU CHO BẢNG CARE_NOTE
-- (Ghi chú quá trình chăm sóc cho lượt gửi đang diễn ra hoặc đã qua)
-- ====================================================================
INSERT INTO care_note (boarding_record_id, note, created_at) VALUES
-- Ghi chú cho lượt gửi của Cậu Vàng (record_id = 1)
(1, 'Thú cưng ăn ngoan, không quấy khóc trong ngày đầu tiên.', '2026-07-01 20:00:00'),
(1, 'Đã được tắm rửa sạch sẽ và cắt móng.', '2026-07-03 15:00:00'),

-- Ghi chú cho lượt gửi hiện tại của Miu Miu (record_id = 3)
(3, 'Mèo hơi bỏ ăn bữa chiều do lạ chỗ, đã cho uống thêm sữa.', '2026-07-12 19:30:00');