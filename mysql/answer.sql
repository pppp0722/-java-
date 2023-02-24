-- SUM,MAX,MIN/프로그래머스/Level2/최솟값 구하기
select min(datetime) as '시간'
from animal_ins;

-- SUM,MAX,MIN/프로그래머스/Level2/중복 제거하기
select count(distinct name) as 'count'
from animal_ins
where name is not null;

-- SUM,MAX,MIN/프로그래머스/Level2/동물 수 구하기
select count(animal_id) as 'count'
from animal_ins;

-- IS NULL/프로그래머스/Level1/이름이 있는 동물의 아이디
select animal_id
from animal_ins
where name is not null
order by animal_id asc;

-- SELECT/프로그래머스/Level1/상위 n개 레코드
select name
from animal_ins
order by datetime asc limit 1;

-- SELECT/프로그래머스/Level1/어린 동물 찾기
select animal_id, name
from animal_ins
where intake_condition != 'Aged'
order by animal_id asc;

-- SELECT/프로그래머스/Level1/동물의 아이디와 이름
select animal_id, name
from animal_ins
order by animal_id asc;

-- SELECT/프로그래머스/Level1/여러 기준으로 정렬하기
select animal_id, name, datetime
from animal_ins
order by name asc, datetime desc;

-- SELECT/프로그래머스/Level1/아픈 동물 찾기
select animal_id, name
from animal_ins
where intake_condition = 'Sick'
order by animal_id asc;

-- SELECT/프로그래머스/Level1/역순 정렬하기
select name, datetime
from animal_ins
order by animal_id desc;

-- String,Date/프로그래머스/Level2/이름에 el이 들어가는 동물 찾기
select animal_id, name
from animal_ins
where animal_type = 'Dog' and name like '%el%'
order by name asc;

-- GROUP BY/프로그래머스/Level2/동명 동물 수 찾기
select name, count(animal_id) as 'count'
from animal_ins
where name is not null
group by name
having count >= 2
order by name asc;

-- SELECT/프로그래머스/Level1/강원도에 위치한 생산공장 목록 출력하기
select factory_id, factory_name, address
from food_factory
where address like '강원도%'
order by factory_id asc;

-- IS NULL/프로그래머스/Level1/나이 정보가 없는 회원 수 구하기
select count(user_id) as 'USERS'
from user_info
where age is null;

-- IS NULL/프로그래머스/Level2/NULL 처리하기
-- IF NULL 사용
select animal_type, ifnull(name, 'No name') as 'name', sex_upon_intake
from animal_ins
order by animal_id asc;
-- CASE 사용
select
    animal_type,
    case
        when name is null then 'No name'
        else name
    end as 'name',
    sex_upon_intake
from animal_ins
order by animal_id asc;
-- COALESCE 사용
select animal_type, coalesce(name, 'No name') as 'name', sex_upon_intake
from animal_ins
order by animal_id asc;