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