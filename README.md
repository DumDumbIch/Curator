# Curator
Данное приложение является рабочим инструментом инженера сервисной службы (инженера-наладчика). Пишу это приложение для себя и своих коллег, т.к. клиентов инстаграмма и так навалом, а я не люблю пустой траты времени ;-)

Описание проблемы:
На контроле инженера находятся объекты (котельные, тепловые пункты, узлы учета энергоресурсов и т.п.) принадлежащие как частным так и юридическим лицам. Эти объекты необходимо регулярно обслуживать и контролировать их исправность в объеме, определяемом договором на обслуживание. Так же на объектах устанавливается оборудование системы диспетчеризации, которое извещает сервисного инженера и клиента о возникновении нештатной и аварийной ситуации, либо при отсутствии системы телеметрии инженеру может позвонить клиент или его представитель. В этом случае инженер обязан выехать на объект в установленный договором срок и произвести диагностику и по возможности устранить неисправность.

Архитектура: MVP
Сохранение состояния: Moxy
Навигация: Cicerone
Внедрение зависимостей: Dagger2
Реактивность: RxJava3
Работа с сетью: Retrofit2

Функционал:
Версия 1.0.х:
- база клиентов: заполняется вручную и сохраняется в локальной базе на устройстве (контактные данные, список передаваемых на обслуживание объектов)
- база объектов: заполняется вручную и сохраняется в локальной базе на устройстве (название, тип, список оборудования)
- выделение "зоны риска" - объектов, в районе расположения которых в соотвествии с прогнозом погоды ожидается резкое похолодание

Версия 1.1.х:
- звонок клиенту прямо из приложения с использованием встроенных функций OS Android
- журнал выполненных работ: заполняется вручную и сохраняется в локальной базе на устройстве
- синхронизация баз данных по объектам и клиентам инженеров сервисной службы - через Bluetooth или Email - намеренно пытаюсь обойтись без облака и сервера
- удаленный контроль объектов посредством системы телеметрии (перехват SMS-сообщений, парсинг и вывод уведомлений в удобной форме - существующие системы телеметрии страдают отсутствием "дружественного интерфейса", некоторые вообще присылают цифровые коды и нужно помнить, что они означают)

Версия 1.2.х:
- разделение инженеров по группам с выделением руководителя группы, который распределяет объекты между остальными инженерами
- формирование отчетов и отправка их по Email начальнику группы

Дальнейшее расширение функционала - по результатам тестирования в боевых условиях и просьбам коллег.


При необходимости масштабирования потребуется привязка к выделенному серверу:
Версия 2.0.х:
- фиксация заявок от клиентов - звонки в случае аварийной ситуации
- формирование и распределение заданий
- ведение общего журнала выполненных работ
- формирование месячных отчетов о выполненной работе
- централизованный контроль телеметрии объектов с оповещением ответственных за данный объект инженеров
- контроль исполнения текущих и аварийных заявок
