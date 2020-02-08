# Задание 
*	Добавить возможность сохранения нового объекта обеспечения - самолет (таблица AIRPLANE). При внесении изменений следует предусмотреть возможность добавления новых видов объектов обеспечения.
*	Добавить возможность получения информации о сохраненных самолетах (аналогично тому как это реализовано с автомобилями)
*	Добавить возможность добавлять ко всем объектам обеспечения стоимостные оценки. Для одного объекта обеспечения может быть несколько стоимостных оценок. Стоимостная оценка представляет собой некоторую сумму и время когда эта оценка проводилась. Все оценки должны храниться в БД. При передаче в ExternalApproveService должна использоваться последняя по дате стоимостная оценка для объекта.
Сейчас есть некоторая реализация стоимостной оценки для автомобилей: сумма хранится в таблице CAR вместе с остальными данными, а дата берется текущая. Нужно провести рефакторинг и так же вынести оценки для автомобилей в новую таблицу.
# Пояснения
*	Перед сохранением все объекты обеспечения должны быть проверены через ExternalApproveService (как в коде сейчас происходит для автомобилей)