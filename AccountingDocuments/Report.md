# **отчёт о проведённом тестировании**

## описание
Выполнена автоматизация тестирования веб-сервиса "Путешествие дня". 
Проверено:
* Возможность оплаты двумя способами (покупка по карте и покупка в кредит);
* Взаимодействие с банковским сервисом;
* Рабрта с СУБД (MySQL и PostgreSQL);
* Обработка ответов банковских сервисов
* визуализация верных уведомлений;
* выдача сообщений об ошибках при невалидном заполнении формы.

### количество тест-кейсов
Из 36 тест-кейсов: 8 не прошли, 28 прошли. 
Итого: 77,7% успешных тестов / 22,8% неуспешных тестов
[отчет Allure](http://172.17.192.1:55015/index.html)

### общие рекомендации
1. исправить найденые ошибки приложения [issues](https://github.com/EvgeniaZlobina/JourneyOfTheDay/issues) 
2. создать документацию на параметры заполнения полей формы
3. реализовать подцветку уведомлений об успешной покупке и ошибке при покупке разными цветами.
4. в операторы селекторов добавить test id