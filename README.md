# Totalizator
1. Игрок
	- имя
	- фамилия
	- возраст
	- почта
	- логин
	- пароль
	1.1 Кошелёк(деньги на сайте)
		- уникальный ID
		- сумма
2. Регистрация
	2.1 создание Пользователя
	    	- проверка можно ли создать
	- закрепить уникальный Кошелёк за Пользователем

3. Спор
	- описание Условий спора(условие на выигрыш)
	- описание события (строковое описание спора - просто инфа о споре)
	- время (начало + конец спора)
	- список участников (за/против) (Пользователь, размер ставки, (коэицент ставки ???))
	3.1 Проверка условий спора // по идее должна быть отделена от спора
		- закончился или нет
		- кто выиграл

4.Временный банк(счёт)
	- сумма выиграша

5. Комиссия (заработок/налог биржы)
	- какой-то процент
	- скидки для пользователей ???	


6.Получение выигрыша
	- расчёт долей выигрыша
	- снятия комиссии

7. работа с Кошельком(транзакции)
	- перевод денег В временный банк при ставке
	- перечисление ИЗ временного банка (получение выиграша)
	- перечесление комиссии ???

8. Контролёр спора (Судья)
	- решает кто выиграл

9. Перевод денег на счёт пользователя ИЗВНЕ(биткоинты, банки, благотворительные фонды ...)

...
