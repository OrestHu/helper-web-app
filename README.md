Це тестове завдання для BestHackathon. Тут реалізовано back-end
з використанням таких технологій як: Java 17, SpringBoot 3, PostgreSQL, Liquibase Maven 4

Всі запити надсилаються через Rest Controller за допомогою HTTP

Щоб запустити проект вам потрібно зайти в термінал щоб запустити Docker Container для бази
даних PostgreSQL. 

Напишіть в терміналі або в консолі: docker-compose up -d

Тепер ви може запустити проект зайшовши його в scr/main/java/com/horuz/test/horuz/test/webapp/HelpWebAppApplication

END-PONT

- /api/v1/authentication/login [POST] - Логін
- /api/v1/accounts/register [POST] - Реєстрація
- /api/v1/post/create [POST] - Створення посту для RECEIVER
- /api/v1/post/findAll [GET] - Пошук всіх постів для RECEIVER
- /api/v1/post/find/{text} [GET] - Пошук по Name для RECEIVER
- /api/v1/post/deletePost/{post_id} [DELETE] - Удалити пост для RECEIVER
- /api/v1/post/changePost/{post_id} [PATCH] - Редагувати пост для RECEIVER
- /api/v1/select/makeSelect [POST] - Добавити пости в збережене для HELPER
- /api/v1/select/findSelects [GET] - Получити всі збережені для HELPER
